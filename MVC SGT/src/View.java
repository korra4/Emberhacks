package ca.utoronto.utm.balloonmvc;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class SyllabusView extends VBox {

    private TextArea syllabusArea = new TextArea();
    private Button generateButton = new Button("Generate CSV");
    private Label statusLabel = new Label();

    public SyllabusView() {
        this.setSpacing(10);
        this.setPadding(new Insets(10));

        syllabusArea.setPromptText("Paste your syllabus here...");
        syllabusArea.setPrefRowCount(15);

        this.getChildren().addAll(
                new Label("Paste your syllabus below:"),
                syllabusArea,
                generateButton,
                statusLabel
        );
    }

    public TextArea getSyllabusArea() {
        return syllabusArea;
    }

    public Button getGenerateButton() {
        return generateButton;
    }

    public Label getStatusLabel() {
        return statusLabel;
    }
}