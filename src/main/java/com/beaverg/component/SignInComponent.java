package com.beaverg.component;

import com.beaverg.domain.Account;
import com.beaverg.pages.AccountPage;
import io.qameta.allure.Step;

import static com.beaverg.utils.LocatorGetter.getLocator;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SignInComponent {

    @Step("Entering email in Email input")
    private void enterEmail(String email) {
        $(getLocator("SignInComponent.emailInput")).sendKeys(email);
    }

    @Step("Entering password in Password input")
    private void enterPass(String pass) {
        $(getLocator("SignInComponent.passInput")).sendKeys(pass);
    }

    @Step("Clicking 'Sign In' button in 'Sign In Component' after entering Email and Password")
    private void clickSignInButton() {
        $(getLocator("SignInComponent.signInButton")).click();
    }

    @Step("Attempt to log in")
    public AccountPage attemptLogin(Account account) {
        enterEmail(account.getEmail());
        enterPass(account.getPassword());
        clickSignInButton();
        return page(AccountPage.class);
    }
}
