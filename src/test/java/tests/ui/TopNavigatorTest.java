package tests.ui;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("UI")
public class TopNavigatorTest extends TestBase {
    private final String minBudget = "250";
    private final String maxBudget = "50";

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        open("/top/navigator/");
    }

    @Test
    void picklistValidationTest() {
        step("Select budget min = " + minBudget + " and budget max = " + maxBudget, () -> {
            topNavigatorPage.budgetMinPicklist.selectOption(minBudget);
            topNavigatorPage.budgetMaxPicklist.selectOption(maxBudget);
        });

        step("Check that pop-up with error message is visible", () -> {
            topNavigatorPage.popUpText.shouldBe(visible);
        });
    }
}
