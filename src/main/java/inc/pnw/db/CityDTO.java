package inc.pnw.db;

import java.util.Optional;

public class CityDTO {


  private Optional<City> city;
  
  public Optional<City> getCity() {
    return city;
  }
  
  public void setCity(Optional<City> optional) {

    
    this.city = optional;
  }
  
}
