package task;

import com.codeborne.selenide.Condition;
import org.testng.Reporter;
import org.testng.annotations.Test;
import task.pages.Cart;
import task.pages.HomePage;
import task.pages.Notebooks;
import task.pages.NotebooksComputers;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TestRun {

    HomePage open = new HomePage();

    NotebooksComputers redirect = new NotebooksComputers();

    Notebooks notebooks = new Notebooks();

    Cart cart = new Cart();

    @Test
    public void testResult() throws IOException {
        open.chooseLanguage();
        open.findNotebooksComps();

        redirect.findNotebooks();

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
        fileWriter.write(map.toString().replace(" ", " "));
        fileWriter.close();
    }
}
