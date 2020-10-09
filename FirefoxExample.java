package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirefoxExample {

    WebDriver driver;

    @BeforeMethod

    public void setUp(){

        System.setProperty("webdriver.gecko.driver","/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test

    public void logo(){

       WebElement logocheck = driver.findElement(By.cssSelector(".sx_125510"));
       logocheck.isDisplayed();


    }
    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}
