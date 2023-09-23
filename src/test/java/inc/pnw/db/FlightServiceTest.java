package inc.pnw.db;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

class FlightServiceTest {

  @BeforeEach
  void setUp() throws Exception {
    
    List<FlightModel> f;

  }

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testGetCityNamesForFlights() {
    
  }

  @Test
  void testRetrieveDepartureFlights() {
    LocalDate localDate = LocalDate.of(2023, 03, 25);

    try {
      List<FlightModel> f = FlightService.retrieveDepartureFlights("3", "1", localDate.toString());
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void testRetrieveReturnFlights() throws ClassNotFoundException, SQLException, ParseException {
//    LocalDate localDate = LocalDate.of(2023, 03, 25);
//
//    try {
//      List<FlightModel> r = FlightService.retrieveReturnFlights("{\"originCity\":\"Delhi\",\"destinationCity\":\"Tokyo\",\"date\":\"2023-03-25\",\"flightNumber\":\"6 \",\"available\":\"1\",\"flightClass\":\"25\",\"flightTime\":\"13:45:00\",\"price\":\"100.0\"}", "flightNumber", localDate.toString());
//      for(FlightModel rf : r ) {
//        System.out.println(rf.getFid() + " " + rf.getFnumber());
//      }
//    } catch (ClassNotFoundException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (SQLException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (JsonMappingException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (NumberFormatException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (JsonProcessingException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    } catch (ParseException e) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
//    
  }

}
