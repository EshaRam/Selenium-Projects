package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class DatabaseTestingUtils {
    WebDriver driver;

    @BeforeMethod

    public void setUp(){

        System.setProperty("webdriver.chrome.driver","/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test

    public void result() throws InterruptedException {

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        Actions action = new Actions(driver);

        WebElement admin = driver.findElement(By.xpath("//a[@id='menu_admin_viewAdminModule']"));
        WebElement userMgmt = driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
        WebElement users = driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']"));

        action.moveToElement(admin).moveToElement(userMgmt).moveToElement(users).click().build().perform();
        Thread.sleep(5000);

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));
        int rowcount = rows.size();


        for (int i=1;i<= rowcount;i++){
            String username = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[2]")).getText();
            String userrole = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[3]")).getText();
            String employeename= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[4]")).getText();
            String status = driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + i + "]/td[5]")).getText();
            System.out.println(username + " " + userrole + "  " +  employeename + " "+ status);
            DatabaseTesting.CompareWithDatabase(username,userrole,employeename,status);


        }

    }

    @AfterMethod

    public void tearDown(){
        driver.quit();
    }

}

