//Import Packages
import org.sql2o.*;
import java.util.*;
import java.math.BigInteger;

//Create Class
public class Client {
  private String name;
  private String address;
  private int phone_number;
  private int stylist_id;

//Create Constructor
public Client(String name, String address, int phone_number, int stylist_id) {
  this.name = name;
  this.address = address;
  this.phone_number = phone_number;
  this.stylist_id = stylist_id;
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



}
