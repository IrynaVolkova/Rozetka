package test.pages;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selectors.byCssSelector;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    public void chooseLanguage() {
        open("https://rozetka.com.ua/");
        Configuration.browserSize = "1920x1080";
        $(byCssSelector(".lang__item")).click();
    }

    public void findLaptopsComps() {
        $(byLinkText("Ноутбуки и компьютеры")).click();
    }

}
