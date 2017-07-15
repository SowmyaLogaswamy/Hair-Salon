import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {

public static void main(String[] args) {
  staticFileLocation("/public");
  String layout = "templates/layout.vtl";

  get("/", (request, response) -> {
    Map<String, Object> model = new HashMap<String, Object>();
    model.put("stylists", Stylist.all());
    model.put("clients", Client.all());
    model.put("template", "templates/index.vtl");
    return new ModelAndView(model, layout);
  }, new VelocityTemplateEngine());

  // get("/stylist/add", (request,response) -> {
  // Map<String, Object> model = new HashMap<String, Object>();
  // Stylist stylist = Stylist.find(Integer.parseInt(request.params(":stylistId")));
  // model.put("stylists", Stylist.all());
  // model.put("clients", Client.all());
  //     model.put("template", "templates/index.vtl");
  //     return new ModelAndView(model, layout);
  //   }, new VelocityTemplateEngine());

get("/stylist/:id", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  Stylist stylist = Stylist.find(Integer.parseInt(request.params(":id")));
  model.put("stylist", stylist);
  model.put("clients", Client.all());
  model.put("template", "templates/stylist.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

get("/stylist/:stylistId/client/:id", (request, response) -> {
  Map<String, Object> model = new HashMap<String, Object>();
  Client client = Client.find(Integer.parseInt(request.params(":id")));
  Stylist stylist = Stylist.find(client.getStylistId());
  model.put("stylist", stylist);
  model.put("client", client);
  model.put("template", "templates/client.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());


get("/stylists/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylist-new.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/stylists-form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("stylists", Stylist.all());
      model.put("template", "templates/stylists.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

//  get("/stylists/add", (request, response) -> {
//    Map<String, Object> model = new HashMap<String, Object>();
//    model.put("stylists", Stylist.all());
//    model.put("template", "templates/tasks.vtl");
//    return new ModelAndView(model, layout);
//  }, new VelocityTemplateEngine());

     post("/stylists/add", (request, response) -> {
       Map<String, Object> model = new HashMap<String, Object>();
      String name = request.queryParams("name");
     String description = request.queryParams("description");
      Stylist newStylist = new Stylist(name, description);
     newStylist.save();
       //model.put("stylist", newStylist);
       model.put("stylists", Stylist.all());
       model.put("clients", Client.all());
       model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
     }, new VelocityTemplateEngine());
}
}
