package tests.api;

import helpers.ResponseRestApi;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static helpers.ResponseRestApi.getRandomTitleByType;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Tag("API")
@Owner("Daniil Sosnovskiy")
@Feature("Get Random Title")
public class GetRandomTitleTest extends TestBase {
    // Test Data
    private final String anime = "anime";

    @Test
    @DisplayName("Check that response not empty")
    void checkThatGetRandomTitleResponseNotEmpty() {
        var response = step("Request random title via API", ResponseRestApi::getRandomTitle);

        step("Check that response not empty", () -> {
            assertThat(response.getId())
                    .as("Title's Id")
                    .isNotNull();
        });
    }

    @Test
    @DisplayName("Check that title has provided type = anime")
    void getRandomTitleByTypeTest() {
        var response = step("Request random title by Type = " + anime + " via API", () ->
                getRandomTitleByType(anime)
        );

        step("Check that random title in response has type = " + anime, () -> {
            assertThat(response.getType())
                    .as("Title's type")
                    .isEqualTo(anime);
        });
    }
}
