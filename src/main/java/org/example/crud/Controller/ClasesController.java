package org.example.crud.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.crud.Entity.Espec;
import org.example.crud.Service.WoWService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ClasesController {

    @FXML private TableView<Espec> tablaEspecs;
    @FXML private TableColumn<Espec, String> colClase;
    @FXML private TableColumn<Espec, String> colEspec;
    @FXML private TableColumn<Espec, String> colDesc;

    private final WoWService wowService;
    private final ConfigurableApplicationContext context; // Necesario para volver al menú

    public ClasesController(WoWService wowService, ConfigurableApplicationContext context) {
        this.wowService = wowService;
        this.context = context;
    }

    @FXML
    public void initialize() {
        // Configuramos cómo se ven las columnas
        colEspec.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colClase.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getClase() != null ?
                        cellData.getValue().getClase().getName() : "N/A"));
    }

    // Este es el método que llama el MenuController
    public void actualizarTablaPorRol(String rol) {
        String filtro = rol;
        // Ajuste por si en tu DB pusiste TANK en vez de TANQUE
        if (rol.equalsIgnoreCase("TANQUE")) filtro = "TANK";

        List<Espec> lista = wowService.getEspecsPorRol(filtro);
        tablaEspecs.setItems(FXCollections.observableArrayList(lista));
    }

    // EL MÉTODO QUE FALTABA: Para volver a la pantalla principal
    @FXML
    private void volverMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MenuView.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();

            // Obtenemos la ventana actual a través del botón que pulsamos
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onExportarCsv() {
        // Aquí iría tu lógica de exportar que ya tenías
        System.out.println("Exportando a CSV...");
    }
}