package org.java17recipes.chapter16.recipe16_05;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.util.concurrent.ExecutionException;

public class AsyncResp() {
	public static void main(String[] args) {
		try {
			CompletableFuture<HttpResponse> cf = HttpRequest.create(
					new URI("http://www.apress.com/us/")).GET().responseAsync();
			System.out.println("Request made...");
			System.out.println("Check if done...");
			while (!cf.isDone()) {
				System.out.println("Perform some other tasks while waiting...");
				// Periodically check CompletableFuture.isDone()
			}
			System.out.println("Response Received:");
			HttpResponse response = cf.get();
			int statusCode = response.statusCode();
			System.out.println("Status Code: " + statusCode);
			String body = response.body(HttpResponse.asString());
			// Do something with body text
		} catch (URISyntaxException | InterruptedException | ExecutionException ex) {
			System.out.println(ex);
		}
	}
}
