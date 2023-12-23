import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class GPT2InferencePlugin {

    private static final String OPENAI_API_URL = "https://api-inference.huggingface.co/models/gpt2";
    private static final String OPENAI_API_KEY = "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";  // Replace with your OpenAI API key

    public static String generateText(String prompt) throws IOException {
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(OPENAI_API_URL);

        // Set headers
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + OPENAI_API_KEY);
        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");

        // Set request body
        String requestBody = "{ \"prompt\": \"" + prompt + "\", \"max_tokens\": 100 }";
        httpPost.setEntity(new StringEntity(requestBody));

        // Execute the request
        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        // Process the response
        if (entity != null) {
            String result = EntityUtils.toString(entity);
            EntityUtils.consume(entity);
            return result;
        }

        return null;
    }

    public static void main(String[] args) {
        try {
            String prompt = "Write code to";
            String generatedText = generateText(prompt);

            if (generatedText != null) {
                System.out.println("Generated text: " + generatedText);
            } else {
                System.out.println("Failed to generate text.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

