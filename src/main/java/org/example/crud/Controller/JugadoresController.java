package org.example.crud.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.crud.Entity.Jugador;
import org.example.crud.Service.JugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class JugadoresController {

    @FXML private TableView<Jugador> tblJugadores;
    @FXML private TableColumn<Jugador, String> colNombre;
    @FXML private TableColumn<Jugador, String> colReino;
    @FXML private TableColumn<Jugador, String> colClase;
    @FXML private TableColumn<Jugador, String> colEspecializacion;
    @FXML private TableColumn<Jugador, Integer> colPuntuacion;

    @FXML private TextField txtNombre;
    @FXML private TextField txtReino;
    @FXML private TextField txtRegion;
    @FXML private TextField txtClase;
    @FXML private TextField txtEspecializacion;
    @FXML private TextField txtPuntuacion;

    @FXML private Button btnAñadir;
    @FXML private Button btnCargarRaiderIO;
    @FXML private Button btnExportarCSV;

    @Autowired
    private JugadorService jugadorService;

    private String claseEntrada;
    private String especializacionEntrada;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getNombre()));
        colReino.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getReino()));
        colClase.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getClase()));
        colEspecializacion.setCellValueFactory(d -> new javafx.beans.property.SimpleStringProperty(d.getValue().getEspecializacion()));
        colPuntuacion.setCellValueFactory(d -> new javafx.beans.property.SimpleIntegerProperty(
                d.getValue().getPuntuacion() == null ? 0 : d.getValue().getPuntuacion()).asObject());

        txtClase.setEditable(false);
        txtEspecializacion.setEditable(false);
        txtPuntuacion.setEditable(false);

        btnAñadir.setOnAction(e -> onBtnAñadir());
        btnCargarRaiderIO.setOnAction(e -> cargarDesdeRaiderIO());
        btnExportarCSV.setOnAction(e -> exportarCSV());
    }

    public void setClase(String clase) {
        this.claseEntrada = clase;
        txtClase.setText(clase);
        cargarDatos();
    }

    public void setEspecializacionEntrada(String especializacionEntrada) {
        this.especializacionEntrada = especializacionEntrada;
    }

    private void cargarDatos() {
        if (claseEntrada == null || claseEntrada.isBlank()) return;
        List<Jugador> jugadores = jugadorService.listarJugadoresPorClase(claseEntrada);
        ObservableList<Jugador> lista = FXCollections.observableArrayList(jugadores);
        tblJugadores.setItems(lista);
    }

    @FXML
    private void onBtnAñadir() {
        String nombre = txtNombre.getText().trim();
        String reino = txtReino.getText().trim();
        String region = txtRegion.getText().trim();
        String especializacion = txtEspecializacion.getText().trim();
        String puntuacionText = txtPuntuacion.getText().trim();

        if (nombre.isEmpty() || reino.isEmpty() || especializacion.isEmpty() || puntuacionText.isEmpty()) {
            mostrarError("Faltan datos", "Primero carga los datos desde Raider.IO.");
            return;
        }

        Integer puntuacion;
        try {
            puntuacion = Integer.parseInt(puntuacionText);
        } catch (NumberFormatException e) {
            mostrarError("Error", "La puntuación no es válida.");
            return;
        }

        try {
            Jugador jugador = jugadorService.guardarJugadorConValidacion(
                    nombre, reino, region, claseEntrada, especializacion, puntuacion
            );
            tblJugadores.getItems().add(jugador);
            limpiarCampos();
            mostrarInfo("Guardado", "Jugador guardado correctamente.");
        } catch (IllegalArgumentException ex) {
            mostrarError("Validación", ex.getMessage());
        }
    }

    @FXML
    private void cargarDesdeRaiderIO() {
        String nombre = txtNombre.getText().trim();
        String reino = txtReino.getText().trim();
        String region = txtRegion.getText().trim();

        if (nombre.isEmpty() || reino.isEmpty()) {
            mostrarError("Datos incompletos", "Escribe nombre y reino.");
            return;
        }

        if (region.isEmpty()) {
            region = "eu";
            txtRegion.setText("EU");
        }

        try {
            String nombreCodificado = URLEncoder.encode(nombre, StandardCharsets.UTF_8);
            String reinoCodificado = URLEncoder.encode(reino, StandardCharsets.UTF_8);

            String url = "https://raider.io/api/v1/characters/profile?region="
                    + region.toLowerCase()
                    + "&realm=" + reinoCodificado
                    + "&name=" + nombreCodificado;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                mostrarError("Error al consultar Raider.IO", "Código HTTP: " + response.statusCode());
                return;
            }

            RaiderIoData data = parseRaiderIoResponse(response.body());

            if (especializacionEntrada != null && !especializacionEntrada.isBlank()) {
                if (data.especializacion == null || !data.especializacion.equalsIgnoreCase(especializacionEntrada)) {
                    mostrarError("Especialización incorrecta",
                            "Especialización Raider.IO: " + data.especializacion + "\nEsperada: " + especializacionEntrada);
                    return;
                }
            }

            txtEspecializacion.setText(data.especializacion == null ? "" : data.especializacion);
            txtPuntuacion.setText(String.valueOf(data.ioScore));

            mostrarInfo("OK", "Datos cargados desde Raider.IO.");
        } catch (Exception ex) {
            mostrarError("Error al consultar Raider.IO", ex.getMessage());
        }
    }

    private RaiderIoData parseRaiderIoResponse(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        String especializacion = root.path("active_spec_name").asText(null);
        if (especializacion == null || especializacion.isBlank()) {
            especializacion = root.path("class").asText(null);
        }

        int ioScore = root.path("mythic_plus_scores").path("all").asInt(0);
        return new RaiderIoData(especializacion, ioScore);
    }

    private void exportarCSV() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Guardar CSV");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV", "*.csv"));
        File file = chooser.showSaveDialog(new Stage());
        if (file == null) return;

        try (PrintWriter writer = new PrintWriter(file, StandardCharsets.UTF_8)) {
            writer.println("Nombre,Reino,Region,Clase,Especializacion,Puntuacion");
            for (Jugador j : jugadorService.listarTodosLosJugadores()) {
                writer.printf("%s,%s,%s,%s,%s,%s%n",
                        safe(j.getNombre()),
                        safe(j.getReino()),
                        safe(j.getRegion()),
                        safe(j.getClase()),
                        safe(j.getEspecializacion()),
                        j.getPuntuacion() == null ? "" : j.getPuntuacion());
            }
            mostrarInfo("Exportado", "CSV generado correctamente.");
        } catch (Exception e) {
            mostrarError("Error exportando CSV", e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtNombre.clear();
        txtReino.clear();
        txtRegion.clear();
        txtEspecializacion.clear();
        txtPuntuacion.clear();
    }

    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private String safe(String value) {
        if (value == null) return "";
        return value.replace(",", " ");
    }

    private static class RaiderIoData {
        final String especializacion;
        final int ioScore;

        RaiderIoData(String especializacion, int ioScore) {
            this.especializacion = especializacion;
            this.ioScore = ioScore;
        }
    }
}