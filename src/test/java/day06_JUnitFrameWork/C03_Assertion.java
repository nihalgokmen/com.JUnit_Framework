package day06_JUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertion {

    /*
        Bir assertion failed olursa
        Assertion'in oldugu satirda exception olusur
        ve assertion satirindan sonraki kodlar CALISMAZ.
     */

    WebDriver driver;

    @Test
    public void googleTestMethodu() {
        // 1- Google ana sayfaya gidip url'in google icerdigini test edin.
        System.out.println("google test");

        mahserin4Atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik = "google1";
        String actualIcerik = driver.getCurrentUrl();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        driver.close();
    }

    @Test
    public void wiseTestMethodu(){
        // 2- WiseQuarter ana sayfaya gidip url'in wisequarte icerdigini test edin.
        System.out.println("wise test");

        mahserin4Atlisi();
        driver.get("https://www.wisequarter.com");
        String expectedIcerik = "wisequarter1";
        String actualIcerik = driver.getCurrentUrl();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
        driver.close();

    }

    @Test
    public void amazonTestMethodu(){
        // 3- Amazon ana sayfaya gidip amazon logosunun gorundugunu test edin.
        System.out.println("amazon test");

        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));

        Assert.assertTrue(amazonLogoElementi.isDisplayed());
        driver.close();

    }

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
