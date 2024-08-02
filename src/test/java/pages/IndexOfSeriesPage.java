package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class IndexOfSeriesPage {
    public final SelenideElement tableList = $("[class*='Table_list']:not([class*='Fake'])");
    public final ElementsCollection tableItems = tableList.$$("li");
    public final SelenideElement countriesPicklist = $x("//input[@placeholder='Страны']").parent();
    public final ElementsCollection countriesPicklistValues = countriesPicklist.sibling(0).$$("li");
}
