//Import Packages
import org.sql2o.*;
import java.util.*;
import java.math.BigInteger;

//Create Class
public class Stylist {
  private String name;
  private String description;
  private int id;

//Create Constructor
public Stylist(String name, String description) {
  this.name = name;
  this.description = description;

}

//Create Save Method
public void save() {
  try(Connection con = DB.sql2o.open()) {
  String sql = "INSERT INTO stylists(name, description) VALUES (:name, :description);";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("description", this.description)
      .executeUpdate()
      .getKey();
    }
  }

public static List<Stylist> all() {
  String sql = "SELECT id, name, description FROM stylists";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Stylist.class);
  }
}

public static Stylist find(int id){
  try(Connection con = DB.sql2o.open()){
    String sql = "SELECT * FROM stylists WHERE id=:id";
    Stylist stylist = con.createQuery(sql)
    .addParameter("id", id)
    .executeAndFetchFirst(Stylist.class);
  return stylist;
  }
}

public void updateName(String name) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE stylists SET name = :name WHERE id=:id";
    con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("id", id)
      .executeUpdate();
  }
}

// public void updatePhoneNumber(int phone_number) {
//   try(Connection con = DB.sql2o.open()) {
//     String sql = "UPDATE stylists SET phone_number = :phone_number WHERE id=:id";
//     con.createQuery(sql)
//       .addParameter("phone_number", phone_number)
//       .addParameter("id", id)
//       .executeUpdate();
//   }
// }

public void delete() {
  try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM stylists WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
  }
}

public String getName() {
  return name;
}
public String getDescription() {
  return description;
}

public int getId() {
  return id;
}

@Override
public boolean equals(Object otherStylist) {
  if(!(otherStylist instanceof Stylist)) {
    return false;
  } else {
    Stylist newStylist = (Stylist) otherStylist;
    return this.getId() == newStylist.getId() &&
           this.getName().equals(newStylist.getName()) &&
           this.getDescription().equals(newStylist.getDescription());
  }
}
}
