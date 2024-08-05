package tests.api;

import helpers.ResponseRestApi;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.ResponseRestApi.getRandomTitleByType;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Tag("API")
public class GetRandomTitleTest extends TestBase {
    // Test Data
    private final String anime = "anime";

    @Test
    void checkThatGetRandomTitleResponseNotEmpty() {
        var response = step("Request random title via API", ResponseRestApi::getRandomTitle);

        step("Check that response not empty", () -> {
            assertThat(response.getId())
                    .as("Title's Id")
                    .isNotNull();
        });
    }

    @Test
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
