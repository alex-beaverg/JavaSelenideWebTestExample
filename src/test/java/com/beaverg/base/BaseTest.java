package com.beaverg.base;

import com.beaverg.pages.HomePage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.beaverg.utils.PropertyGetter.getData;
import static com.beaverg.utils.PropertyGetter.getProperty;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        open();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    public HomePage getHomePage() {
        HomePage homePage = open(getProperty("home_url"), HomePage.class);
        homePage.isPageOpen(getData("HomePage.title"));
        return homePage;
    }

    @AfterMethod(alwaysRun = true)
    public void teardown() {
        closeWebDriver();
    }
}
