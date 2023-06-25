package inc.pnw.db;

import java.util.Map;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;


public class ApiIntegrationHandler {

//Create an HTTP client
CloseableHttpClient httpClient = HttpClients.createDefault();

//Prepare the API request
static String url; 
static HttpGet request;

//Set the Authorization header with your API key and secret
static String apiKey = "API_KEY";
static String apiSecret = "API_SECRET";
static String accessKey = "ACCESS_KEY";
  
private static String getCredentials() {
    apiKey = System.getenv("API_KEY");
    apiSecret = System.getenv("API_SECRET");
    
    String authHeader = apiKey + ":" + apiSecret;

    return authHeader;
    
  }
  
  public static void authorizeCredentials() throws ClientProtocolException, IOException {


    
  }
  
  public static void main(String[] args) {
    
    populateDBWithCities();
    
  }
  
  public static void populateDBWithCities() {
    
    // Create an HttpClient
    CloseableHttpClient httpClient = HttpClients.createDefault();
    accessKey = System.getenv("ACCESS_KEY");

    url = "http://api.aviationstack.com/v1/cities?access_key=" + accessKey;
    // Create an HttpGet request with the URL
    HttpGet httpGet = new HttpGet(url);
    // Set the request headers
    
    // Execute the request and get the response
    CloseableHttpResponse response = null;
    try {
      response = httpClient.execute(httpGet);
    } catch (ClientProtocolException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    try {
      // Extract the response body as a String
      String responseBody = null;
      try {
        responseBody = EntityUtils.toString(response.getEntity());
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      // Print the response body
      System.out.println(responseBody);
  } finally {
      // Close the HttpClient and response
      try {
        response.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      try {
        httpClient.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
  }
  }
  
  public static void fetchFlights() {
    
    
  }
  

  
}
