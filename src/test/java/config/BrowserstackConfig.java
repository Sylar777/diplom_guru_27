package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:browserstack.properties"
})
public interface BrowserstackConfig extends Config {
    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @DefaultValue("Google Pixel 3")
    String device();

    @Key("os_version")
    @DefaultValue("9.0")
    String osVersion();

    String app();
    @DefaultValue("https://hub.browserstack.com/wd/hub")
    String url();
}
