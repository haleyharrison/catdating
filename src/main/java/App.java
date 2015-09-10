import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;
import java.util.List;
import java.util.Arrays;
import java.util.Set;

 public class App {
    public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/make.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());


    //  post("/females_delete", (request, response) -> {
    //     int femaleId = Integer.parseInt(request.queryParams("females_id"));
    //     Female deadFemale = Female.find(femaleId);
    //     deadFemale.delete();
    //     response.redirect("/");
    //     return null;
    //   });

    //  post ("/browse", (request, response) -> {
    //    HashMap<String, Object> model = new HashMap<String, Object>();
    //    String catsex = request.queryParams("catsex");
     //
    //    List<Male> males= Male.all();
    //    List<Female> females = Female.all();
     //
    //    model.put("catsex", catsex);
     //
    //    model.put("females", females);
    //    model.put("males", males);
    //    model.put("template", "templates/browse.vtl");
    //    return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());

    //  get("/profile/make", (request, response) -> {
    //    HashMap<String, Object> model = new HashMap<String, Object>();
    //    model.put("template", "templates/make.vtl");
    //    return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());

     get("/profile/male", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/malemake.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     //form to create a female cat
     get("/profile/female", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/femalemake.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     //Profile page for newly created female cat
     post("/profile/female", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       String name = request.queryParams("name");
       String fixedstatus = request.queryParams("fixedstatus");
       String city = request.queryParams("city");
       boolean preference = Boolean.parseBoolean(request.queryParams("value"));
       String breed = request.queryParams("breed");

       Female femaleCat = new Female ( name, fixedstatus, city, preference);
       femaleCat.setBreed(breed); //set into object before you save the object
       femaleCat.save();

       model.put("malematch", Female.findByCity(city));
       model.put("femaleCat", femaleCat);
       model.put("template", "templates/femaleprofile.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     post("/profile/male", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       String name = request.queryParams("name");
       String fixedstatus = request.queryParams("fixedstatus");
       String city = request.queryParams("city");
       boolean preference = Boolean.parseBoolean(request.queryParams("value"));
       String breed = request.queryParams("breed");

       Male maleCat = new Male (preference, name, fixedstatus, city);
       maleCat.setBreed(breed); //set into object before you save the object
       maleCat.save();

       model.put("femalematch", Male.findByCity(city));
       model.put("maleCat", maleCat);
       model.put("template", "templates/maleprofile.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("profile/female/:female_id/:male_id", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();

       int maleId = Integer.parseInt(request.params("male_id"));
       Male maleCat = Male.find(maleId);

       int femaleId = Integer.parseInt(request.params("female_id"));
       Female femaleCat = Female.find(femaleId);

       model.put("maleCat", maleCat);
       model.put("template", "templates/searchmprofile.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("profile/male/:male_id/:female_id", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();

       int maleId = Integer.parseInt(request.params("male_id"));
       Male maleCat = Male.find(maleId);

       int femaleId = Integer.parseInt(request.params("female_id"));
       Female femaleCat = Female.find(femaleId);


       model.put("femaleCat", femaleCat);
       model.put("template", "templates/searchfprofile.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("/browse", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();

       model.put("males", Male.all());
       model.put("females", Female.all());
       model.put("prefset", request.session().attribute("prefset"));
       model.put("template", "templates/browse.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     post("/browse", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       String inputPref = request.queryParams("prefset");
       request.session().attribute("prefset", inputPref);

       model.put("males", Male.all());
       model.put("females", Female.all());
       model.put("prefset", inputPref);
       model.put("template", "templates/browse.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
     //
    //  post("/profile", (request, response) -> {
    //    HashMap<String, Object> model = new HashMap<String, Object>();
    //    String gender = request.queryParams("gender");
    //    String name = request.queryParams("name");
    //    String fixedstatus = request.queryParams("fixedstatus");
    //    String city = request.queryParams("city");
     //
    //        if(gender.equals("male")){
    //          Male newCat = new Male(name, fixedstatus, gender);
    //          return newCat;
     //
    //        } else {
    //          Female newCat = new Female(name, fixedstatus, gender);
    //          return newCat;
     //
    //        }
     //
     //
    //    model.put("newCat", newCat);
    //    model.put("template", "templates/profile.vtl");
    //    return new ModelAndView(model, layout);
    //  }, new VelocityTemplateEngine());


  }//end of main

}//end of app
