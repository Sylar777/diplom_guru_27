package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static steps.ResponseRestApiSteps.getTitleByNameViaApi;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Tag("API")
@Owner("Daniil Sosnovskiy")
@Feature("Search")
public class SearchTitleByNameApiTestApi extends TestBaseApi {
    private final static int filmId = 271748;

    @ParameterizedTest(name = "Check searching with page={0}, limit={1}, and filmName={2}")
    @CsvSource(value = {
            "1,3,Герои",
            "1,10,Heroes"
    })
    @DisplayName("Check that searching by name in different languages return the same item")
    void searchingByNameInDifferentLanguageReturnTheSameItemTest(String page, String limit, String filmName) {
        var response = step("Search film " + "'" + filmName + "' via API", () -> {
            return getTitleByNameViaApi(page, limit, filmName);
        });

        step("Check that the first film is has Id = " + filmId, () -> {
            assertThat(response.getDocs().get(0).getId())
                    .as("Film Id")
                    .isEqualTo(filmId);
        });
    }
}
