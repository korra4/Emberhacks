package ca.utoronto.utm.SuperGradeTracker;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.*;
import java.util.*;
import java.util.regex.*;

import com.google.genai.*;
import com.google.genai.types.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SyllabusModel {

    // Send the PDF directly to Gemini and get CSV
    public String generateCSVFromPDF(File pdfFile) throws IOException {
        String apiKey = System.getenv("GOOGLE_API_KEY");
        if (apiKey == null) {
            throw new IOException("Missing GOOGLE_API_KEY environment variable");
        }

        // Initialize Gemini Pro (supports text + PDF)
        GenerativeModel model = new GenerativeModel.Builder()
                .model("gemini-1.5-pro")
                .apiKey(apiKey)
                .build();

        // Prompt Gemini to extract grade data from the PDF
        String prompt = """
            You are a syllabus parser. Read this PDF syllabus and convert all assessment information
            into CSV format with the following columns:
            Assessment, Weight (%), Grade (%)
            Only output valid CSV — no explanations or extra text.
        """;

        // Combine the text prompt and the PDF file in one request
        GenerateContentResponse response = model.generateContent(
                new GenerateContentRequest.Builder()
                        .addContent(Content.ofText(prompt))
                        .addContent(Content.ofFile(pdfFile))
                        .build()
        );

        String csvOutput = response.getText();
        if (csvOutput == null || csvOutput.isBlank()) {
            throw new IOException("Gemini API returned empty CSV output.");
        }

        return csvOutput.trim();
    }

    // Save CSV text to file
    public void saveCSV(File file, String csvText) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(csvText);
        }
    }
}