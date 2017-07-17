//Import Packages
import org.sql2o.*;
import java.util.*;

//Create Class
public class Client {
  private String name;
  private String address;
  private int phone_number;
  private int stylist_id;
  private int id;

//Create Constructor
public Client(String name, String address, int phone_number, int stylist_id) {
  this.name = name;
  this.address = address;
  this.phone_number = phone_number;
  this.stylist_id = stylist_id;
}

//Create Save Method
public void save() {
  try(Connection con = DB.sql2o.open()) {
  String sql = "INSERT INTO clients(name, address, phone_number, stylist_id) VALUES (:name, :address, :phone_number, :stylist_id);";
    this.id = (int) con.createQuery(sql, true)
      .addParameter("name", this.name)
      .addParameter("address", this.address)
      .addParameter("phone_number", this.phone_number)
      .addParameter("stylist_id", this.stylist_id)
      .executeUpdate()
      .getKey();
    }
  }

public static List<Client> all() {
  String sql = "SELECT id, name, address, phone_number, stylist_id FROM clients";
  try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Client.class);
  }
}

public static Client find(int id) {
  try(Connection con = DB.sql2o.open()){
    String sql = "SELECT * FROM clients WHERE id=:id";
    Client client = con.createQuery(sql)
    .addParameter("id", id)
    .executeAndFetchFirst(Client.class);
  return client;
  }
}

public static void update(String name, String address, int phone_number, int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "UPDATE clients SET name = :name, address = :address, phone_number = :phone_number WHERE id=:id";
    con.createQuery(sql)
      .addParameter("name", name)
      .addParameter("address", address)
      .addParameter("phone_number", phone_number)
      .addParameter("id", id)
      .executeUpdate();
  }
}

public static void delete(int id) {
  try(Connection con = DB.sql2o.open()) {
    String sql = "DELETE FROM clients WHERE id = :id;";
    con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
  }
}

public String getName() {
  return name;
}
public String getAddress() {
  return address;
}
public int getPhoneNumber() {
  return phone_number;
}
public int getStylistId() {
  return stylist_id;
}
public int getId() {
  return id;
}

@Override
public boolean equals(Object otherClient) {
  if(!(otherClient instanceof Client)) {
    return false;
  } else {
    Client newClient = (Client) otherClient;
    return this.getId() == newClient.getId() &&
           this.getName().equals(newClient.getName()) &&
           this.getAddress().equals(newClient.getAddress()) &&
           this.getPhoneNumber()==newClient.getPhoneNumber() &&
           this.getStylistId() == newClient.getStylistId();
        }
    }
}
