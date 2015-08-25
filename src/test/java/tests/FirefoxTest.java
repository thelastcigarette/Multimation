package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by onemantoughcrowd on 8/24/15.
 */
public class FirefoxTest{
    public WebDriver driver;


    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void backTest() throws Exception {



By searchBar = By.id("lst-ib");
driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys("the Nerdery");
        By link = By.xpath("//a[contains(text(),'Nerdery.com - The Nerdery')]");
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
