package controllers;

import play.api.templates.Html;
import play.mvc.*;

import scala.collection.mutable.*;
import scala.collection.mutable.StringBuilder;
import views.html.index;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application extends Controller {

    /**
     * @return The title of the app
     */
    public static String getTitle() {
        return "play-cf-env";
    }

    /**
     * @return The system environment variable map
     */
    public static List<String> getEnvironmentVariableNames() {
        List<String> names = new ArrayList<String>();
        names.addAll(System.getenv().keySet());
        return names;
    }

    /**
     * @return The system environment variable map
     */
    public static Map<String,String> getEnvironment() {
        return System.getenv();
    }

    /**
     * @return page content
     */
    public static Result index() {
        return ok(System.getenv().toString());
    }

    public static Html getContent(){
        return new Html(new StringBuilder());
    }

}
