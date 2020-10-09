package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertExample {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //tell the location of driver
        System.setProperty("webdriver.chrome.driver", "/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver");

        //create object of chrome driver class
        driver = new ChromeDriver();

        //open the url in browser
        driver.get("http://demo.guru99.com/test/delete_customer.php");
    }

    @Test
    public void alertEx() throws InterruptedException {
        driver.findElement(By.name("cusid")).sendKeys("21324");
        driver.findElement(By.name("submit")).submit();

       Alert alt = driver.switchTo().alert();
       Thread.sleep(2000);
        String message = alt.getText();
        System.out.println(message);

        alt.accept();

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
