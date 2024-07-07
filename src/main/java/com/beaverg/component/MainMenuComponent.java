package com.beaverg.component;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static com.beaverg.utils.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$$;

public class MainMenuComponent {
    private final SelenideElement menu;
    private final ElementsCollection itemsList;

    public MainMenuComponent(SelenideElement menu) {
        this.menu = menu;
        itemsList = $$(getLocator("MainMenuComponent.itemsList"));
    }

    public List<String> getMainMenuItemsTextList() {
        return itemsList.stream().map(item -> item.getText().toLowerCase()).toList();
    }

    public MainMenuDropComponent moveToMainMenuItemByIndex(int index) {
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        actions.moveToElement(itemsList.get(index)).perform();
        return new MainMenuDropComponent(index + 1);
    }
}
