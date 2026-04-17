package org.example.crud.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MenuController {

    private final ConfigurableApplicationContext context;

    public MenuController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @FXML
    private void seleccionarRol(ActionEvent event) {
        // 1. Detectamos qué botón se ha pulsado
        Button botonPulsado = (Button) event.getSource();
        String rolSeleccionado = botonPulsado.getText(); // Esto devolverá "TANQUE", "HEALER" o "DPS"

        try {
            // 2. Cargamos la vista de la tabla
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClasesView.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();

            // 3. Obtenemos el controlador de la tabla y le pasamos el rol para filtrar
            ClasesController clasesController = loader.getController();
            clasesController.actualizarTablaPorRol(rolSeleccionado);

            // 4. Cambiamos la ventana
            Stage stage = (Stage) botonPulsado.getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}