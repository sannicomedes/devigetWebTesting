package com.deviget.devigetWebTesting.components.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver;
    protected By aCloseButton = By.xpath("//a[@class='next-dialog-close']");
    public PageBase(WebDriver driver)
    {
        this.driver=driver;
    }

    public void closeNewUserContainer() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(aCloseButton));
            driver.findElement(aCloseButton).click();
        } catch (Exception e) {
        }
    }
}


