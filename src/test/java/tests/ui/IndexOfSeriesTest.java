package tests.ui;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("UI")
public class IndexOfSeriesTest extends TestBase {
    @Override
    @BeforeEach
    void setUp() {
        super.setUp();
        open("/special/index/");
    }

    @Test
    void checkTopSeriesSizeTest() {
        step("Check that all top of series shown on the page", () ->
                indexOfSeriesPage.tableItems.shouldHave(size(100))
        );
    }

    @Test
    void countriesPicklistNotEmptyTest() {
        step("Explore countries picklist", () ->
                indexOfSeriesPage.countriesPicklist.click()
        );

        step("Check that countries picklist is not empty", () ->
                indexOfSeriesPage.countriesPicklistValues.shouldHave(sizeGreaterThan(0))
        );
    }

    @Test
    void countryFilterApplyingTest() {
        step("Explore countries picklist and select country from suggested values", () -> {
            indexOfSeriesPage.countriesPicklist.click();
            indexOfSeriesPage.countriesPicklistValues.get(2).click();
        });

        step("Check that shown list of series not full", () ->
                indexOfSeriesPage.tableItems.shouldHave(sizeLessThan(100))
        );
    }
}
