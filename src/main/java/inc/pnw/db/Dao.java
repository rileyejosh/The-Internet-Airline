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

  void updateByParameters(Map<String, Object> parameters, Map<String, Object> conditions);

  void deleteByParameters(Map<String, Object> parameters);

  void delete();

  void update(Object t);

  
  
}
