import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;


public class Female { // extends Cat
  private boolean preference;
  private int id;
  private String name;
  private String fixed;
  private String city;
  private String breed;


  public boolean getPreference() {
    return preference;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getFixed() {
    return fixed;
  }

  public String getCity() {
    return city;
  }
  public String getBreed() {
    return breed;
  }

  public Female(String name, String fixed, String city){
    this.preference = preference;
    this.name = name;
    this.fixed = fixed;
    this.city = city;
    this.breed = breed;
    // super(String name, String fixed, String city);
  }

  @Override
  public boolean equals(Object otherFemale){
    if(!(otherFemale instanceof Female)) {
      return false;
    } else {
      Female newFemale = (Female) otherFemale;
      return this.getName().equals(newFemale.getName());
    }
  }

  public static List<Female> all() {
    String sql = "SELECT id, name, fixed, city, breed FROM females";
    try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Female.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO females (name, fixed, city) VALUES (:name, :fixed, :city)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("fixed", this.fixed)
        .addParameter("city", this.city)
      //  .addParameter("preference", this.preference)
        .executeUpdate()
        .getKey();
    }
  }

  public static Female find(int id) {
    try(Connection con = DB.sql2o.open()){
      String sql ="SELECT * FROM females WHERE id=:id";
      Female female = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Female.class);
      return female;
    }
  }
  //
  // public void updateAll(String name, String fixed, String city) {
  //   this.name = name;
  //   this.fixed = fixed;
  //   this.city = city;
  //   try(Connection con = DB.sql2o.open()){
  //     String sql = "UPDATE females SET name=:name, fixed=:fixed, city=:city WHERE id=:id";
  //     con.createQuery(sql)
  //       .addParameter("name", name)
  //       .addParameter("fixed", fixed)
  //       .addParameter("city", city)
  //       .addParameter("id", id)
  //       .executeUpdate();
  //     }
  //   }
  // public void addMale(Male male) {
  //     try(Connection con = DB.sql2o.open()) {
  //       String sql = "INSERT INTO matches (female_id, male_id) VALUES (:female_id, :male_id)";
  //       con.createQuery(sql)
  //         .addParameter("female_id", this.getId())
  //         .addParameter("male_id", male.getId())
  //         .executeUpdate();
  //     }
  //   }
  //
  //   public List<Male> getMales() {
  //       try(Connection con = DB.sql2o.open()) {
  //         String sql = "SELECT males.* FROM matches Join males on matches.male_id = males.id WHERE female_id = :female_id";
  //         List<Male> males = con.createQuery(sql)
  //           .addParameter("female_id", this.getId())
  //           .executeAndFetch(Male.class);
  //           return males;
  //         }
  //     }
      // public static List<Male> findByBreed() {
      //   try (Connection con = DB.sql2o.open()){
      //     String sql = "SELECT * From males where breed =:breed";
      //     return con.createQuery(sql).addParameter(":breed", this.getBreed()).executeAndFetch(Male.class);
      //   }
      // }
      // public static List<Male> findByCity() {
      //   try (Connection con = DB.sql2o.open()){
      //     String sql = "SELECT * From males where city =:city";
      //     return con.createQuery(sql).addParameter(":city", this.getCity()).executeAndFetch(Male.class);
      //   }
      // }
      // public static List<Male> findByCityAndBreed() {
      //   try (Connection con = DB.sql2o.open()){
      //     String sql = "SELECT * From males where city =:city AND breed =:breed ";
      //     return con.createQuery(sql).addParameter(":city", this.getCity()).addParameter(":breed", this.getBreed()).executeAndFetch(Male.class);
      //   }
      // }


    public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String deleteQuery = "DELETE FROM females WHERE id=:id";
          con.createQuery(deleteQuery)
            .addParameter("id", id)
            .executeUpdate();

        String joinDeleteQuery = "DELETE FROM matches WHERE female_id =:female_id";
          con.createQuery(joinDeleteQuery)
            .addParameter("female_id", this.getId())
            .executeUpdate();
      }
    }




}//ends class Course
