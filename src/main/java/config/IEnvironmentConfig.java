package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "classpath:framework-config.properties"
        })
public interface IEnvironmentConfig extends Config {

    @DefaultValue("qa")
    String environment();

    String browserName();

    boolean headlessMode();

    String applicationName();

    String applicationVersion();


}
