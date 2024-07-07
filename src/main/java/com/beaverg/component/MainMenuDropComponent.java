package com.beaverg.component;

import com.beaverg.pages.ProductListPage;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import java.util.stream.Collectors;

import static com.beaverg.utils.LocatorGetter.getDynamicLocator;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class MainMenuDropComponent {
    private final int index;
    private List<SelenideElement> dropMenuItems;

    public MainMenuDropComponent(int index) {
        this.index = index;
    }

    public List<SelenideElement> getDropMainMenuItemList() {
        dropMenuItems = $$(getDynamicLocator("MainMenuDropComponent.itemsList", index)).stream().collect(Collectors.toList());
        return dropMenuItems;
    }

    public ProductListPage clickDropMainMenuItemByIndex(int dropIndex) {
        getDropMainMenuItemList().get(dropIndex).click();
        return page(ProductListPage.class);
    }
}