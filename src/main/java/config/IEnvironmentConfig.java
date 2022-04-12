package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:framework-config.properties",
        "classpath:${environment}.properties"
})
public interface IEnvironmentConfig extends Config {

    String loginPageUrl();


}
