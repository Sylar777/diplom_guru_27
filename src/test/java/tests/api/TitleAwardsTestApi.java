package tests.api;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static steps.ResponseRestApiSteps.getErrorResponseForTitleAwards;
import static steps.ResponseRestApiSteps.getTitleAwards;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Tag("API")
@Owner("Daniil Sosnovskiy")
@Feature("Title Awards")
public class TitleAwardsTestApi extends TestBaseApi {
    @Test
    @DisplayName("Check that response has requested amount of items")
    void checkThatTitleAwardsNotEmptyTest() {
        var response = step("Request title awards via API", () -> {
            return getTitleAwards(1, 3, true);
        });

        step("Check that total of Title awards more then 0", () -> {
            assertThat(response.getTotal())
                    .as("Total of Title awards")
                    .isEqualTo(3);
        });
    }

    @Test
    @DisplayName("Check error message for empty winning parameter")
    void checkErrorMessageForEmptyWinningParameterTest() {
        var response = step("Request title awards with empty winning parameter via API", () -> {
            return getErrorResponseForTitleAwards(1, 3);
        });

        step("Check error response message", () -> {
            assertThat(response.getMessage().get(0))
                    .as("Error message")
                    .isEqualTo("Значение поля winning должно быть указано!");
        });
    }
}
