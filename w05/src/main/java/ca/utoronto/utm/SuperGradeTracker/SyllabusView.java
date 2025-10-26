package ca.utoronto.utm.SuperGradeTracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class SyllabusView extends VBox {

    private Button selectPDFButton = new Button("Select Syllabus PDF");
    private Button generateCSVButton = new Button("Generate CSV");
    private Label fileLabel = new Label("No file selected");
    private Label statusLabel = new Label();

    public SyllabusView() {
        this.setSpacing(25);
        this.setPadding(new Insets(20));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-font-size: 36px;");

        this.setStyle(this.getStyle() + " -fx-background-color: linear-gradient(to bottom right, #bdcff8, #a6d7e6);");


        // 🔹 Hover + Click Interactions for Buttons
        selectPDFButton.setOnMouseEntered(e -> selectPDFButton.setStyle(
                "-fx-background-color: #66BB6A; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"
        ));
        selectPDFButton.setOnMouseExited(e -> selectPDFButton.setStyle(
                "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 1.0; -fx-scale-y: 1.0;"
        ));
        selectPDFButton.setOnMousePressed(e -> selectPDFButton.setStyle(
                "-fx-background-color: #388E3C; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 0.97; -fx-scale-y: 0.97;"
        ));
        selectPDFButton.setOnMouseReleased(e -> selectPDFButton.setStyle(
                "-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 1.0; -fx-scale-y: 1.0;"
        ));

        generateCSVButton.setOnMouseEntered(e -> generateCSVButton.setStyle(
                "-fx-background-color: #42A5F5; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"
        ));
        generateCSVButton.setOnMouseExited(e -> generateCSVButton.setStyle(
                "-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 1.0; -fx-scale-y: 1.0;"
        ));
        generateCSVButton.setOnMousePressed(e -> generateCSVButton.setStyle(
                "-fx-background-color: #1976D2; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 0.97; -fx-scale-y: 0.97;"
        ));
        generateCSVButton.setOnMouseReleased(e -> generateCSVButton.setStyle(
                "-fx-background-color: #2196F3; -fx-text-fill: white; -fx-font-weight: bold; " +
                        "-fx-background-radius: 8; -fx-padding: 8 16; -fx-cursor: hand; -fx-scale-x: 1.0; -fx-scale-y: 1.0;"
        ));


        selectPDFButton.setStyle(
                "-fx-background-color: #4CAF50; " +  // green
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 8; " +
                        "-fx-padding: 8 16; " +
                        "-fx-cursor: hand;"
        );

        generateCSVButton.setStyle(
                "-fx-background-color: #2196F3; " +  // blue
                        "-fx-text-fill: white; " +
                        "-fx-font-weight: bold; " +
                        "-fx-background-radius: 8; " +
                        "-fx-padding: 8 16; " +
                        "-fx-cursor: hand;"
        );



        this.getChildren().addAll(
                new Label("Upload your syllabus PDF:"),
                selectPDFButton,
                fileLabel,
                generateCSVButton,
                statusLabel
        );
    }

    public Button getSelectPDFButton() { return selectPDFButton; }
    public Button getGenerateCSVButton() { return generateCSVButton; }
    public Label getFileLabel() { return fileLabel; }
    public Label getStatusLabel() { return statusLabel; }
}