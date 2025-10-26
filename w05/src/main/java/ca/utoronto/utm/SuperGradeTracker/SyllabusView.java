package ca.utoronto.utm.SuperGradeTracker;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class SyllabusView extends VBox {

    private Button selectPDFButton = new Button("Select Syllabus PDF");
    private Button generateCSVButton = new Button("Generate CSV");
    private Label fileLabel = new Label("No file selected");
    private Label statusLabel = new Label();

    public SyllabusView() {
        this.setSpacing(10);
        this.setPadding(new Insets(10));

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