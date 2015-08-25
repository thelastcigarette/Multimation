package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by onemantoughcrowd on 8/24/15.
 */
public class SafariTest {
    public WebDriver driver;


    @BeforeMethod
    public void setUp() throws UnreachableBrowserException{
        //Safari's just really bitchy with it's server
        try {
            driver = new SafariDriver();
        }catch (UnreachableBrowserException uBe){
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.google.com");
        driver.manage().window().setPosition(new Point(2561, 0));
        driver.manage().window().maximize();



    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void qaTest() throws Exception {
        By searchBar = By.id("lst-ib");
        driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys("the Nerdery");
        By link = By.xpath("//a[contains(text(),'Nerdery.com - The Nerdery')]");
        driver.findElement(link).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[2]/a/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='filter']/a[3]/span")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(text(),'Next Nerd')]")).click();
        for (int i = 1; i < 34; i++) {
            try {
                Thread.sleep(1000);
                driver.findElement(By.xpath("//a[contains(text(),'Next Nerd')]")).click();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }




}
