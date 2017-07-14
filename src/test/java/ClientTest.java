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
    Client testclient = new Client("Sowmya", "Redmond", 45642, 1);
    assertEquals(true, testclient instanceof Client);
  }
}
