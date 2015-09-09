import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://127.0.0.1:5432/dating_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteMalesQuery = "DELETE FROM males *;";
      String deleteFemalesQuery = "DELETE FROM females *;";
      String deleteMatchesQuery = "DELETE FROM matches *;";
      con.createQuery(deleteMalesQuery).executeUpdate();
      con.createQuery(deleteFemalesQuery).executeUpdate();
      con.createQuery(deleteMatchesQuery).executeUpdate();
    }
  }
}
