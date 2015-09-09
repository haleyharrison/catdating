import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import java.util.List;
import java.util.ArrayList;

public class MaleTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Female.all().size(), 0);
  }

  @Test
  public void equals_returnsTrueIfMalesAreTheSame() {
   Male firstMale = new Male ("Bob", "Neutered", "Seattle");
   Male secondMale = new Male ("Bob", "Neutered", "Seattle");
   assertTrue(firstMale.equals(secondMale));
   }

   @Test
   public void save_savesMaleIntoDatabase_true () {
     Male newMale = new Male ("Bob", "Neutered", "Seattle");
     newMale.save();
     assertTrue(Male.all().get(0).equals(newMale));
   }
   @Test
     public void find_findsMaleInDatabase_true() {
       Male myMale = new Male("Bob", "Neutered", "Seattle");
       myMale.save();
       Male savedMale = Male.find(myMale.getId());
       assertTrue(myMale.equals(savedMale));
     }

   @Test
   public void update_updatesMaleFormInDatabase_true() {
     Male myMale = new Male("Bob", "Neutered", "Seattle");
     myMale.save();

     String name = "Frank";
     String fixed = "Neutered";
     String city = "Portland";

     myMale.update(name, fixed, city);

     assertTrue(Male.all().get(0).getName().equals(name));
     assertTrue(Male.all().get(0).getFixed().equals(fixed));
     assertTrue(Male.all().get(0).getCity().equals(city));
   }

   @Test
   public void addFemale_addsFemaleToFemale() {
     Female myFemale = new Female("Sue", "Neutered", "Portland");
     myFemale.save();
     Male myMale = new Male("Bob", "Neutered", "Seattle");
     myMale.save();

     myMale.addFemale(myFemale);
     Female savedFemale = myMale.getFemales().get(0);
     assertTrue(myFemale.equals(savedFemale));
     }

   @Test
   public void getMales_returnsAllMales_ArrayList() {
     Female myFemale = new Female("Sue", "Neutered", "Portland");
     myFemale.save();
     Male myMale = new Male("Bob", "Neutered", "Seattle");
     myMale.save();

     myMale.addFemale(myFemale);

     List savedFemales = myMale.getFemales();
     assertEquals(savedFemales.size(), 1);
   }

}//end BookTest class
