package com.deviget.devigetWebTesting.components.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class homePage extends PageBase{
    private By inputSearchItem = By.id("search-key");
    private By inputSearchButton = By.className("search-button");
    public By itemsList = By.xpath("//ul[@class='list-items']/li");
    private By inputGoToPage = By.xpath("//span[@class='next-input next-large']/input");
    private By spanButtonGo = By.className("jump-btn");

    public homePage(WebDriver driver) {
        super(driver);
    }
    public void searchItem (String text) {
        driver.findElement(inputSearchItem).sendKeys(text);
        driver.findElement(inputSearchButton).click();
    }
    public void goToPage(String pageNumber) {
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        actions.moveToElement(driver.findElement(inputGoToPage));
        driver.findElement(inputGoToPage).sendKeys(pageNumber);
        driver.findElement(spanButtonGo).click();
    }
}

