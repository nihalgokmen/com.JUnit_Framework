package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_IFrame extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        //    - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iframeYazisi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());

        //    - Text Box’a “Merhaba Dunya!” yazin.
        WebElement frame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(frame);

        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        Thread.sleep(1000);

        //    - TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.

        /*
            iframe'e gecis yapilinca driver'i oradan
            cikis yaptirana kadar driver iframe'in
            icinde kalir!!!!

            driver.switchTo().parentFrame() : ic ice birden fazla Iframe varsa bir uste cikar
            driver.switchTo().defaultContent() : direkt ana sayfaya cikar
         */

        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());

    }
}
