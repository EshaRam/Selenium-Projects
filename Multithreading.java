package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class Multithreading extends Thread {

    private WebDriver driver;

    private String Url;

    private String browsertype;

    public Multithreading(String name, String browsertype) {

        super(name);

        this.browsertype = browsertype;

    }

    @Override
    public void run() {

        System.out.println("Thread- Started" + Thread.currentThread().getName());

        String threadname = Thread.currentThread().getName();

        System.out.println(threadname);

        try {
            //Thread.sleep(1000);
            setUp(this.browsertype);
            testGoogleSearch();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thread- END " + Thread.currentThread().getName());
    }

    // main method to create the thread and run multiple threads
    public static void main(String[] args) {
        Thread t1 = new Multithreading("Thread Chrome", "chrome");

        Thread t2 = new Multithreading("Thread Firefox", "firefox");
        System.out.println("Starting MyThreads");
        t1.start();

        t2.start();
        System.out.println("Thread has been started");
    }

    // set up the method to initialize driver object
    public void setUp(String browsertype) throws Exception {
        if (browsertype.contains("chrome")) {

            System.setProperty("webdriver.chrome.driver", "/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/chromedriver");
            driver = new ChromeDriver();
        } else if (browsertype.contains("firefox")) {

            System.setProperty("webdriver.gecko.driver", "/Users/easwarimuthu/IdeaProjects/Selenium Practice/src/main/resources2/geckodriver");


            driver = new FirefoxDriver();

        }

        Url = "https://www.google.co.in/";

        driver.get(Url);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.manage().window().maximize();

    }

    // test scripts

    public void testGoogleSearch() throws Exception {

        String actualtitle = driver.getTitle();

        String expectedTitle = "Google";

        Assert.assertEquals(actualtitle, expectedTitle, "The expected title matched");

        System.out.println(" actual title is" + actualtitle);
        System.out.println("expected title is" + expectedTitle);

    }

    // tear down function to close browser

    public void tearDown() {

        driver.close();

        driver.quit();

    }


}
