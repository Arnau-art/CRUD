package org.example.crud.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.crud.Service.WoWService;
import org.springframework.stereotype.Component;

@Component
public class MainController {

    private final WoWService wowService;

    public MainController(WoWService wowService) {
        this.wowService = wowService;
    }

    @FXML
    private void onSeleccionarRol(ActionEvent event) {

        String rolElegido = ((Button) event.getSource()).getText();

        try {

            var especs = wowService.getEspecsPorRol(rolElegido);


            System.out.println("Cargando clases para: " + rolElegido);


        } catch (Exception e) {
            mostrarError("Error de Base de Datos", e.getMessage());
        }
    }

    private void mostrarError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}