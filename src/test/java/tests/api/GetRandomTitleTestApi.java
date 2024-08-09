package tests.api;

import steps.ResponseRestApiSteps;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static steps.ResponseRestApiSteps.getRandomTitleByType;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Tag("API")
@Owner("Daniil Sosnovskiy")
@Feature("Get Random Title ")
public class GetRandomTitleTestApi extends TestBaseApi {
    // Test Data
    private final String anime = "anime";

    @Test
    @DisplayName("Check that Id in response is positive value")
    void checkThatGetRandomTitleResponseNotEmpty() {
        var response = step("Request random title via API", ResponseRestApiSteps::getRandomTitle);

        step("Check that response is not empty", () -> {
            assertThat(response.getId())
                    .as("Title's Id")
                    .isGreaterThan(0);
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
