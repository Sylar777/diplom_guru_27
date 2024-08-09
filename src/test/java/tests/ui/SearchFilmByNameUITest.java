package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Tag("UI")
@Owner("Daniil Sosnovskiy")
@Feature("Search")
public class SearchFilmByNameUITest extends TestBase {
    public final static String filmNameInRussian = "Герои";
    public final static String filmNameInEnglish = "Heroes";

    @BeforeEach
    void setUp() {
        open("/");
    }

    @ParameterizedTest(name = "Check film searching with Name = {0}")
    @ValueSource(strings = {filmNameInEnglish, filmNameInRussian})
    @DisplayName("Check that searching by name in different languages return the same item")
    void searchArticleInDifferentLanguagesTest(String filmName) {
        step("Search article " + "'" + filmName + "'", () -> {
            mainPage.getSearchInput().setValue(filmName);
            mainPage.getSuggestedArticlesList().shouldHave(sizeGreaterThan(0));
        });

        step("Check that the first article is " + "'" + filmNameInRussian + "'", () -> {
            assertThat(mainPage.getArticleTitle(mainPage.getSuggestedArticlesList().first()))
                    .isEqualToIgnoringCase(filmNameInRussian);
        });
    }
}
