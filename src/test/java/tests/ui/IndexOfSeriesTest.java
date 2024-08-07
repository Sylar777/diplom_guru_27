package tests.ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("UI")
@Owner("Daniil Sosnovskiy")
@Feature("Index of Series")
public class IndexOfSeriesTest extends TestBase {
    @BeforeEach
    void setUp() {
        open("/special/index/");
    }

    @Test
    @DisplayName("Check that all top of series shown on the page")
    void checkTopSeriesSizeTest() {
        step("Check that all top of series shown on the page", () ->
                indexOfSeriesPage.tableItems.shouldHave(size(100))
        );
    }

    @Test
    @DisplayName("Check that countries picklist is not empty")
    void countriesPicklistNotEmptyTest() {
        step("Explore countries picklist", () ->
                indexOfSeriesPage.countriesPicklist.click()
        );

        step("Check that countries picklist is not empty", () ->
                indexOfSeriesPage.countriesPicklistValues.shouldHave(sizeGreaterThan(0))
        );
    }

    @Test
    @DisplayName("Check that country filter applying works")
    void countryFilterApplyingTest() {
        step("Explore countries picklist and select country from suggested values", () -> {
            indexOfSeriesPage.countriesPicklist.click();
            indexOfSeriesPage.countriesPicklistValues.get(2).click();
        });

        step("Check that shown list of series not full", () ->
                indexOfSeriesPage.tableItems.shouldHave(sizeLessThan(100))
        );
    }

    @Test
    @DisplayName("Check that production filter applying works")
    void productionFilterApplyingTest() {
        step("Explore production picklist and select production from suggested values", () -> {
            indexOfSeriesPage.productionPicklist.click();
            indexOfSeriesPage.productionPicklistValues.get(2).click();
        });

        step("Check that shown list of series not full", () ->
                indexOfSeriesPage.tableItems.shouldHave(sizeLessThan(100))
        );
    }

    @Test
    @DisplayName("Check cross filtering by country and production")
    void crossFilterApplyingTest() {
        step("Explore countries picklist and select 'США' country from suggested values", () -> {
            indexOfSeriesPage.countriesPicklist.click();
            indexOfSeriesPage.countryUsa.click();
        });

        step("Explore production picklist and select 'A24' production from suggested values", () -> {
            indexOfSeriesPage.productionPicklist.click();
            indexOfSeriesPage.productionA24.click();
        });

        step("Check that shown list of series not empty and not full", () -> {
            indexOfSeriesPage.tableItems.shouldHave(sizeLessThan(100));
            indexOfSeriesPage.tableItems.shouldHave(sizeGreaterThan(0));
        });
    }
}
