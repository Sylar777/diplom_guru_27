package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.EmulateMobileConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.*;
import java.net.*;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class EmulateMobileDriver implements WebDriverProvider {
    private static final EmulateMobileConfig emulateMobileConfig =
            ConfigFactory.create(
                    EmulateMobileConfig.class,
                    System.getProperties()
            );

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        return getEmulateDriver();
    }

    public AndroidDriver getEmulateDriver() {
        UiAutomator2Options options = new UiAutomator2Options();

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setPlatformVersion(emulateMobileConfig.platformVersion())
                .setDeviceName(emulateMobileConfig.deviceName())
                .setApp(getAppPath())
                .setAppPackage(emulateMobileConfig.appPackage())
                .setAppActivity(emulateMobileConfig.appActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(emulateMobileConfig.mobileUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getAppPath() {
        String appVersion = "Кинопоиск_ кино и сериалы_6.134.2_APKPure.apk";
        String appUrl = "https://d.apkpure.com/b/APK/ru.kinopoisk?versionCode=1031781";
        String appPath = "src/test/resources/apps/" + appVersion;

        File app = new File(appPath);
        if (!app.exists()) {
            System.out.println("App does not exist, attempting to download.");
            try {
                URL url = new URL(appUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("User-Agent", "Mozilla/5.0");
                try (InputStream in = connection.getInputStream()) {
                    System.out.println("Opened URL stream successfully.");
                    copyInputStreamToFile(in, app);
                    System.out.println("Downloaded file successfully.");
                }
            } catch (IOException e) {
                System.err.println("Failed to download application: " + e.getMessage());
                e.printStackTrace();
                throw new AssertionError("Failed to download application", e);
            }
        } else {
            System.out.println("App already exists at: " + app.getAbsolutePath());
        }
        return app.getAbsolutePath();
    }
}
