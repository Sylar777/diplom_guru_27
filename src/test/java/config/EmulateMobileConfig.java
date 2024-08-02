package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:emulation.properties"
})
public interface EmulateMobileConfig extends Config {
    String platformVersion();
    String deviceName();
    String appPackage();
    String appActivity();
    String mobileUrl();
}
