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
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    assertEquals(true, testClient instanceof Client);
  }

  @Test
  public void getName_retrievesClientName_Sowmya() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    assertEquals("Sowmya", testClient.getName());
  }

  @Test
  public void getAddress_retrievesClientAddress_Redmond() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    assertEquals("Redmond", testClient.getAddress());
  }

  @Test
  public void getPhoneNumber_retrievesClientPhoneNumber_4564222990() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    assertEquals(456-422-2990, testClient.getPhoneNumber());
  }

  @Test
  public void getStylistId_retrievesStylistId_1() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    assertEquals(1, testClient.getStylistId());
  }

  @Test
  public void getId_instantiatesWithAnId_true() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    testClient.save();
    assertTrue(testClient.getId() > 0);
}

  @Test
  public void all_retrievesAllInstancesOfClient_true() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    testClient.save();
    Client testClient2 = new Client("Kumar", "Seattle", 456-422-1234, 2);
    testClient2.save();
    assertEquals(true, Client.all().get(0).equals(testClient));
    assertEquals(true, Client.all().get(1).equals(testClient2));
  }

  @Test
  public void find_returnClientWIthSameId_testClient2() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    testClient.save();
    Client testClient2 = new Client("Kumar", "Seattle", 456-422-1234, 2);
    testClient2.save();
    assertEquals(Client.find(testClient2.getId()), testClient2);
  }

  @Test
  public void update_updatesClient_true() {
    Client testClient = new Client("Sowmya", "Redmond", 456-422-2990, 1);
    testClient.save();
    testClient.update("Raj", "bellevue", 425-435-9721 ,testClient.getId());
    assertEquals("Raj", Client.find(testClient.getId()).getName());
  }

  @Test
  public void delete_deletesAClient_true() {
    Client testClient2 = new Client("Kumar", "Seattle", 456-422-1234, 2);
    testClient2.save();
    int testClientId = testClient2.getId();
    Client.delete(testClient2.getId());
    assertEquals(null, Client.find(testClientId));
  }
}
