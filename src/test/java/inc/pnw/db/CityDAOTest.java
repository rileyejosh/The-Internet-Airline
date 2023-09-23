package inc.pnw.db;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityDAOTest {

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testGet() {
    fail("Not yet implemented");
  }

  @Test
  void testGetAll() {

    CityDAO cd = new CityDAO();
      try {

        List<City> c = cd.getAll();

        System.out.println(c.size());
      } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    
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

  @Test
  void testGetByParameters() {
    fail("Not yet implemented");
  }

}
