import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;


public class Male {
  private int id;
  private String name;
  private String fixed;
  private String city;
  private String breed;


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

  public Male(String name, String fixed, String city){
    this.name = name;
    this.fixed = fixed;
    this.city = city;
    this.breed = breed;
  }

  @Override
  public boolean equals(Object otherMale){
    if(!(otherMale instanceof Male)) {
      return false;
    } else {
      Male newMale = (Male) otherMale;
      return this.getMale().equals(newMale.getMale());
    }
  }

  public static List<Male> all() {
    String sql = "SELECT id, name, fixed, city, breed FROM males"
    try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Male.class);
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO males (male_id) VALUES (:male_id)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("female_id", female_id)
        .executeUpdate()
        .getKey();
    }

  }
  public static Male find(int id) {
    try(Connection con = DB.sql2o.open()){
      String sql ="SELECT * FROM males WHERE id=:id ORDER BY male_id ASC";
      Brand brand = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Male.class);
      return brand;
    }
  }
  public void update(int male_id) {
    this.male_id = male_id;
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE males SET male_id=:male_id WHERE id=:id";
      con.createQuery(sql)
        .addParameter("male_id", male_id)
        .addParameter("id", id)
        .executeUpdate();
      }
    }
  public void addFemale(Female female) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO matches (female_id, male_id) VALUES (:female_id, :male_id)";
        con.createQuery(sql)
          .addParameter("male_id", this.getId())
          .addParameter("female_id", female.getId())
          .executeUpdate();
      }
    }

    public List<Female> getFemales() {
        try(Connection con = DB.sql2o.open()) {
          String sql = "SELECT females.* FROM matches Join females on matches.female_id = females.id WHERE male_id = :male_id";
          List<Female> females = con.createQuery(sql)
            .addParameter("male_id", this.getId())
            .executeAndFetch(Female.class);
            return stores;
          }
      }

    public void delete() {
      try(Connection con = DB.sql2o.open()) {
        String deleteQuery = "DELETE FROM males WHERE id=:id";
          con.createQuery(deleteQuery)
            .addParameter("id", id)
            .executeUpdate();

        String joinDeleteQuery = "DELETE FROM matches WHERE male_id =:male_id";
          con.createQuery(joinDeleteQuery)
            .addParameter("male_id", this.getId())
            .executeUpdate();
      }
    }

}//ends class Course
