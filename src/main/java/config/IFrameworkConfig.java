package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:framework-config.properties"
})
public interface IFrameworkConfig extends Config {

    @DefaultValue("qa")
    String environment();

    @DefaultValue("chrome")
    String browserName();

    String browserRunMode();

    String browserRemoteModeType();

    boolean headlessMode();

    String applicationName();

    String applicationVersion();


}
