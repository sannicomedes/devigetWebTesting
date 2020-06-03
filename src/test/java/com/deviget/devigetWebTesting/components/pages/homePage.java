package com.deviget.devigetWebTesting.components.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage extends PageBase{
    public By inputSearchItem = By.id("search-key");
    public By inputSearchButton = By.className("search-button");
    public By inputGoToPage = By.xpath("//span[@class='next-input next-large']/input");
    public By spanButtonGo = By.className("jump-btn");
    public By divStarLoadingTip = By.className("next-overlay-inner next-loading-tip");
    public By aItemTitle = By.xpath(".//a[@class='item-title']");
    public By buttonBuyNow = By.xpath("//span[@class='buy-now-wrap']/button[contains(@class,'buynow')]");

    public homePage(WebDriver driver) {
        super(driver);
    }
    public void searchItem (String text) {
        driver.findElement(inputSearchItem).sendKeys(text);
        driver.findElement(inputSearchButton).click();
    }
    public WebElement getPage(String pageNumber) {
        return driver.findElement(By.xpath("//button[contains(@aria-label,'" + pageNumber + "')]"));
    }
    public WebElement getAd(int i) {
        return driver.findElement(By.xpath("//ul[@class='list-items']/li[" + i + "]"));
    }
}

