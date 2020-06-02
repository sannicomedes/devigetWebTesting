package com.deviget.devigetWebTesting.tests;

import com.deviget.devigetWebTesting.components.SetUp;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class TestBase {
    protected WebDriver driver;
    protected SetUp service = new SetUp();
    private static Log log = LogFactory.getLog(TestBase.class);

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
            log.info("Driver Close failed");
        }

        try {
            driver.quit();
        }
        catch (Exception e)
        {
            log.info("Driver Quit failed");
        }
    }
}
