package com.deviget.devigetWebTesting.components;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
    private WebDriver driver;
    Log log = LogFactory.getLog(getClass());

    public void setup() throws MalformedURLException {
        log.info("Webdriver is setting up ");
        ChromeDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(GlobalParameters.DEFAULT_DRIVER_TIMEOUT, TimeUnit.SECONDS);
        driver.get("http://www.aliexpress.com/");
    }
    public WebDriver getDriver()
    {
        return driver;
    }
}

