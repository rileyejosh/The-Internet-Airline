package inc.pnw.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ServiceBase {

  static String action;

  static java.sql.Date formatDate(String dateString) throws ParseException {

    DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
    LocalDate date = LocalDate.parse(dateString, inputFormatter);
    DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = outputFormatter.format(date);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date tempDate = dateFormat.parse(formattedDate);
    java.sql.Date newDate = new java.sql.Date(tempDate.getTime());
    return newDate;
  }
  
  static List<String> convertJsonToList(String jsonStr) {
    Gson gson = new Gson();
    JsonObject jsonObject = gson.fromJson(jsonStr, JsonObject.class);

    List<String> valuesList = new ArrayList<>();

    Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();
    for (Map.Entry<String, JsonElement> entry : entries) {
        valuesList.add(entry.getValue().getAsString());
    }
    return valuesList;

  }

  
  static String filterJson(String jsonStr, String key) throws JsonMappingException, JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    JsonNode jsonNode = om.readTree(jsonStr);
    String value = " ";
    if (jsonNode.has(key)) {
      value = jsonNode.get(key).asText();
  }
    return value;
  }
 
 
}
