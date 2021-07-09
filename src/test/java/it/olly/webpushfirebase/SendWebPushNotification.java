package it.olly.webpushfirebase;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

import org.junit.jupiter.api.Test;

// @SpringBootTest
public class SendWebPushNotification {

	@Test
	public void sentNotification() throws Exception {
		String SERVER_KEY="<your-server-key-from-cloud-messaging-config>";
		String DEVICE_REG_TOKEN="<device-token-you-get-on-webpage>";
		String SERVICE_URL = "https://fcm.googleapis.com/fcm/send";
		String data = "{\n"
				+ "	  \"data\": {\n"
				+ "	    \"notification\": {\n"
				+ "	        \"title\": \"FCM Message\",\n"
				+ "	        \"body\": \"This is an FCM Message - "+System.currentTimeMillis()+"\",\n"
				+ "	        \"icon\": \"/itwonders-web-logo.png\",\n"
				+ "	    }\n"
				+ "	  },\n"
				+ "	  \"to\": \""+DEVICE_REG_TOKEN+"\"\n"
				+ "	}";
		
		HttpClient client = HttpClient.newHttpClient();
		
		HttpRequest request = HttpRequest.newBuilder()
			      .uri(URI.create(SERVICE_URL))
			      .timeout(Duration.ofMinutes(1))
			      .header("Authorization", "key="+SERVER_KEY)
			      .header("Content-Type", "application/json")
			      .POST(BodyPublishers.ofString(data))
			      .build();
		
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());
	}

}
