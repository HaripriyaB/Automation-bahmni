package framework;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerClass {

    public static Logger logger;
    public static Level infoLevel = Level.INFO;
    public static Level warningLevel = Level.WARN;

    public static void showLog(Class className, Level level, String message) {
        logger = LogManager.getLogger(className);
        PropertyConfigurator.configure("log4j.properties");

        if (level == infoLevel) {
            logger.info(message);
        } else if (level == warningLevel) {
            logger.warn(message);
        }
    }
}