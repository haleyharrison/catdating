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

     get("/profile/make", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/make.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

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


     post("/profile/female", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       String name = request.queryParams("name");
       String fixedstatus = request.queryParams("fixedstatus");
       String city = request.queryParams("city");
       boolean preference = Boolean.parseBoolean(request.queryParams("value"));

       Female femaleCat = new Female (preference, name, fixedstatus, city);
       femaleCat.save();

       model.put("malematch", Female.findByCity(city));
       model.put("femaleCat", femaleCat);
       model.put("template", "templates/femaleprofile.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     post("/profile/male", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       boolean preference = Boolean.parseBoolean(request.queryParams("value"));

       String name = request.queryParams("name");
       String fixedstatus = request.queryParams("fixedstatus");
       String city = request.queryParams("city");
       Male maleCat = new Male (preference, name, fixedstatus, city);
       maleCat.save();
       model.put("maleCat", maleCat);
       model.put("template", "templates/maleprofile.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("profile/female/:id", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       int fId = Integer.parseInt(request.params("id"));
       Female fCat = Female.find(fId);
       model.put("fCat", fCat);
       model.put("template", "templates/searchfprofile.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("profile/male/:id", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       int mId = Integer.parseInt(request.queryParams("id"));
       Female mCat = Female.find(mId);
       model.put("mCat", mCat);
       model.put("template", "templates/searchmprofile.vtl");
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
