package utils;

import config.FrameworkConfig;
import org.aeonbits.owner.ConfigFactory;
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

    public static final Properties envProperties;

    static {
        FrameworkConfig frameworkConfig = ConfigFactory.create(FrameworkConfig.class);
            ENVIRONMENT = frameworkConfig.environment();
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
