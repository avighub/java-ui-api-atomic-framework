package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class PropertyUtils {
    private PropertyUtils() {

    }

    static Logger log = LogManager.getLogger(PropertyUtils.class);

    public static final String ENVIRONMENT;

    public static final Properties configProperties;
    public static final Properties envProperties;

    static {
        configProperties = propertyLoader("src/main/resources/framework-config.properties");

        if (System.getProperty("env") != null) {
            ENVIRONMENT = System.getProperty("env");
            switch (ENVIRONMENT) {
                case "int":
                    envProperties = propertyLoader("src/main/resources/int.properties");
                    log.info("==============================================================================================");
                    log.info("System variable found");
                    log.info("==== Test Environment:{} ", ENVIRONMENT);
                    log.info("==============================================================================================");
                    break;
                case "qa":
                    envProperties = propertyLoader("src/main/resources/qa.properties");
                    log.info("==============================================================================================");
                    log.info("** System variable found");
                    log.info("==== Test Environment:{}", ENVIRONMENT);
                    log.info("==============================================================================================");
                    break;
                default:
                    log.info("==============================================================================================");
                    throw new RuntimeException("Invalid environment variable found. It should be qa or int or stage.");
            }
        } else {
            ENVIRONMENT = configProperties.getProperty("ENVIRONMENT");
            envProperties = propertyLoader("src/main/resources/" + ENVIRONMENT + ".properties");
            log.info("==============================================================================================");
            log.info("** System variable not found. Getting value from config properties.");
            log.info("==== Test Environment: {}", ENVIRONMENT);
            log.info("==============================================================================================");
        }


    }

    public static Properties propertyLoader(String filePath) {
        Properties properties = new Properties();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("failed to load properties file " + filePath);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("properties file not found at " + filePath);
        }
        return properties;
    }
}
