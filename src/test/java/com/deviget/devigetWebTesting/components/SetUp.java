package com.deviget.devigetWebTesting.components;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;

public class SetUp {
    private WebDriver driver;

    public void setup() throws MalformedURLException {
        System.out.println("Webdriver is setting up ");
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

