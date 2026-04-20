package org.example.crud.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    private final ConfigurableApplicationContext context;

    // VARIABLE CRÍTICA: Guarda el rol actual para no perderlo al ir y volver
    private String rolActual;

    public ClasesController(WoWService wowService, ConfigurableApplicationContext context) {
        this.wowService = wowService;
        this.context = context;
    }

    @FXML
    public void initialize() {
        // Configuración de columnas
        colEspec.setCellValueFactory(new PropertyValueFactory<>("name"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colClase.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getClase() != null ?
                        cellData.getValue().getClase().getName() : "N/A"));
    }

    // Método que llama el Menú y el DetalleController
    public void actualizarTablaPorRol(String rol) {
        if (rol == null) return;
        this.rolActual = rol;

        String filtro = rol.trim().toUpperCase();
        // Ajuste por si en tu DB el rol se llama TANK en vez de TANQUE


        List<Espec> lista = wowService.getEspecsPorRol(filtro);
        tablaEspecs.setItems(FXCollections.observableArrayList(lista));
    }

    @FXML
    private void onFilaSeleccionada(MouseEvent event) {
        // Detecta doble clic para abrir la imagen
        if (event.getClickCount() == 2) {
            Espec seleccionada = tablaEspecs.getSelectionModel().getSelectedItem();
            if (seleccionada != null) {
                irADetalle(seleccionada);
            }
        }
    }

    private void irADetalle(Espec espec) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/DetalleView.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();

            DetalleController controller = loader.getController();
            // Le pasamos el objeto y el rol que estamos viendo ahora
            controller.mostrarDetalle(espec, this.rolActual);

            Stage stage = (Stage) tablaEspecs.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void volverMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/MenuView.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}