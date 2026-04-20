package org.example.crud.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    private final ConfigurableApplicationContext context;

    // VARIABLE CRÍTICA: Para saber a qué tabla volver (Tanque, Healer o DPS)
    private String rolDeRetorno;

    public DetalleController(ConfigurableApplicationContext context) {
        this.context = context;
    }

    public void mostrarDetalle(Espec espec, String rol) {
        this.rolDeRetorno = rol;

        // 1. Configurar textos
        lblTitulo.setText(espec.getName().toUpperCase());
        txtDescripcionLarga.setText(espec.getDescripcion2());

        // 2. Intentar cargar la imagen
        try {
            String nombreClase = espec.getName().toLowerCase().trim();
            String nombreImg = nombreClase + ".png";
            var resource = getClass().getResource("/images/" + nombreImg);

            System.out.println("--- INICIANDO CARGA DE IMAGEN ---");

            if (resource != null) {
                String urlImagen = resource.toExternalForm();
                System.out.println("Archivo encontrado en: " + urlImagen);

                // Cargamos con 'backgroundLoading: false' para forzar a Java a leer los datos ahora mismo
                Image imagen = new Image(urlImagen, false);

                if (imagen.isError()) {
                    System.err.println("¡ERROR DE LECTURA! El archivo existe pero JavaFX no puede leerlo.");
                    System.err.println("Causa del error: " + imagen.getException().getMessage());
                    imgClase.setImage(null);
                } else {
                    imgClase.setImage(imagen);
                    // Si aquí da 0x0 es que el archivo físico está vacío o corrupto
                    System.out.println("IMAGEN CARGADA: " + imagen.getWidth() + "x" + imagen.getHeight());
                }
            } else {
                System.err.println("ERROR: No existe el archivo '/images/" + nombreImg + "' en resources.");
                imgClase.setImage(null);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado en el método mostrarDetalle:");
            e.printStackTrace();
        }
        System.out.println("--- FIN DEL PROCESO DE IMAGEN ---");
    }

    @FXML
    private void volverALista(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClasesView.fxml"));
            loader.setControllerFactory(context::getBean);
            Parent root = loader.load();

            ClasesController controller = loader.getController();
            // Usamos el rol que guardamos para que la tabla no salga vacía ni de error
            controller.actualizarTablaPorRol(this.rolDeRetorno);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 1000, 700));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}