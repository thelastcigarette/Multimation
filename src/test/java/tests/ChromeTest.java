package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by onemantoughcrowd on 8/24/15.
 */
public class ChromeTest {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() {
        // Download the Chromedriver and put it someplace you can point to like below
        System.setProperty("webdriver.chrome.driver", "/Users/jmcfarla/Desktop/Code/Java/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.manage().window().setPosition(new Point(-1440, 0));
        driver.manage().window().setSize(new Dimension(1440, 840));


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void backTest() throws Exception {
        Thread.sleep(3000);
        By searchBar = By.id("lst-ib");
        driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys("the Nerdery");
        By link = By.xpath("//a[contains(text(),'The Nerdery')]");
        driver.findElement(link).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[2]/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[476]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Last Nerd')]")).click();
        for (int i = 1; i < 476; i++) {
            try {
                Thread.sleep(1000);
                driver.findElement(By.xpath("//a[contains(text(),'Last Nerd')]")).click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




}

