package utils;

import org.aeonbits.owner.Config;

@Config.Sources(value = "classpath:framework-config.properties")
public interface FrameworkConfig extends Config {

    @DefaultValue("qa")
    String environment();

    String browserName();

    boolean headlessMode();

    String applicationName();

    String applicationVersion();


}
