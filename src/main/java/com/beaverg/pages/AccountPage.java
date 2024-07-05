package com.beaverg.pages;

import com.beaverg.base.BasePage;
import io.qameta.allure.Step;

import static com.beaverg.utils.Locators.getLocator;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class AccountPage extends BasePage {

    @Step("Clicking 'Logout' button in 'Account Page'")
    public HomePage clickLogoutButton() {
        $(getLocator("AccountPage.logoutButton")).click();
        return page(HomePage.class);
    }
}
