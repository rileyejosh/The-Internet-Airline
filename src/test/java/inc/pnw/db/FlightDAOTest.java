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
    fail("Not yet implemented");
  }

  @Test
  void testGetByParameters() {
    fail("Not yet implemented");
  }

  @Test
  void testGetAll() throws Exception{
    
    assertEquals(23, dao.getAll().size() );
  }

  @Test
  void testSave() {
    fail("Not yet implemented");
  }

  @Test
  void testUpdate() {
    fail("Not yet implemented");
  }

  @Test
  void testDelete() {
    fail("Not yet implemented");
  }
  


}
