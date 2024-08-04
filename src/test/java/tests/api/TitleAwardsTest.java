package tests.api;

import helpers.ResponseRestApi;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static helpers.ResponseRestApi.getErrorResponseForTitleAwards;
import static helpers.ResponseRestApi.getTitleAwards;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Java6Assertions.assertThat;

@Tag("API")
public class TitleAwardsTest extends TestBase {
    @Test
    void checkThatTitleAwardsNotEmptyTest() {
        var response = step("Request title awards via API", () -> {
            return getTitleAwards(1, 3, true);
        });

        step("Check that total of Title awards more then 0", () -> {
            assertThat(response.getTotal())
                    .as("Total of Title awards")
                    .isGreaterThan(0);
        });
    }

    @Test
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
