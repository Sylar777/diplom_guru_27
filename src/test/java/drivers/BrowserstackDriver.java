package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackDriver implements WebDriverProvider {
    private final BrowserstackConfig browserstackConfig;

    public BrowserstackDriver() {
        this.browserstackConfig = ConfigFactory.create(BrowserstackConfig.class, System.getProperties());
    }

    public BrowserstackConfig getBrowserstackConfig() {
        return browserstackConfig;
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", browserstackConfig.user());
        caps.setCapability("browserstack.key", browserstackConfig.key());

        // Set URL of the application under test
        caps.setCapability("app", browserstackConfig.app());

        // Specify device and os_version for testing
        caps.setCapability("device", browserstackConfig.device());
        caps.setCapability("os_version", browserstackConfig.osVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Diplom_27_Daniil_Sosnovskiy");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "KinopoiskDevicesTests");
        caps.setCapability("browserstack.idleTimeout", 300);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            return new RemoteWebDriver(
                    new URL(browserstackConfig.url()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
