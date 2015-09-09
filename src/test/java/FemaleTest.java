<<<<<<< HEAD
// import org.junit.*;
// import static org.junit.Assert.*;
// import org.junit.Rule;
// import java.util.List;
// import java.util.Arrays;
// import java.util.ArrayList;
//
// public class FemaleTest {
//
//      @Rule
//      public DatabaseRule database = new DatabaseRule();
//
//      @Test
//      public void all_emptyAtFirst() {
//        assertEquals(Female.all().size(), 0);
//      }
//
=======
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

      @Test
      public void update_updatesFemaleFormInDatabase_true() {
        Female myFemale = new Female("Nina", "Neutered", "Seattle");
        myFemale.save();

        String name = "Momo";
        String fixed = "Neut";
        String city = "Portland";

        myFemale.updateAll(name, fixed, city);

        assertTrue(Female.all().get(0).getName().equals(name));
        assertTrue(Female.all().get(0).getFixed().equals(fixed));
        assertTrue(Female.all().get(0).getCity().equals(city));
      }

      @Test
      public void addMale_addsMaleToFemale() {
        Male myMale = new Male("Mike", "Neutered", "Portland");
        myMale.save();
        Female myFemale = new Female("Nina", "Neutered", "Seattle");
        myFemale.save();

        myFemale.addMale(myMale);
        Male savedMale = myFemale.getMales().get(0);
        assertTrue(myMale.equals(savedMale));
        }
>>>>>>> bf35f007fb4eb7a9c3af73a3d5c431827336a9b1

      @Test
      public void getMales_returnsAllMales_ArrayList() {
        Male myMale = new Male("Mike", "Neutered", "Portland");
        myMale.save();
        Female myFemale = new Female("Nina", "Neutered", "Seattle");
        myFemale.save();
        myFemale.addMale(myMale);
        List savedMales = myFemale.getMales();
        assertEquals(savedMales.size(), 1);
      }

 }//end StoreTest class
