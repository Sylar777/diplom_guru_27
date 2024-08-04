package tests.api;

import helpers.ResponseRestApi;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Tag("API")
public class GetRandomTitleTest extends TestBase {
    @Test
    void checkThatGetRandomTitleResponseNotEmpty() {
        var response = step("Request random title via API", ResponseRestApi::getRandomTitle);

        step("Check that response not empty", () -> {
            assertThat(response.getId())
                    .as("Film Id")
                    .isNotNull();
        });
    }
}
