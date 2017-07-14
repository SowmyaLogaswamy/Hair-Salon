//import Packages
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.math.BigInteger;

//Create class
public class ClientTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Client_instantiatesCorrectly_true() {
    Client testclient = new Client("Sowmya", "Redmond", 456422299, 1);
    assertEquals(true, testclient instanceof Client);
  }

  @Test
  public void getName_retrievesClientName_Sowmya() {
    Client testclient = new Client("Sowmya", "Redmond", 456422299, 1);
    assertEquals("Sowmya", testclient.getName());
  }

  @Test
  public void getAddress_retrievesClientAddress_Redmond() {
    Client testclient = new Client("Sowmya", "Redmond", 456422299, 1);
    assertEquals("Redmond", testclient.getAddress());
  }

  @Test
  public void getPhoneNumber_retrievesClientPhoneNumber_456422299() {
    Client testclient = new Client("Sowmya", "Redmond", 456422299, 1);
    assertEquals(456422299, testclient.getPhoneNumber());
  }

  @Test
  public void getStylistId_retrievesStylistId_1() {
    Client testclient = new Client("Sowmya", "Redmond", 456422299, 1);
    assertEquals(1, testclient.getStylistId());
  }

}
