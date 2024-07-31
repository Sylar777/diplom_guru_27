package tests.ui;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("UI")
public class SimpleSearchTest extends TestBase {
    public final static String filmNameInRussian = "Герои";
    public final static String filmNameInEnglish = "Heroes";

    @ParameterizedTest(name = "Check searching with Value = {0}")
    @ValueSource(strings = {filmNameInEnglish, filmNameInRussian})
    void searchArticleInDifferentLanguagesTest(String filmName) {
        step("Search article " + "'"+ filmName + "'", () -> {
            mainPage.searchInput.setValue(filmName);
            mainPage.suggestedArticlesList.shouldHave(sizeGreaterThan(0));
        });

        step("Check that the first article is " + "'"+ filmNameInRussian + "'", () -> {
            assertThat(mainPage.getArticleTitle(mainPage.suggestedArticlesList.first()))
                    .isEqualToIgnoringCase(filmNameInRussian);
        });
    }
}
