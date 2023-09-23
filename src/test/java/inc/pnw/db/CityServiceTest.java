package inc.pnw.db;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CityServiceTest {

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void testGetCityIDName() {
  }

  @Test
  void testListCity() {
    
    assertEquals(9300, CityService.listCity().size());
  }

}
