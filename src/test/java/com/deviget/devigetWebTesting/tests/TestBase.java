package com.deviget.devigetWebTesting.tests;

import com.deviget.devigetWebTesting.components.SetUp;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class TestBase {
    protected WebDriver driver;
    protected SetUp service = new SetUp();

    @BeforeClass
    public void setup() {
        try {
            service.setup();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver=service.getDriver();

    }

    @AfterClass
    public void cleanup() {
        try{
            driver.close();
        }
        catch (Exception e)
        {
            System.out.println("Driver Close failed");
        }

        try {
            driver.quit();
        }
        catch (Exception e)
        {
            System.out.println("Driver Quit failed");
        }
    }
}
