package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxCall {

    private String URL = "http://demo.guru99.com/test/ajax.html";

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver 2");
        //create chrome instance
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to(URL);
    }

    @Test
    public void test_AjaxExample() {

        By container = By.cssSelector(".container");
        wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(container));

        //Get the text before performing an ajax call
        WebElement noTextElement = driver.findElement(By.className("radiobutton"));
        String textBefore = noTextElement.getText().trim();
        System.out.println(textBefore);

        //Click on the radio button
        driver.findElement(By.id("yes")).click();

        //Click on Check Button
        driver.findElement(By.id("buttoncheck")).click();

        /*Get the text after ajax call*/
        WebElement TextElement = driver.findElement(By.className("radiobutton"));
        wait.until(ExpectedConditions.visibilityOf(TextElement));
        String textAfter = TextElement.getText().trim();

        /*Verify both texts before ajax call and after ajax call text.*/
        Assert.assertNotEquals(textBefore, textAfter);

        System.out.println(textAfter);
        System.out.println("Ajax Call Performed");

        String expectedText = "Radio button is checked and it's value is Yes";

        /*Verify expected text with text updated after ajax call*/
        Assert.assertEquals(textAfter, expectedText);

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}

