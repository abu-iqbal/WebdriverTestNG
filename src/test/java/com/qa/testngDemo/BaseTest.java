package com.qa.testngDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    @BeforeSuite
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeTest
    public void googleTest()
    {
            //  driver.get("https://www.google.co.in/");
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void tearDown()
    {
              driver.quit();
    }

}
