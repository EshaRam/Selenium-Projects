package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChromeHeadless {
    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver 2");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.get("http://whiteboxqa.com/");
    }
    @Test

    public void headless(){
       WebElement logo =  driver.findElement(By.id("logo"));
       boolean logocheck = logo.isDisplayed();
        Assert.assertEquals(logocheck,true);
        System.out.println(logocheck);
    }

    public void tearDown(){

        driver.quit();
    }
}
