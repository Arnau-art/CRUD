package org.example.crud;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaFxTeacherApplication extends Application {

    private ConfigurableApplicationContext springContext;

    @Override
    public void init() {
        // Arrancamos el contexto de Spring Boot al iniciar la app
        springContext = new SpringApplicationBuilder(JavaFxTeacherApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {
        // Cargamos el FXML de las clases/especializaciones
        // Asegúrate de que la ruta coincida con tu carpeta resources
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ClasesView.fxml"));

        /* * LÍNEA CRÍTICA: Esto le dice a JavaFX que cuando necesite crear un controlador,
         * se lo pida a Spring. Así, los @Autowired y constructores de tus controladores funcionarán.
         */
        loader.setControllerFactory(springContext::getBean);

        Parent root = loader.load();
        Scene scene = new Scene(root);

        stage.setTitle("WoW Database - Rankings & Export");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() {
        // Cerramos Spring al cerrar la ventana de JavaFX
        springContext.close();
        Platform.exit();
    }

    public static void main(String[] args) {
        // Lanzamos la aplicación de JavaFX
        launch(args);
    }
}