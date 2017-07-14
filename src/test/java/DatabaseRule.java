import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {
  @Override
  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @Override
  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String deleteClientsQuery = "DELETE FROM clients *;";
      // String deleteArtistsQuery = "DELETE FROM artists *;";
      // String deleteReviewsQuery = "DELETE FROM reviews *;";
      con.createQuery(deleteClientsQuery).executeUpdate();
      // con.createQuery(deleteArtistsQuery).executeUpdate();
      // con.createQuery(deleteReviewsQuery).executeUpdate();
    }
  }

}
