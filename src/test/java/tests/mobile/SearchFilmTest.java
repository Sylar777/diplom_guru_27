package tests.mobile;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
public class SearchFilmTest extends TestBase {
     @Test
     void searchFilmTest() {
         step("Skip title pages", () -> {
             $(id("ru.kinopoisk:id/button_next")).click();
             $(id("ru.kinopoisk:id/button_next")).click();
             $(id("ru.kinopoisk:id/button_payment")).click();
         });

         step("Search for the film 'Герои'", () -> {
             $(id("ru.kinopoisk:id/search")).click();
             $(id("ru.kinopoisk:id/search")).click();
             $(id("ru.kinopoisk:id/search_edit_text")).sendKeys("Герои");
         });

         step("Check that list of result is not empty and the searched film is in the search results", () -> {
             $$(id("ru.kinopoisk:id/title")).shouldHave(sizeGreaterThan(0));
             $$(id("ru.kinopoisk:id/title")).get(0).shouldHave(text("Герои"));
         });
     }
}
