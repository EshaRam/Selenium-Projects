package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Pagination {

    WebDriver driver;

    @BeforeMethod

    public void setUp(){
        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver 2");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");

    }
    @Test

    public void page(){
        WebElement search = driver.findElement(By.name("q"));
        search.sendKeys("bigg boss");
        search.submit();

        List<WebElement> pagelist =  driver.findElements(By.className("AaVjTc"));
        if(pagelist.size()>0){
            System.out.println("pagination exists");

// click on pagination link

            for(int i=0; i<pagelist.size(); i++){

                pagelist.get(i).click();

            }
        } else {
            System.out.println("pagination doesn't exists");
        }
    }
    public void tearDown(){
        driver.quit();
    }
}
