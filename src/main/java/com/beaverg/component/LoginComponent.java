package com.beaverg.component;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.beaverg.utils.Locators.getLocator;
import static com.codeborne.selenide.Selenide.page;

public class LoginComponent {
    private final SelenideElement buttons;

    public LoginComponent(SelenideElement buttons) {
        this.buttons = buttons;
    }

    @Step("Clicking 'Sign In' button in 'Login Component'")
    public SignInComponent clickSignInButton() {
        buttons.$(getLocator("LoginComponent.signInButton")).click();
        return page(SignInComponent.class);
    }
}
