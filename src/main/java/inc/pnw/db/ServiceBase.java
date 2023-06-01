package inc.pnw.db;


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

}
