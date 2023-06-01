package inc.pnw.db;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityService extends ServiceBase {
  
  private static List<CityModel> cm;
  private static CityDAO city;
  private static Map<Integer, String> cityMap;
  
  static Map<Integer, String> getCityIDName() throws ClassNotFoundException, SQLException {
    city = new CityDAO();
    cityMap = new HashMap<>();
    for(CityModel c : city.getAll()) {
      
      cityMap.put(c.getId(), c.getTitle());
    }
    return cityMap;
  }
  
  static List<CityModel> listCity() {
    
    List<CityModel> cities = null;
    try {
      cities = city.getAll();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return cities;
    
  }
}
