package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final SelenideElement searchInput = $("input[name='kp_query']");
    private final ElementsCollection suggestedArticlesList = $$(".kinopoisk-header-suggest-item");

    public String getArticleTitle(SelenideElement article) {
        return article.$("a").getText();
    }

    public SelenideElement getSearchInput() {
        return searchInput;
    }

    public ElementsCollection getSuggestedArticlesList() {
        return suggestedArticlesList;
    }
}
