package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.domain.Product;
import com.codeborne.selenide.SelenideElement;

import static com.beaverg.utils.LocatorGetter.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage extends BasePage {
    private final SelenideElement productName;
    private final SelenideElement productPrice;

    public ProductPage() {
        productName = $(getLocator("ProductPage.name"));
        productPrice = $(getLocator("ProductPage.price"));
    }

    private String getProductName() {
        return productName.getText();
    }

    private double getProductPrice() {
        return Double.parseDouble(productPrice.getText());
    }

    public Product getProduct() {
        return new Product(getProductName(), getProductPrice());
    }
}
