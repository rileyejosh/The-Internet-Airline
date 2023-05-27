package inc.pnw.db;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {
  
  Optional<T> get(T id);
  
  List<T> getAll() throws SQLException, ClassNotFoundException;
  
  void save(T t);
  
  void update(T t, String[] params);
  
  void delete(T t);

  
  
}
