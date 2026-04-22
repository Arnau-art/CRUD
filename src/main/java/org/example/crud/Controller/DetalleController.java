package org.example.crud.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.example.crud.Entity.Espec;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DetalleController {

    @FXML private Label lblTitulo;
    @FXML private TextArea txtDescripcionLarga;
    @FXML private ImageView imgClase;

    @FXML private Button btnJugadores;

    private final ConfigurableApplicationContext context;
    private String rolDeRetorno;
    private Espec espec;

    public DetalleController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void mostrarDetalle(Espec espec, String rol) {
        this.rolDeRetorno = rol;
        this.espec = espec;

        lblTitulo.setText(espec.getName().toUpperCase());
        txtDescripcionLarga.setText(espec.getDescripcion2());

        try {
            String nombreClase = espec.getName().toLowerCase().trim();
            String nombreImg = nombreClase + ".png";
            var resource = getClass().getResource("/images/" + nombreImg);

            if (resource != null) {
                String urlImagen = resource.toExternalForm();
                Image imagen = new Image(urlImagen, false);
                if (!imagen.isError()) {
                    imgClase.setImage(imagen);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void volverALista(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClasesView.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();

            ClasesController controller = loader.getController();
            controller.actualizarTablaPorRol(this.rolDeRetorno);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        btnJugadores.setOnAction(e -> abrirVentanaJugadores());
    }

    @FXML
    private void abrirVentanaJugadores() {
        String claseSeleccionada = espec.getClase().getName().trim();

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/JugadoresView.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();

            JugadoresController controller = loader.getController();
            controller.setClase(claseSeleccionada);
            controller.setEspecializacionEntrada(espec.getName());

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Jugadores - " + claseSeleccionada);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}