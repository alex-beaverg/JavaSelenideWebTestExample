package com.beaverg.utils;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    private static final Duration duration = Duration.ofSeconds(3);

    public static void waitTextInElement(SelenideElement element, String text) {
        (new WebDriverWait(WebDriverRunner.getWebDriver(), duration))
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
