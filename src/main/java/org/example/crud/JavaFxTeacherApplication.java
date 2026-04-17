package org.example.crud;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.example.crud.Controller.TeacherController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaFxTeacherApplication extends Application {

    private ConfigurableApplicationContext springContext;


    @Override
    public void init() {
        springContext = new SpringApplicationBuilder(JavaFxTeacherApplication.class).run();
    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/teacher-view.fxml"));
        VBox root = loader.load();


        TeacherController controller = loader.getController();
        controller.setSpringContext(springContext);

        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("Teacher CRUD");
        stage.show();
    }

    @Override
    public void stop() {
        springContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
