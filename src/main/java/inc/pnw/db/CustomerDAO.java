package inc.pnw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The CustomerDAO class is responsible for retrieving data from the AirlineDB
 * database. It retrieves all rows from the Customer table and returns a
 * collection of Customer objects to the caller.
 * 
 * @author Joshua Riley
 *
 */
public class CustomerDAO implements Dao<CustomerModel, Object>{

    
  
    public Optional<CustomerModel> get(Object email) {
        CustomerModel customer = null;
        DatabaseManager dbManager = new DatabaseManager();
        try (org.sql2o.Connection connection = dbManager.getConnection()) {
            String sql = "SELECT cid, email, password FROM customer WHERE lower(email) = :email";
            customer = connection.createQuery(sql)
            .addParameter("email", email)
            .executeAndFetchFirst(CustomerModel.class);

        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }

        return Optional.ofNullable(customer);
    }

  @Override
  public List<CustomerModel> getAll() throws SQLException, ClassNotFoundException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void save(Object t) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public List<CustomerModel> getByParameters(Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void updateByParameters(Map<String, Object> parameters, Map<String, Object> conditions) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void deleteByParameters(Map<String, Object> parameters) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void delete() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void update(Object t) {
    // TODO Auto-generated method stub
    
  }
}
