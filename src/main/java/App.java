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
  model.put("template", "templates/new-stylist-form.vtl");
  return new ModelAndView(model, layout);
}, new VelocityTemplateEngine());

post("/success", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      //create Artist object
      String userArtist = request.queryParams("user-artist");
      Artist artist = new Artist(userArtist);
      artist.save();
      //create Album object
      String userStylistName = request.queryParams("user-album-name");
      int userAlbumYear = Integer.parseInt(request.queryParams("user-album-year"));
      String userAlbumGenre = request.queryParams("user-album-genre");
      Album album = new Album(userAlbumName, userAlbumYear, userAlbumGenre, artist.getId());
      album.save();
      //create Review object
      String stylistName = request.queryParams("name");
      String stylistDescription = request.queryParams("comment");
      int reviewRating = Integer.parseInt(request.queryParams("rating"));
      Review newReview = new Review(reviewName, reviewComment, reviewRating, album.getId());
      newReview.save();
      model.put("artist", artist);
      model.put("album", album);
      model.put("reviews", Review.findAlbumId(album.getId()));
      model.put("template", "templates/album.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());




}
}
