import java.util.List;
import org.sql2o.*;
import java.util.ArrayList;


public class Female {
  private int id;
  private String name;
  private String fixed;
  private String city;


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
    this.name = name;
    this.fixed = fixed;
    this.city = city;
    this.breed = breed;
  }

  @Override
  public boolean equals(Object otherFemale){
    if(!(otherFemale instanceof Female)) {
      return false;
    } else {
      Female newFemale = (Female) otherFemale;
      return this.getFemale().equals(newFemale.getFemale());
    }
  }

  public static List<Female> all() {
    String sql = "SELECT id, name, fixed, city, breed FROM females"
    try(Connection con = DB.sql2o.open()) {
    return con.createQuery(sql).executeAndFetch(Female.class);
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO females (female_id) VALUES (:female_id)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("female_id", female_id)
        .executeUpdate()
        .getKey();
    }

  }
  public static Female find(int id) {
    try(Connection con = DB.sql2o.open()){
      String sql ="SELECT * FROM females WHERE id=:id ORDER BY female_id ASC";
      Brand brand = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Female.class);
      return brand;
  }
}
  public void update(int female_id) {
    this.female_id = female_id;
    try(Connection con = DB.sql2o.open()){
      String sql = "UPDATE females SET female_id=:female_id WHERE id=:id";
      con.createQuery(sql)
        .addParameter("female_id", female_id)
        .addParameter("id", id)
        .executeUpdate();
  }
}
  public void addMale(Male male) {
      try(Connection con = DB.sql2o.open()) {
        String sql = "INSERT INTO matches (female_id, male_id) VALUES (:female_id, :male_id)";
        con.createQuery(sql)
          .addParameter("brand_id", this.getId())
          .addParameter("store_id", store.getId())
          .executeUpdate();
      }
    }

    public void delete() {
  try(Connection con = DB.sql2o.open()) {
    String deleteQuery = "DELETE FROM brands WHERE id=:id";
      con.createQuery(deleteQuery)
        .addParameter("id", id)
        .executeUpdate();

    String joinDeleteQuery = "DELETE FROM stores_brands WHERE brand_id =:brand_id";
      con.createQuery(joinDeleteQuery)
        .addParameter("brand_id", this.getId())
        .executeUpdate();
  }
}




}//ends class Course
