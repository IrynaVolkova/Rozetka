package test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.Reporter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class TestRunner {

    RozetkaPO method = new RozetkaPO();

    @org.testng.annotations.Test

    public void testResult() throws IOException {
        open("https://rozetka.com.ua/");
        Configuration.browserSize = "1920x1080";
        method.chooseLanguage().click();

        method.findAllCopmuters().click();
        method.findLaptops().click();
        method.firstLaptopAddToCart().click();
        method.numberOfItems().should(Condition.be(Condition.visible)).shouldHave(Condition.ownText("1"));
        method.openCart().click();

        method.checkItem().shouldHave(Condition.ownText("Ноутбук Acer Aspire 7 A715-42G-R7BK (NH.QE5EU.00L) Charcoal Black"));
        String name = method.checkItem().getOwnText();
        String price = method.checkPrice().getOwnText();

        Map<String, String> map = new HashMap<>();

        map.put(name, price);
        Reporter.log(map.toString());
        FileWriter fileWriter = new FileWriter("report.txt");
        fileWriter.write(map.toString());
        fileWriter.close();
    }
}
