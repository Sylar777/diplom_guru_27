package tests.api;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class TestBaseApi {
    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = System.getProperty("baseAPIUrl", "https://api.kinopoisk.dev/v1.4");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
