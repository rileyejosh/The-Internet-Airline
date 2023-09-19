package inc.pnw.db;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ApiIntegrationHandler {

  // Create an HTTP client
  CloseableHttpClient httpClient = HttpClients.createDefault();

  // Prepare the API request
  static String url;
  static HttpGet request;

  // Set the Authorization header with your API key and secret
  static String apiKey = "API_KEY";
  static String apiSecret = "API_SECRET";
  static String accessKey = "ACCESS_KEY";

  private static String getAmadeusApiCredentials() {
    return accessKey;



  }

  private static String getAirLabsApiCredentials() {
    return accessKey;


  }

  private static String getAviationApiCredentials() {

    return System.getenv(accessKey);



  }


  public static void main(String[] args) {
    String filePath = "D:\\GlobalAirportDatabase\\GlobalAirportDatabase.txt";

    System.out.println(extractStringsFromFile(filePath).size());

  }

  public static void populateDBWithCities() {

    List<City> cities = new ArrayList<City>();
    CityDAO cityDao = new CityDAO();
    // Create an HttpClient
    CloseableHttpClient httpClient = HttpClients.createDefault();


    url = "http://api.aviationstack.com/v1/cities?access_key=" + getAviationApiCredentials();
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
        // Parse the response body as JSON
        JsonObject json = new Gson().fromJson(responseBody, JsonObject.class);

        // Access the specific fields in the JSON response
        // Example: Assuming the response contains a "data" object with "city_iata_code" field
        if (json.has("data")) {
          JsonArray dataArray = json.getAsJsonArray("data");
          for (JsonElement element : dataArray) {
            JsonObject data = element.getAsJsonObject();
            if (data.has("city_id") && data.has("city_name") && data.has("iata_code")) {

              String cityName = data.get("city_name").getAsString();
              String state = data.get("iata_code").getAsString();
              // Create a new City object for each JSON object
              City city = new City();
              city.setTitle(cityName);
              city.setState(state);
              cities.add(city);

            }
          }
        }
      } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      // Print the response body
      for (City c : cities) {

        cityDao.save(c);

      }

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

  public static List<String> extractStringsFromFile(String filePath) {
    List<String> extractedStrings = new ArrayList<>();
    CityDAO cityDao = new CityDAO();
    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split(":");
        if (parts.length >= 4) {
          String secondString = parts[1];
          String fourthString = parts[3];
          City c = new City();
          c.setIata_Code(secondString);
          c.setTitle(fourthString);
          c.setState("N");
          cityDao.save(c);

          // Add the second and fourth strings to the list
          // extractedStrings.add(secondString);
          // extractedStrings.add(fourthString);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return extractedStrings;
  }


}
