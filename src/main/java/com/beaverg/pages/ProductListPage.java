package com.beaverg.pages;

import com.beaverg.base.BasePage;
import com.beaverg.component.ProductListComponent;

import static com.beaverg.utils.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;

public class ProductListPage extends BasePage {
    private final ProductListComponent productListComponent;

    public ProductListPage() {
        productListComponent = new ProductListComponent($(getLocator("ProductListPage.productListComponent")));
    }

    public ProductListComponent getProductListComponent() {
        return productListComponent;
    }
}
