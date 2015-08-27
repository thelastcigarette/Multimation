package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by jmcfarla on 8/26/15.
 */
public class IETest{
    WebDriver driver = null;




    @BeforeTest(alwaysRun = true)
        public void setUp() throws MalformedURLException{
            File file = new File("C:\\Users\\Jim McFarlane\\Desktop\\Selenium\\IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.google.com");


        }

        @AfterTest
        public void tearDown() {
            driver.quit();
        }


        @Test(description = "nerd test thinger")
        public void qaTest() throws Exception {
            By searchBar = By.id("lst-ib");
            driver.findElement(searchBar).click();
            driver.findElement(searchBar).sendKeys("the Nerdery");
            By link = By.xpath("//a[contains(text(),'The Nerdery')]");
            driver.findElement(link).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[2]/a/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@id='filter']/a/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(text(),'Next Nerd')]")).click();
            for (int i = 1; i < 211; i++) {
                try {
                    Thread.sleep(1000);
                    driver.findElement(By.xpath("//a[contains(text(),'Next Nerd')]")).click();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
}
