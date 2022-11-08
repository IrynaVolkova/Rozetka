package task.pages;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selenide.$;

public class NotebooksComputers {

    public void findNotebooks() {
        $(byLinkText("Ноутбуки")).click();
    }
}
