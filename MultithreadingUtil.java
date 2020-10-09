package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class MultithreadingUtil extends Thread{
    WebDriver driver;
    protected String Url;
    protected String browsertype;

    public MultithreadingUtil(String name, String browsertype) {

        super(name);

        this.browsertype = browsertype;

    }

    @Override
    public void run() {

        System.out.println("Thread- Started" + "is" +Thread.currentThread().getName());

        String threadname = Thread.currentThread().getName();

        System.out.println(threadname);

        try {
            Thread.sleep(1000);
            setUp(this.browsertype);
            facebookLogo();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread- END " + Thread.currentThread().getName());
    }

    @BeforeMethod

    public void setUp(String browsertype) throws Exception {
        if (browsertype.contains("chrome")) {

            System.setProperty("webdriver.chrome.driver", "/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver");
            driver = new ChromeDriver();
        } else if (browsertype.contains("firefox")) {

            System.setProperty("webdriver.gecko.driver", "/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/geckodriver");


            driver = new FirefoxDriver();

        }

        Url = "https://www.facebook.com/";

        driver.get(Url);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }
    @Test
    public void facebookLogo() {

        WebElement logo= driver.findElement(By.cssSelector("a[title='Go to Facebook Home'] > .fb_logo.img.sp_R3u_6E07bqo.sx_a4c606"));
        boolean logocheck = logo.isDisplayed();
        System.out.println(logocheck);

    }


    @AfterMethod

    public void tearDown(){
        driver.quit();
    }



}





