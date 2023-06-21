package inc.pnw.db;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FlightServiceTest {

  @BeforeEach
  void setUp() throws Exception {
    
    List<FlightModel> f;
    
  }

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testGetCityNamesForFlights() {
    fail("Not yet implemented");
  }

  @Test
  void testRetrieveDepartureFlights() {
    fail("Not yet implemented");
  }

  @Test
  void testRetrieveReturnFlights() throws ClassNotFoundException, SQLException, ParseException {

    assertEquals(30, FlightService.retrieveReturnFlights(6, ServiceBase.formatDate("2023-03-25")).get(0).getFid());
    
  }

}
