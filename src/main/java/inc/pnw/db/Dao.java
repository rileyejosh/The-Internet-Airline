package inc.pnw.db;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface Dao<T, E> {
  
  Optional<T> get(E id);
  
  List<T> getByParameters(Map<String, Object> parameters);
  
  List<T> getAll() throws SQLException, ClassNotFoundException;
  
  void save(E t);
  
  void update(E t, String[] params);
  
  void delete(E t);

  
  
}
