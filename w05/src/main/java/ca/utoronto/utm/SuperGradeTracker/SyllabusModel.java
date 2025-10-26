package ca.utoronto.utm.SuperGradeTracker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class SyllabusModel {

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

    public void saveCSV(File file, List<String[]> data) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("Assessment,Weight (%),Grade (%)\n");
            for (String[] row : data) {
                writer.write(String.join(",", row[0], row[1], "") + "\n");
            }
        }
    }
}