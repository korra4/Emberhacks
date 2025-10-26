package ca.utoronto.utm.SuperGradeTracker;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

public class GenerateContentWithTextInput {
    public static void main(String[] args) {

        Client client = Client.builder().apiKey("AIzaSyAOKSQAM66mH9zbAVBlPI9Xld2L-FfOcu8").build();

        GenerateContentResponse response =
                client.models.generateContent("gemini-2.5-flash", "How does AI work?", null);

        System.out.println(response.text());
    }
}
