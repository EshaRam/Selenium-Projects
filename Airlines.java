package org.example;
//go to AA website, enter 3 letters in booking flight and select the SFO, and check if it is displayed in text box. automate the autosuggestive dropdown


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Airlines {

    WebDriver driver;

    @BeforeMethod

    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "//Users/easwarimuthu/IdeaProjects/SeleniumMaven/src/main/java/resources 1/chromedriver");


        driver = new ChromeDriver();


        driver.get("https://www.aa.com/homePage.do");

    }
    @Test

    public void booking(){

        driver.findElement(By.id("reservationFlightSearchForm.originAirport")).clear();

        driver.findElement(By.id("reservationFlightSearchForm.originAirport")).sendKeys("SFO");
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("San Francisco"))).click();

        driver.findElement(By.xpath("//span[text()='From airport look up']")).click();


    }

    @AfterMethod

    public void teardown(){
        driver.close();
    }
}
