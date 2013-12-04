package controllers;

import play.Play;
import play.Logger;
import play.Configuration;
import play.mvc.*;

import views.html.index;

import java.util.*;
import java.util.Map;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;


public class Application extends Controller {

    private static List<String> sEnvironmentVariableNames = null;
    private static List<String> sPlayVariableNames = null;

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

    public static List<String> getJVMRuntimeParameters() {
        RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
        return bean.getInputArguments();
    }

    public static List<String> getPlayConfigurationKeys() {
        if (sPlayVariableNames == null) {
            synchronized (Application.class) {
                List<String> configKeys = new ArrayList<String>();
                configKeys.addAll(Play.application().configuration().keys());
                Collections.sort(configKeys);
                sPlayVariableNames = configKeys;
            }
        }
        return sPlayVariableNames;
    }

    public static String getPrintablePlayVariable(String pKey) {

        String printableValue  = null;

        try {
            printableValue = Play.application().configuration().getString(pKey);
        } catch (Exception e) {
            Logger.info("Could not read config value "+ pKey +" as String");
        }

        if (printableValue == null) {
            try {
                List<Object> listValues = Play.application().configuration().getList(pKey);
                StringBuilder buff = new StringBuilder();
                for (Object obj : listValues) {
                    if (buff.length() > 0) {
                        buff.append(", ");
                    }
                    buff.append(obj);
                }
                printableValue = buff.toString();
            } catch (Exception e) {
                Logger.info("Could not read config value "+ pKey +" as List");
            }
        }

        if (printableValue == null) {
            Map <String,Object> config = Play.application().configuration().asMap();
            Object configObj = config.get(pKey);

            if (configObj != null) {

                Logger.info("Config object " + pKey + " has type " + configObj.getClass().getCanonicalName());

                if (configObj instanceof String) {
                    printableValue = (String)configObj;
                } else {
                    printableValue = configObj.toString();
                }
            }
        }

        return printableValue;
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
        Logger.info("Rendering with environment: " + getEnvironment());
        return ok(index.render());
    }

    public static String getCurrentTimeStamp(){
        String time = new Date().toString();
        Logger.info("Rendering time: " + time);
        return time;
    }

}
