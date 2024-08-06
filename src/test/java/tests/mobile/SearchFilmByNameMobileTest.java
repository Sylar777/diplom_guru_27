package tests.mobile;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
@Owner("Daniil Sosnovskiy")
@Feature("Search")
public class SearchFilmByNameMobileTest extends TestBase {
    public final static String filmNameInRussian = "Герои";
    public final static String filmNameInEnglish = "Heroes";

    @ParameterizedTest(name = "Check film searching with Name = {0}")
    @ValueSource(strings = {filmNameInEnglish, filmNameInRussian})
    @DisplayName("Check that searching by name in different languages return the same item")
    void searchFilmTest(String filmName) {
        step("Skip title pages", () -> {
            $(id("ru.kinopoisk:id/button_next")).click();
            $(id("ru.kinopoisk:id/button_next")).click();
            $(id("ru.kinopoisk:id/button_payment")).click();
        });

        step("Search article " + "'" + filmName + "'", () -> {
            $(id("ru.kinopoisk:id/search")).click();
            $(id("ru.kinopoisk:id/search")).click();
            $(id("ru.kinopoisk:id/search_edit_text")).sendKeys(filmName);
        });

        step("Check that the first article is " + "'" + filmNameInRussian + "'", () -> {
            $$(id("ru.kinopoisk:id/title")).shouldHave(sizeGreaterThan(0));
            $$(id("ru.kinopoisk:id/title")).get(0).shouldHave(text(filmNameInRussian));
        });
    }
}
