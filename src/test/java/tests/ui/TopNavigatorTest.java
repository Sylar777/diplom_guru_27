package tests.ui;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class TopNavigatorTest extends TestBase {
    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        open("/top/navigator/");
    }

    @Test
    void picklistValidationTest() {
        topNavigatorPage.budgetMinPicklist.selectOption("250");
        topNavigatorPage.budgetMaxPicklist.selectOption("50");
        topNavigatorPage.popUpText.shouldBe(visible);
    }
}
