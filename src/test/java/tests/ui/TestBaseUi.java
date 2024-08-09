package tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureAttachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBaseUi {
    public final MainPage mainPage;
    public final TopNavigatorPage topNavigatorPage;
    public final IndexOfSeriesPage indexOfSeriesPage;

    public TestBaseUi() {
        mainPage = new MainPage();
        topNavigatorPage = new TopNavigatorPage();
        indexOfSeriesPage = new IndexOfSeriesPage();
    }

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = System.getProperty("baseUrl", "https://www.kinopoisk.ru");
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserVersion = System.getProperty("browserVersion", "122.0");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 10000;
        Configuration.remote = System.getProperty("wdhost", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void afterEach() {
        AllureAttachment.screenshotAs("Last screenshot");
        AllureAttachment.pageSource();
        AllureAttachment.browserConsoleLogs();
        AllureAttachment.addVideo();
        closeWebDriver();
    }
}
