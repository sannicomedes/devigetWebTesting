package com.deviget.devigetWebTesting.tests;

import com.deviget.devigetWebTesting.components.pages.homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyItemTest extends TestBase {
    String resultsPage = "2";
    String searchCriteria = "iphone";
    String pageNumber = "Page 2";
    String page;
    int item = 2;

    @Test(description = "Check Item is For Sale")
    public void checkItemIsForSale()
    {   homePage user = new homePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Object[] windows;

        // Clicking on get Coupons
        user.clickOnGetCoupons();
        // Search item
        user.searchItem(searchCriteria);
        // Close pop up
        user.closeNewUserContainer();
        // Go to expected result page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(user.inputGoToPage).sendKeys(resultsPage);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(user.spanButtonGo));
        // Waiting for star disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(user.divStarLoadingTip));
        // Moving to the bottom of results page
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        page = user.getPage(pageNumber).getText();
        // Validating the user is in the expected result page
        Assert.assertTrue(page.equalsIgnoreCase(resultsPage));
        // Going to top of page
        wait.until(ExpectedConditions.invisibilityOfElementLocated(user.divStarLoadingTip));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0)");
        WebElement relatedAd = user.getAd(item);
        if (relatedAd.findElement(user.aItemTitle).getText().toLowerCase().contains(searchCriteria)) {
            System.out.println("This is the second iphone related ad: " + relatedAd.findElement(user.aItemTitle).getText());
            relatedAd.findElement(user.aItemTitle).click();
            windows = driver.getWindowHandles().toArray();
            driver.switchTo().window(windows[1].toString());
            // Validating the related add has item to be bought
            Assert.assertTrue(driver.findElement(user.buttonBuyNow).getText().equalsIgnoreCase("Buy Now"));
            driver.switchTo().window(windows[0].toString());
        }
    }
}
