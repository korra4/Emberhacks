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
        this.setSpacing(20);
        this.setPadding(new Insets(10));
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-font-size: 36px;");



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