package tests.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

import static com.codeborne.selenide.Configuration.browserCapabilities;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    public MainPage mainPage;

    public TestBase() {
        mainPage = new MainPage();
    }

    @BeforeAll
    static void beforeAll() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("incognito");
        browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.baseUrl = "https://www.kinopoisk.ru";
        Configuration.browser = "chrome";
        Configuration.browserVersion = "114.0";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @BeforeEach
    void setUp() {
        open("/");
    }

    @AfterEach
    void afterEach() {
        closeWebDriver();
    }
}
