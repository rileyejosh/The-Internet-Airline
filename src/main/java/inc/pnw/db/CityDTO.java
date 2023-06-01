package inc.pnw.db;

import java.util.Optional;

public class CityDTO {

  private Optional<CityModel> city;
  
  public Optional<CityModel> getCity() {
    return city;
  }
  
  public void setCity(Optional<CityModel> optional) {
    
    this.city = optional;
  }
  
}
