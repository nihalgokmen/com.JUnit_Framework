package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseBeforeClass;

import java.sql.Driver;

public class C02_JavaScriptAlerts extends TestBaseBeforeClass {

    /*
        Otomasyon yaparken iki tur Alert ile karsilasabiliriz
        1- HTML Alerts:
           HTML kodlari ile olusturulmus aletrs'dir
           HTML ile olusturuldugu icin inspect edilebilir,
           locate edilebilir ve driver ile kullanilabilir.

        2- Java Script Alerts:
           Inspect yapilamaz locate edilemez
           Testler sirasindan JS alert ile karsilasirsak
           driver.switchTo().alert() method'larini kullanrak
           alert'e gecis yapabilir ve alert uzerinde
           OK, CANCEL, Alert yazisini alma (getText())
           Ve alert'e yazi yollama sendKeys()
           method'larini kullanabiliriz.
     */


    //    3 test method’u olusturup asagidaki gorevi tamamlayin

    @Test
    public void test01(){

    // 1. Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    // - 1.alert’e tiklayin
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

    // - Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String actualAlertText = driver.switchTo().alert().getText();
        String expected = "I am a JS Alert";

        Assert.assertEquals(actualAlertText,expected);

    // - OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
    }


    @Test
    public void test02(){

    // 2.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    // - 2.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

    // - Cancel’a basip, cikan sonuc yazisinin “You clicked: Cancel” oldugunu test edin
        driver.switchTo().alert().dismiss();

        String expected = "You clicked: Cancel";
        String actual = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void test03(){

    // 3.Test
    // - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

    // - 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

    // - Cikan prompt ekranina “Nihal” yazdiralim
        driver.switchTo().alert().sendKeys("Nihal");

    // - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();

    // - Cikan sonuc yazisinin Nihal icerdigini test edelim
        String expected = "Nihal";
        String actual = driver.findElement(By.id("result")).getText();

        Assert.assertTrue(actual.contains(expected));
    }



}
