package ca.utoronto.utm.balloonmvc;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SyllabusToCSVApp extends Application {
    @Override
    public void start(Stage stage) {
        SyllabusModel model = new SyllabusModel();
        SyllabusView view = new SyllabusView();
        new SyllabusController(model, view, stage);

        Scene scene = new Scene(view, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Syllabus to CSV Grade Tracker");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}