package test;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RozetkaPO {

    public SelenideElement chooseLanguage() {
        return $(byCssSelector(".lang__item"));
    }

    public SelenideElement findAllCopmuters() {
        return $(byLinkText("Ноутбуки и компьютеры"));
    }

    public SelenideElement findLaptops() {
        return $(byLinkText("Ноутбуки"));
    }

    public SelenideElement firstLaptopAddToCart() {
        ElementsCollection results = $$(byCssSelector(".goods-tile__buy-button svg"));
        return results.get(0);
    }

    public SelenideElement numberOfItems() {
        return $(byCssSelector(".counter"));
    }

    public SelenideElement openCart() {
        return $(byXpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart"));
    }

    public SelenideElement checkItem() {
        return $(byCssSelector(".cart-product__title"));
    }

    public SelenideElement checkPrice() {
        return $(byCssSelector(".cart-product__price"));
    }

}
