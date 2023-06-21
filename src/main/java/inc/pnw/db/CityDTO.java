package inc.pnw.db;

import java.util.Optional;

public class CityDTO {

<<<<<<< Updated upstream
  private Optional<CityModel> city;
  
  public Optional<CityModel> getCity() {
    return city;
  }
  
  public void setCity(Optional<CityModel> optional) {
=======
  private Optional<City> city;
  
  public Optional<City> getCity() {
    return city;
  }
  
  public void setCity(Optional<City> optional) {
>>>>>>> Stashed changes
    
    this.city = optional;
  }
  
}
