package config;

import org.aeonbits.owner.ConfigCache;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ConfigManager {
    private ConfigManager() {

    }

    static Logger log = LogManager.getLogger(ConfigManager.class);

    public static final String ENVIRONMENT;
    public static final IFrameworkConfig FRAMEWORKCONFIG;
    public static final IEnvironmentConfig ENVIRONMENTCONFIG;

    static {
        FRAMEWORKCONFIG = ConfigCache.getOrCreate(IFrameworkConfig.class);
        ENVIRONMENT = FRAMEWORKCONFIG.environment();
        ConfigFactory.setProperty("environment", ENVIRONMENT);
        ENVIRONMENTCONFIG = ConfigCache.getOrCreate(IEnvironmentConfig.class);
    }

}
