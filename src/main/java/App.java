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
       model.put("template", "templates/index.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     post("/matches", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       String catsex = request.queryParams("catsex");
       List<Male> males= Male.all();
       List<Female> females = Female.all();
       model.put("females", females);
       model.put("males", males);
       model.put("template", "templates/matches.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("/profile/make", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/make.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("profile/male", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/malemake.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());

     get("profile/female", (request, response) -> {
       HashMap<String, Object> model = new HashMap<String, Object>();
       model.put("template", "templates/femalemake.vtl");
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
