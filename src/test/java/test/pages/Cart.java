package test.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class Cart {

    public void openCart() {
        $(byXpath("/html/body/app-root/div/div/rz-header/rz-main-header/header/div/div/ul/li[7]/rz-cart")).click();
    }

    public SelenideElement checkItem() {
        return $(byCssSelector(".cart-product__title"));
    }

    public String findName() {
        return $(byCssSelector(".cart-product__title")).getOwnText();
    }

    public String findPrice() {
        return $(byCssSelector(".cart-product__price")).getOwnText();
    }
}
