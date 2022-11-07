package test.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Notebooks {
    public void findNotebooks() {
        $(byLinkText("Ноутбуки")).click();
    }

    public void addFirstToCart() {
        ElementsCollection results = $$(byCssSelector(".goods-tile__buy-button svg"));
        results.get(0).doubleClick();
    }

    public SelenideElement numberOfItems() {
        return $(byCssSelector(".counter"));
    }
}
