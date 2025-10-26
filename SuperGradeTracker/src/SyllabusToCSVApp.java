import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;
import java.util.*;

public class SyllabusToCSVApp extends Application {

    private TextArea syllabusArea;
    private Label statusLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Syllabus to CSV Grade Tracker");

        syllabusArea = new TextArea();
        syllabusArea.setPromptText("Paste your syllabus here...");
        syllabusArea.setPrefRowCount(15);

        Button generateButton = new Button("Generate CSV");
        generateButton.setOnAction(e -> handleGenerate(primaryStage));

        statusLabel = new Label();

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(
                new Label("Paste your syllabus below:"),
                syllabusArea,
                generateButton,
                statusLabel
        );

        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleGenerate(Stage stage) {
        String text = syllabusArea.getText();
        if (text.isBlank()) {
            statusLabel.setText("❌ Please paste your syllabus first.");
            return;
        }

        List<String[]> parsed = parseSyllabus(text);
        if (parsed.isEmpty()) {
            statusLabel.setText("❌ Couldn’t find any 'Assessment - 20%' patterns.");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        var file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("Assessment,Weight (%),Grade (%)\n");
                for (String[] row : parsed) {
                    writer.write(String.join(",", row[0], row[1], "") + "\n");
                }
                statusLabel.setText("✅ CSV created: " + file.getName());
            } catch (IOException ex) {
                statusLabel.setText("⚠️ Error saving file: " + ex.getMessage());
            }
        }
    }

    private List<String[]> parseSyllabus(String text) {
        List<String[]> results = new ArrayList<>();
        Pattern pattern = Pattern.compile("([\\w\\s]+)\\s*[-:]\\s*(\\d+)%");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String name = matcher.group(1).trim();
            String weight = matcher.group(2).trim();
            results.add(new String[]{name, weight});
        }
        return results;
    }

    public static void main(String[] args) {
        launch(args);
    }
}