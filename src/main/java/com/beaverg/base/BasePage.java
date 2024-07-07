package com.beaverg.base;

import com.beaverg.component.LoginComponent;
import com.beaverg.component.MainMenuComponent;
import io.qameta.allure.Step;

import static com.beaverg.utils.PropertyGetter.*;
import static com.beaverg.utils.Locators.getLocator;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    private final LoginComponent loginComponent;
    private final MainMenuComponent mainMenuComponent;
    private final String prefix;
    private final String postfix;

    public BasePage() {
        loginComponent = new LoginComponent($(getLocator("BasePage.loginComponent")));
        mainMenuComponent = new MainMenuComponent($(getLocator("BasePage.menuComponent")));
        prefix = getData("BasePage.titlePrefix") + " ";
        postfix = " " + getData("BasePage.titlePrefix");
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public MainMenuComponent getMainMenuComponent() {
        return mainMenuComponent;
    }

    @Step("Checking opening current Page")
    public void isPageOpen(String titleText) {
        $(getLocator("BasePage.title")).shouldHave(innerText(prefix + titleText + postfix));
    }

    @Step("Checking not opening current Page")
    public void isPageNotOpen(String titleText) {
        $(getLocator("BasePage.title")).shouldNotHave(innerText(prefix + titleText + postfix));
    }
}
