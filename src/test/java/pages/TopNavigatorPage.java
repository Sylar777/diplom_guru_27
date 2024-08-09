package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TopNavigatorPage {
    private final SelenideElement budgetMinPicklist = $("select[name='m_act[budget][min]']");
    private final SelenideElement budgetMaxPicklist = $("select[name='m_act[budget][max]']");
    private final SelenideElement popUpText = $(".tdtext");

    public void selectMinBudgetValue(String minBudget) {
        budgetMinPicklist.selectOption(minBudget);
    }

    public void selectMaxBudgetValue(String maxBudget) {
        budgetMaxPicklist.selectOption(maxBudget);
    }

    public SelenideElement getPopUpText() {
        return popUpText;
    }
}
