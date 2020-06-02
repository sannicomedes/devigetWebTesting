package com.deviget.devigetWebTesting.tests;

import com.deviget.devigetWebTesting.components.pages.homePage;
import org.testng.annotations.Test;

public class VerifyItemTest extends TestBase {
    @Test(priority = 0, description = "Check Item is Buyable")
    public void checkItemIsBuyable()
    {   homePage user = new homePage(driver);

        user.closeNewUserContainer();
        user.searchItem("iphone");
        user.closeNewUserContainer();
        user.goToPage("2");
    }
}
