package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.component.MainMenuDropComponent;
import com.beaverg.domain.Product;
import com.beaverg.pages.HomePage;
import com.beaverg.pages.ProductListPage;
import com.beaverg.pages.ProductPage;
import com.beaverg.utils.PropertyGetter;
import com.beaverg.utils.StringTransform;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Test Site web testing")
@Feature("Product testing")
public class ProductTest extends BaseTest {

    @Test(dataProvider = "getDropMainMenuItems")
    @Story("Product from different pages testing")
    @Description("Comparing products from different pages")
    public void verifyMainMenuItemTest(int mainMenuIndex, int dropIndex, String dropTitle) {
        HomePage homePage = getHomePage();
        int productNumber = Integer.parseInt(PropertyGetter.getData("Product.number"));

        MainMenuDropComponent menuDropComponent = homePage
                .getMainMenuComponent()
                .moveToMainMenuItemByIndex(mainMenuIndex);
        ProductListPage productListPage = menuDropComponent
                .clickDropMainMenuItemByIndex(dropIndex);
        productListPage.isPageOpen(dropTitle);

        Product productFromProductListPage = productListPage
                .getProductListComponent()
                .getProductByIndex(productNumber);
        ProductPage productPage = productListPage
                .getProductListComponent()
                .clickProductByIndex(productNumber);
        productPage.isPageOpen(dropTitle);

        Product productFromProductPage = productPage.getProduct();
        Assert.assertEquals(productFromProductPage, productFromProductListPage, "Products aren't equal!");
    }

    @DataProvider
    protected Object[][] getDropMainMenuItems() {
        setup();
        HomePage homePage = getHomePage();
        int itemsNumber = homePage
                .getMainMenuComponent()
                .getMainMenuItemsTextList()
                .size();
        int counter = 0;
        for (int i = 0; i < itemsNumber; i++) {
            List<SelenideElement> dropItems = homePage
                    .getMainMenuComponent()
                    .moveToMainMenuItemByIndex(i)
                    .getDropMainMenuItemList();
            for (int j = 0; j < dropItems.size(); j++) {
                counter++;
            }
        }
        Object[][] testData = new Object[counter][3];
        int k = 0;
        for (int i = 0; i < itemsNumber; i++) {
            List<SelenideElement> dropItems = homePage
                    .getMainMenuComponent()
                    .moveToMainMenuItemByIndex(i)
                    .getDropMainMenuItemList();
            for (int j = 0; j < dropItems.size(); j++) {
                testData[k][0] = i;
                testData[k][1] = j;
                testData[k][2] = StringTransform.capitalizeWords(dropItems.get(j).getText().toLowerCase());
                k++;
            }
        }
        teardown();
        return testData;
    }
}
