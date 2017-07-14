//import Packages
import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;


//Create class
public class StylistTest {
  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Stylist_instantiatesCorrectly_true() {
    Stylist testStylist = new Stylist("Geena", "Hair Stylist");
    assertEquals(true, testStylist instanceof Stylist);
  }

  @Test
  public void getName_retrievesStylistName_Geena() {
      Stylist testStylist = new Stylist("Geena", "Hair Stylist");
    assertEquals("Geena", testStylist.getName());
  }

  @Test
  public void getDescription_retrievesStylistDescription_HairStylist() {
      Stylist testStylist = new Stylist("Geena", "Hair Stylist");
    assertEquals("Hair Stylist", testStylist.getDescription());
  }

  @Test
  public void getId_instantiatesWithAnId_true() {
      Stylist testStylist = new Stylist("Geena", "Hair Stylist");
    testStylist.save();
    assertTrue(testStylist.getId() > 0);
}

@Test
public void all_retrievesAllInstancesOfStylist_true() {
    Stylist testStylist = new Stylist("Bella", "Hair Stylist");
  testStylist.save();
Stylist testStylist2 = new Stylist("Roma", "Hair Stylist");
  testStylist2.save();
  assertEquals(true, Stylist.all().get(0).equals(testStylist));
  assertEquals(true, Stylist.all().get(1).equals(testStylist2));
}

@Test
public void find_returnStylistWIthSameId_testStylist2() {
    Stylist testStylist = new Stylist("Geena", "Hair Stylist");
  testStylist.save();
  Stylist testStylist2 = new Stylist("Roma", "Hair Stylist");
  testStylist2.save();
  assertEquals(Stylist.find(testStylist2.getId()), testStylist2);
}

@Test
public void updateName_updatesStylistName_Rani() {
    Stylist testStylist = new Stylist("Geena", "Hair Stylist");
  testStylist.save();
  testStylist.updateName("Rani");
  assertEquals("Rani", Stylist.find(testStylist.getId()).getName());
}

@Test
public void delete_deletesAStylist_true() {
    Stylist testStylist2 = new Stylist("Geena", "Hair Stylist");
  testStylist2.save();
  int testStylistId = testStylist2.getId();
  testStylist2.delete();
  assertEquals(null, Stylist.find(testStylistId));
}

}
