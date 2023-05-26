package day06_JUnitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {

    /*
        bu class icerinde 3 tst calistiralim
        1- Google ana sayfaya gidip url'in google icerdigini test edin.
        2- WiseQuarter ana sayfaya gidip url'in wisequarte icerdigini test edin.
        3- Amazon ana sayfaya gidip amazon logosunun gorundugunu test edin.
     */

    /*
        JUnit'in bize sagladigi ve belkide en onemli ozellik
        test methodlarinin bagimsiz olarak calistirilabilmesini saglayan
        @Test notasyonudur.

        JUnit 'le class level dan birden fazla test methodu calistirirsak
        hangi siralama ile calistiracagini on goremeyiz ve yonetemeyiz.

        Diyeim ki bir test method'u uzerinde calisiyorsunuz
        ve o method'un toplu calistirmalarda kullanilmasini istemiyorsunuz
        @Test notasyonu yanina @Ignore notasyonu kullanilabilir.
     */

    WebDriver driver;

    @Test @Ignore
    public void googleTestMethodu() {
       // 1- Google ana sayfaya gidip url'in google icerdigini test edin.
        System.out.println("google test");

        mahserin4Atlisi();
        driver.get("https://www.google.com");
        String expectedIcerik = "google";
        String actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("google testi passed");
        }else {
            System.out.println("url google icermiyor, google testi failed");
        }
        driver.close();
    }

    @Test
    public void wiseTestMethodu(){
        // 2- WiseQuarter ana sayfaya gidip url'in wisequarte icerdigini test edin.
        System.out.println("wise test");

        mahserin4Atlisi();
        driver.get("https://www.wisequarter.com");
        String expectedIcerik = "wisequarter";
        String actualIcerik = driver.getCurrentUrl();

        if (actualIcerik.contains(expectedIcerik)){
            System.out.println("wise testi passed");
        }else {
            System.out.println("url google wisequarter, wisequarter testi failed");
        }
        driver.close();

    }

    @Test
    public void amazonTestMethodu(){
        // 3- Amazon ana sayfaya gidip amazon logosunun gorundugunu test edin.
        System.out.println("amazon test");

        mahserin4Atlisi();
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));

        if (amazonLogoElementi.isDisplayed()){
            System.out.println("amazon testi passed");
        }else {
            System.out.println("amazon testi failed");
        }
        driver.close();

    }

    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
}
