package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulatorMobileDriver;
import helpers.AllureAttachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

        if (System.getProperty("env", "browserstack").equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else if (System.getProperty("env", "browserstack").equals("emulation")) {
            Configuration.browser = EmulatorMobileDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void tearDown() {
        AllureAttachment.pageSource();
        if (System.getProperty("env", "browserstack").equals("browserstack")) {
            AllureAttachment.addVideoFromBrowserstack();
        }
        closeWebDriver();
    }
}
