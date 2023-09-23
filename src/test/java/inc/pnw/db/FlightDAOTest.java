package inc.pnw.db;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

class FlightDAOTest {

  @BeforeEach
  void setUp() throws Exception {
    
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testGet() {
//    Optional<FlightModel> fm = fd.get(149);
//    System.out.println(fm.get().getCapacity());
  }

  @Test
  void testGetByParameters() {
    
    List<FlightModel> testF = new ArrayList<FlightModel>();
    
    Map<String, Object> fMap = new HashMap<String, Object>();
    LocalDate localDate = LocalDate.of(2023, 3, 25);

    // Convert the java.time.LocalDate to java.sql.Date
    java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
    fMap.put("orig", 3);
    fMap.put("dest", 1);
    fMap.put("fdate", sqlDate);
    FlightDAO fd = new FlightDAO();
    System.out.println(fd.getByParameters(fMap));
 
  }

  @Test
  void testGetAll() throws Exception{
    
  }

  @Test
  void testSave() {
  }

  @Test
  void testUpdate() {
  }

  @Test
  void testDelete() {

  }
  


}
