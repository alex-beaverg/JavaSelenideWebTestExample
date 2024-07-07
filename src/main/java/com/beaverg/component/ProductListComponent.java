package com.beaverg.component;

import com.beaverg.domain.Product;
import com.beaverg.pages.ProductPage;
import com.beaverg.utils.Waits;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

import static com.beaverg.utils.Locators.getLocator;
import static com.codeborne.selenide.Selenide.*;

public class ProductListComponent {
    private final SelenideElement component;
    private final ElementsCollection productNameList;
    private final ElementsCollection productPriceList;
    private final SelenideElement currency;

    public ProductListComponent(SelenideElement component) {
        this.component = component;
        productNameList = $$(getLocator("ProductListComponent.names"));
        productPriceList = $$(getLocator("ProductListComponent.prices"));
        currency = $(getLocator("ProductListComponent.currency"));
    }

    private String getProductNameByIndex(int index) {
        return productNameList.get(index).getText();
    }

    private double getProductPriceByIndex(int index) {
        return Double.parseDouble(productPriceList.get(index).getText());
    }

    public Product getProductByIndex(int index) {
        Waits.waitTextInElement(currency, "£");
        return new Product(getProductNameByIndex(index), getProductPriceByIndex(index));
    }

    public ProductPage clickProductByIndex(int index) {
        productNameList.get(index).click();
        return page(ProductPage.class);
    }
}
