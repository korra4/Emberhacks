package ca.utoronto.utm.SuperGradeTracker;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SyllabusModel {

    // Extract text from PDF using PDFBox
    public String extractTextFromPDF(File file) throws IOException {
        try (PDDocument document = PDDocument.load(file)) {
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document);
        }
    }

    // Parse the text for assessments and weights
    public List<String[]> parseSyllabus(String text) {
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

    // Save to CSV
    public void saveCSV(File file, List<String[]> data) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Assessment,Weight (%),Grade (%)\n");
            for (String[] row : data) {
                writer.write(String.join(",", row[0], row[1], "") + "\n");
            }
        }
    }
}