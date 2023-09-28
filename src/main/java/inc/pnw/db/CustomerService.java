package inc.pnw.db;

import java.util.Optional;

public class CustomerService {
   static CustomerDAO customerDao;

   public static boolean validateUser(String email, String pass) {
     
     customerDao = new CustomerDAO();
     Optional<CustomerModel> verifyUser = customerDao.get(email);
     if(verifyUser.isEmpty())
       return false;
     else if(verifyUser.get().getEmail().equalsIgnoreCase(email)) {
         if(verifyUser.get().getPassword().equals(pass))
           return true;
     }
    return false;
   }
   
   public static boolean createUserAccount(CustomerModel c) {    
    
     customerDao = new CustomerDAO();
     if(customerDao.get(c.getEmail().toLowerCase()).isPresent()) {
       return false;
     }
     else {
       customerDao.save(c);
       return true;
     }
   }
  
}
