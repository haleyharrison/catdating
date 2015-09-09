import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Rule;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class FemaleTest {

     @Rule
     public DatabaseRule database = new DatabaseRule();

     @Test
     public void all_emptyAtFirst() {
       assertEquals(Female.all().size(), 0);
     }

     @Test
     public void equals_returnsTrueIfFemalesAreTheSame() {
      Female firstFemale = new Female ("Nina", "Neutered", "Seattle");
      Female secondFemale = new Female ("Nina","Neutered", "Seattle");
      assertTrue(firstFemale.equals(secondFemale));
      }

      @Test
      public void save_savesFemaleIntoDatabase_true () {
        Female newFemale = new Female ("Nina", "Neutered", "Seattle");
        newFemale.save();
        assertTrue(Female.all().get(0).equals(newFemale));
      }
      @Test
        public void find_findsFemaleInDatabase_true() {
          Female myFemale = new Female("Nina", "Neutered", "Seattle");
          myFemale.save();
          Female savedFemale = Female.find(myFemale.getId());
          assertTrue(myFemale.equals(savedFemale));

        }


 }//end StoreTest class
