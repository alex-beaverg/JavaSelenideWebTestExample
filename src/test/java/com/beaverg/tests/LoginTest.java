package com.beaverg.tests;

import com.beaverg.base.BaseTest;
import com.beaverg.pages.AccountPage;
import com.beaverg.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import static com.beaverg.utils.PropertyGetter.*;
import static com.beaverg.services.AccountService.*;

@Epic("Test Site web testing")
@Feature("Logining testing")
public class LoginTest extends BaseTest {

    @Test
    @Story("Successful logining testing")
    @Description("Successful logining test")
    public void verifySuccessfulLoginTest() {
        HomePage homePage = getHomePage();
        AccountPage accountPage = homePage
                .getLoginComponent()
                .clickSignInButton()
                .attemptLogin(createValidAccount());
        accountPage.isPageOpen(getData("AccountPage.title"));
    }

    @Test
    @Story("Unsuccessful logining testing")
    @Description("Unsuccessful logining test")
    public void verifyUnsuccessfulLoginTest() {
        HomePage homePage = getHomePage();
        AccountPage accountPage = homePage
                .getLoginComponent()
                .clickSignInButton()
                .attemptLogin(createInvalidAccount());
        accountPage.isPageNotOpen(getData("AccountPage.title"));
    }

    @Test
    @Story("Successful logout testing")
    @Description("Successful logout test")
    public void verifySuccessfulLogoutTest() {
        HomePage homePage = getHomePage();
        AccountPage accountPage = homePage
                .getLoginComponent()
                .clickSignInButton()
                .attemptLogin(createValidAccount());
        accountPage.isPageOpen(getData("AccountPage.title"));
        homePage = accountPage.clickLogoutButton();
        homePage.isPageOpen(getData("HomePage.title"));
    }
}
