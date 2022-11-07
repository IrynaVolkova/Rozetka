package test;

import com.codeborne.selenide.Condition;
import org.testng.Reporter;
import org.testng.annotations.Test;
import test.pages.Cart;
import test.pages.HomePage;
import test.pages.Notebooks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRun {

    HomePage open = new HomePage();

    Notebooks notebooks = new Notebooks();

    Cart cart = new Cart();

    @Test
    public void testResult() throws IOException {
        open.chooseLanguage();
        open.findLaptopsComps();

        notebooks.findNotebooks();
        notebooks.addFirstToCart();
        notebooks.numberOfItems().shouldHave(Condition.ownText("1"));

        cart.openCart();
        cart.checkItem().shouldHave(Condition.ownText("Ноутбук Acer Aspire 7 A715-42G-R7BK (NH.QE5EU.00L) Charcoal Black"));

        String name = cart.findName();
        String price = cart.findPrice();

        Map<String, String> map = new HashMap<>();

        map.put(name, price);
        Reporter.log(map.toString());
        FileWriter fileWriter = new FileWriter("report.txt");
        fileWriter.write(map.toString());
        fileWriter.close();
    }
}
