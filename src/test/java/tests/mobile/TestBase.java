package tests.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.BrowserstackDriver;
import drivers.EmulateMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;
        Configuration.timeout = 30000;

        if (System.getProperty("env", "browserstack").equals("browserstack")) {
            Configuration.browser = BrowserstackDriver.class.getName();
        } else if (System.getProperty("env", "browserstack").equals("emulation")) {
            Configuration.browser = EmulateMobileDriver.class.getName();
        }
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

    @AfterEach
    void tearDown() {
        String sessionId = Selenide.sessionId().toString();
        System.out.println(sessionId);

//        Attach.screenshotAs("Last screenshot"); // todo fix
        Attach.pageSource();
        closeWebDriver();

        Attach.addVideo(sessionId);
    }
}
