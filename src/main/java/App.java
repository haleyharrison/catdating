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
       List<Female> females = Female.all();
       List<Male> males = Male.all();
       model.put("females", females);
       model.put("males", males);
       model.put("template", "templates/matches.vtl");
       return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());


  }//end of main

}//end of app
