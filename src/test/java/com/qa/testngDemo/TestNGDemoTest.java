package com.qa.testngDemo;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNGDemoTest extends BaseTest{


    //https://naveenautomationlabs.com/3-how-to-write-selenium-webdriver-test-with-testng-maven-project/
    @Test(priority = 1)
    public void verifySearchBox()
    {
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(driver.findElement(By.xpath(".//*[@name='q']")).isDisplayed());


    }

    @Test(priority = 2)
    public void verifyGoogleSearchButton()
    {
        System.out.println(driver.findElement(By.xpath(".//*[@name='q']")).isDisplayed());
    }

}
