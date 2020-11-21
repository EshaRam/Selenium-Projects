package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Iframes {
    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver 2");
        driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    }
    @Test

    public void iframecount(){

        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
        int numberOfTags = iframes.size();
        System.out.println("No. of Iframes on this Web Page are: " +numberOfTags);

        //By executing a java script
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        Integer noOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
        System.out.println("No. of iframes on the page are " + noOfFrames);

       //String name = driver.switchTo().frame(0).getTitle();
       // System.out.println(name);


        driver.switchTo().frame("packageListFrame");
        List<WebElement> framelist = driver.findElements(By.tagName("li"));
        int count = framelist.size();
        System.out.println(count);
        for (WebElement l:framelist) {
            System.out.println(l.getText());//.contains("node"));
        }
        driver.switchTo().defaultContent();





    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
