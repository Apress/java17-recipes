package org.java17recipes.chapter16.recipe16_05;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SyncResp {
    try {
        HttpResponse resp = HttpRequest.create(new URI("http://www.apress.com/us/")).GET().response();
        int statusCode = resp.statusCode();
        String body = resp.body(HttpResponse.asString());
        System.out.println("Status Code: " + statusCode);
        // Do something with body text
    } catch (URISyntaxException | IOException | InterruptedException ex) {
        Logger.getLogger(HttpClient.class.getName()).log(Level.SEVERE, null, ex);
    }

}
public void SyncResp(String uri) throws Exception {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create("http://www.apress.com/us/")).GET().response();

    HttpResponse<String> response =
          client.send(request, BodyHandlers.ofString());

    System.out.println(response.body());
}