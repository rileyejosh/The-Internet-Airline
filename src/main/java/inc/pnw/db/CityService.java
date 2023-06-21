package inc.pnw.db;

import java.sql.SQLException;
<<<<<<< Updated upstream
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
=======
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
>>>>>>> Stashed changes
    }
    return cityMap;
  }
  
<<<<<<< Updated upstream
  static List<CityModel> listCity() {
    
    List<CityModel> cities = null;
=======
  static List<City> listCity() {
    
    city = new CityDAO();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
  
  public static void main(String[] args) {
    
    System.out.println(CityService.listCity().get(0).getCityid());
    
  }
>>>>>>> Stashed changes
}
