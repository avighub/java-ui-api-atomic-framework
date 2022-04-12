package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:framework-config.properties"
})
public interface FrameworkConfig extends Config {

    @DefaultValue("qa")
    String environment();

    @DefaultValue("chrome")
    String browserName();

    boolean headlessMode();

    String applicationName();

    String applicationVersion();


}
