import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AuthenticationFilter {

    public static void main(String[] args) {
        // Replace with your actual JWT token
        String jwtToken = "your_jwt_token_here";

        // Replace with your target URL
        String targetUrl = "http://127.0.0.1:8080/com.bookmark_bookmark_war_1.0-SNAPSHOTPU";

        try {
            // Create a URL object with the target URL
            URL url = new URL(targetUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the request method to GET (or any other method you need)
            connection.setRequestMethod("GET");

            // Set the Authorization header with the JWT token
            connection.setRequestProperty("Authorization", "Bearer " + jwtToken);

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Read and print the response from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Close the connection
            connection.disconnect();

            // Print the response
            System.out.println("Response Code: " + responseCode);
            System.out.println("Response Body: " + response.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
