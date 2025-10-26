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
    private File selectedPDF;

    public SyllabusController(SyllabusModel model, SyllabusView view, Stage stage) {
        this.model = model;
        this.view = view;
        this.stage = stage;

        view.getSelectPDFButton().setOnAction(e -> handleSelectPDF());
        view.getGenerateCSVButton().setOnAction(e -> handleGenerateCSV());
    }

    private void handleSelectPDF() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
        selectedPDF = fileChooser.showOpenDialog(stage);

        if (selectedPDF != null) {
            view.getFileLabel().setText("Selected: " + selectedPDF.getName());
        } else {
            view.getFileLabel().setText("No file selected");
        }
    }

    private void handleGenerateCSV() {
        if (selectedPDF == null) {
            view.getStatusLabel().setText("❌ Please select a PDF first.");
            return;
        }

        try {
            String parsed = model.generateCSVFromPDF(selectedPDF);

            if (parsed.isEmpty()) {
                view.getStatusLabel().setText("❌ Could not find any assessment patterns in the PDF.");
                return;
            }

            FileChooser saveChooser = new FileChooser();
            saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
            File csvFile = saveChooser.showSaveDialog(stage);

            if (csvFile != null) {
                model.saveCSV(csvFile, parsed);
                view.getStatusLabel().setText("✅ CSV created: " + csvFile.getName());
            }

        } catch (IOException ex) {
            view.getStatusLabel().setText("⚠️ Error reading PDF: " + ex.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}