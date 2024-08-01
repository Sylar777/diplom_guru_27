package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.DeviceConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    private final DeviceConfig deviceConfig;

    public BrowserstackDriver() {
        this.deviceConfig = ConfigFactory.create(DeviceConfig.class, System.getProperties());
    }

    public DeviceConfig getDeviceConfig() {
        return deviceConfig;
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", deviceConfig.user());
        caps.setCapability("browserstack.key", deviceConfig.key());

        // Set URL of the application under test
        caps.setCapability("app", deviceConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", deviceConfig.device());
        caps.setCapability("os_version", deviceConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Diplom_27_Daniil_Sosnovskiy");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "KinopoiskDevicesTests");
        caps.setCapability("browserstack.idleTimeout", 300);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(deviceConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
