package inc.pnw.db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CityService extends ServiceBase {
  
  private static CityDAO city;
  private static Map<String, String> cityMap;
  static List<City> cities = new ArrayList<City>();
  
  static Optional<City> createCity() {
    
    
    return Optional.ofNullable(new City());
    
    
  }
  
  static Map<String, String> getCityIDName() throws ClassNotFoundException, SQLException {

    cityMap = new HashMap<>();
    city = new CityDAO();
    for(City c : city.getAll()) {
      
      cityMap.put(String.valueOf(c.getCityid()), c.getTitle());
    }
    return cityMap;
  }
  

  static List<City> listCity() {
    
    city = new CityDAO();
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
