package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScrollTo {
    WebDriver driver;
    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver 2");
        driver = new ChromeDriver();
        driver.get("http://whiteboxqa.com/");
    }
    @Test

    public void scroll() throws InterruptedException {

        WebElement testimonial = driver.findElement(By.cssSelector("#footerbot1 [href='mailto\\:info\\@whitebox-learning\\.com']"));

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);", testimonial);
        js.executeScript("document.querySelector('body').scrollTop-=200;");
        //Thread.sleep(2000);
        testimonial.click();



    }
    @AfterMethod

    public void tearDown(){
        driver.quit();
    }
}
