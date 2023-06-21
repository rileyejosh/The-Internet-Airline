package inc.pnw.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
  
  static String filterJson(String jsonStr, String key) throws JsonMappingException, JsonProcessingException {
    ObjectMapper om = new ObjectMapper();
    JsonNode jsonNode = om.readTree(jsonStr);
    String value = " ";
    if (jsonNode.has(key)) {
      value = jsonNode.get(key).asText();
  }
    return value;
  }
  
  public static void main(String[] args) {
    
    try {
      System.out.println(ServiceBase.filterJson("{\"originCity\":\"Delhi\",\"destinationCity\":\"Tokyo\",\"date\":\"2023-03-25\",\"flightNumber\":\"6 \",\"available\":\"1\",\"flightClass\":\"25\",\"flightTime\":\"13:45:00\",\"price\":\"100.0\"}","flightNumber"));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
  }
 
}
