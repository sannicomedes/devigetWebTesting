package com.deviget.devigetWebTesting.components.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver;
    protected By divNewUserContainer = By.className("newuser-container");
    protected By aGetCouponsNow = By.xpath("//a[text()='Get coupons now']");
    protected By aCloseButton = By.xpath("//a[@class='next-dialog-close']");
    public PageBase(WebDriver driver)
    {
        this.driver=driver;
    }


    public void clickOnGetCoupons() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Object[] windows;
        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(divNewUserContainer)));
            driver.findElement(aGetCouponsNow).click();
            windows = driver.getWindowHandles().toArray();
            driver.switchTo().window(windows[1].toString()).close();
            driver.switchTo().window(windows[0].toString());
        } catch (Exception e) {
        }
    }
    public void closeNewUserContainer() {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        try {
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(divNewUserContainer)));
            driver.findElement(aCloseButton).click();
        } catch (Exception e) {
        }
    }
}


