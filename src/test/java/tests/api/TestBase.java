package tests.api;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = System.getProperty("baseAPIUrl", "https://api.kinopoisk.dev/v1.4");
        Configuration.remote = System.getProperty("Wdhost", "https://user1:1234@selenoid.autotests.cloud/wd/hub");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
