package ca.utoronto.utm.SuperGradeTracker;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SyllabusController {

    private final SyllabusModel model;
    private final SyllabusView view;
    private final Stage stage;

    public SyllabusController(SyllabusModel model, SyllabusView view, Stage stage) {
        this.model = model;
        this.view = view;
        this.stage = stage;

        view.getGenerateButton().setOnAction(e -> handleGenerate());
    }

    private void handleGenerate() {
        String text = view.getSyllabusArea().getText();
        if (text.isBlank()) {
            view.getStatusLabel().setText("❌ Please paste your syllabus first.");
            return;
        }

        List<String[]> parsed = model.parseSyllabus(text);
        if (parsed.isEmpty()) {
            view.getStatusLabel().setText("❌ Couldn’t find any 'Assessment - 20%' patterns.");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save CSV File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) {
            try {
                model.saveCSV(file, parsed);
                view.getStatusLabel().setText("✅ CSV created: " + file.getName());
            } catch (IOException ex) {
                view.getStatusLabel().setText("⚠️ Error saving file: " + ex.getMessage());
            }
        }
    }
}