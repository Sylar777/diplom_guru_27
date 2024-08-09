package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class IndexOfSeriesPage {
    private final SelenideElement tableList = $("[class*='Table_list']:not([class*='Fake'])");
    private final ElementsCollection tableItems = tableList.$$("li");
    private final SelenideElement countriesPicklist = $x("//input[@placeholder='Страны']").parent();
    private final SelenideElement productionPicklist = $x("//input[@placeholder='Производители']").parent();
    private final ElementsCollection countriesPicklistValues = countriesPicklist.sibling(0).$$("li");
    private final ElementsCollection productionPicklistValues = productionPicklist.sibling(0).$$("li");
    private final SelenideElement productionA24 = $("#A24").parent().parent();
    private final SelenideElement countryUsa = $("#США").parent().parent();

    public ElementsCollection getTableItems() {
        return tableItems;
    }

    public ElementsCollection getCountriesPicklistValues() {
        return countriesPicklistValues;
    }

    public ElementsCollection getProductionPicklistValues() {
        return productionPicklistValues;
    }

    public void clickCountryPicklist() {
        countriesPicklist.click();
    }

    public void clickProductionPicklist() {
        productionPicklist.click();
    }

    public void clickCountryUsa() {
        countryUsa.click();
    }

    public void clickProductionA24() {
        productionA24.click();
    }
}
