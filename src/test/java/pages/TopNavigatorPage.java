package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TopNavigatorPage {
    public final SelenideElement budgetMinPicklist = $("select[name='m_act[budget][min]']");
    public final SelenideElement budgetMaxPicklist = $("select[name='m_act[budget][max]']");
    public final SelenideElement popUpText = $(".tdtext");
}
