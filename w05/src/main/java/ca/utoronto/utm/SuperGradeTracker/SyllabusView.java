package ca.utoronto.utm.SuperGradeTracker;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.util.Objects;

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
        this.setStyle(this.getStyle() + " -fx-border-color: rgba(255,255,255,0.3); -fx-border-radius: 20; -fx-border-width: 2;");


        System.out.println(getClass().getResource("/ca/utoronto/utm/SuperGradeTracker/SuperGradeTracker.png"));
        ImageView logoView = new ImageView(
                new Image(Objects.requireNonNull(
                        getClass().getResourceAsStream("/ca/utoronto/utm/SuperGradeTracker/SuperGradeTracker.png")
                ))
        );
        logoView.setFitWidth(150);  // adjust width
        logoView.setPreserveRatio(true); // keep aspect ratio

        Label titleLabel = new Label("Super Grade Tracker");
        titleLabel.setStyle("-fx-font-size: 67px; -fx-font-weight: bold; -fx-text-fill: #2c3e50;");

        HBox headerBox = new HBox(15); // spacing between logo and text
        headerBox.setAlignment(Pos.CENTER);
        headerBox.getChildren().addAll(logoView, titleLabel);
        VBox.setMargin(headerBox, new Insets(0, 0, 40, 0)); // top, right, bottom, left

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
                headerBox,
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