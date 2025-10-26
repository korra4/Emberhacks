package ca.utoronto.utm.SuperGradeTracker;

import com.google.genai.types.Part;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.*;

import com.google.genai.Client;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentResponse;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SyllabusModel {

    // Send the PDF directly to Gemini and get CSV
    public String generateCSVFromPDF(File pdfFile) throws Exception {
        // String apiKey = System.getenv("GOOGLE_API_KEY");
        String apiKey = "AIzaSyAOKSQAM66mH9zbAVBlPI9Xld2L-FfOcu8";
        if (apiKey == null) {
            throw new IOException("Missing GOOGLE_API_KEY environment variable");
        }

        // Initialize Gemini Client (supports text + PDF)
        Client client = new Client.Builder()
                .apiKey(apiKey)
                .build();

        // Prompt Gemini to extract grade data from the PDF
        String prompt = """
            You are a syllabus parser. Read this PDF syllabus and convert all assessment information
            into CSV format with the following columns:
            Assessment, Weight (%), Grade (%)
            Only output valid CSV — no explanations or extra text.
        """;
        byte[] pdfBytes = Files.readAllBytes(pdfFile.toPath());

        Content content = Content.fromParts(
                Part.fromBytes(pdfBytes, "application/pdf"),
                Part.fromText(prompt));

        // Combine the text prompt and the PDF file in one request
        GenerateContentResponse response = client.models.generateContent("models/gemini-2.5-flash",
                        content, null);


//        Path pdfPath = pdfFile.toPath();
//        String publicUrl = PdfUploader.uploadPdf(pdfPath);

//        Content content = Content.fromParts(
//                Part.fromUri(publicUrl, "application/pdf"),
//                Part.fromText(prompt)
//        );
//        GenerateContentResponse response = client.models.generateContent("models/gemini-2.5-flash", content, null);

        String csvOutput = response.text();
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