package framework;

import org.apache.log4j.Level;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigureProperties {

    public static String adminUsername;
    public static String adminPassword;
    public static String local_URL;

    public static void readProperties() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream("config.properties");
            properties.load(inputStream);

            adminUsername = properties.getProperty("adminUsername");
            adminPassword = properties.getProperty("adminPassword");
            local_URL = properties.getProperty("local_URL");
        } catch (Exception e) {
            LoggerClass.showLog(ConfigureProperties.class, Level.WARN, "Exception: " + e.getMessage());
        }
    }
}