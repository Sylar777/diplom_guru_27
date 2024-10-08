package tests.mobile;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.className;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;

@Tag("Mobile")
@Owner("Daniil Sosnovskiy")
@Feature("Media Tab")
public class MediaTabTestMobile extends TestBaseMobile {
    @Test
    @DisplayName("Check that in cinema carousel is loaded")
    void inCinemaLoadingTest() {
        step("Skip title pages", () -> {
            $(id("ru.kinopoisk:id/button_next")).click();
            $(id("ru.kinopoisk:id/button_next")).click();
            $(id("ru.kinopoisk:id/button_payment")).click();
        });

        step("Open Media tab", () -> {
            $(id("ru.kinopoisk:id/afisha")).click();
        });

        step("Check that cinema in the carousel are loaded", () -> {
            SelenideElement recyclerView = $(id("ru.kinopoisk:id/in_cinema_carousel_rv"));
            recyclerView.$$(className("android.view.View"))
                    .shouldBe(sizeGreaterThan(0));
        });
    }

    @Test
    @DisplayName("Check that schedule of premieres in carousel is loaded")
    void scheduleOfPremieresLoadingTest() {
        step("Skip title pages", () -> {
            $(id("ru.kinopoisk:id/button_next")).click();
            $(id("ru.kinopoisk:id/button_next")).click();
            $(id("ru.kinopoisk:id/button_payment")).click();
        });

        step("Open Media tab", () -> {
            $(id("ru.kinopoisk:id/afisha")).click();
        });

        step("Check that schedule of premieres in the carousel are loaded", () -> {
            SelenideElement recyclerView = $(id("ru.kinopoisk:id/soon_films_carousel_rv"));
            recyclerView.$$(className("android.view.View"))
                    .shouldBe(sizeGreaterThan(0));
        });
    }
}
