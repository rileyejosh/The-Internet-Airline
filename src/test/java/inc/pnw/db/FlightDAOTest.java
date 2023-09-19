package inc.pnw.db;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;

class FlightDAOTest {

  private FlightDAO dao;
  private Connection conn;
  private DatabaseManager db;
  @BeforeEach
  void setUp() throws Exception {
    
    dao = new FlightDAO();    
  }

  @AfterEach
  void tearDown() throws Exception {
  }

  @Test
  void testGet() {
  }

  @Test
  void testGetByParameters() {
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
