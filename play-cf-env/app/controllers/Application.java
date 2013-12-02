package controllers;

import play.mvc.*;

import views.html.index;

import java.util.*;
import java.util.Map;
import java.util.logging.Logger;

public class Application extends Controller {

    private static Logger sLogger = Logger.getLogger(Application.class.getName());
    private static List<String> sEnvironmentVariableNames = null;


    /**
     * @return The title of the app
     */
    public static String getTitle() {
        return "Play CF Env";
    }

    /**
     * @return A sorted list containing the names if all currently set environment variables
     */
    public static List<String> getEnvironmentVariableNames() {

        if (sEnvironmentVariableNames == null) {
            synchronized (Application.class) {
                List<String> names = new ArrayList<String>();
                names.addAll(System.getenv().keySet());
                Collections.sort(names);
                sEnvironmentVariableNames = names;
            }
        }
        return sEnvironmentVariableNames;
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
        sLogger.info("Rendering with environment: " + getEnvironment());
        return ok(index.render());
    }

}
