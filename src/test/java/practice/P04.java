package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P04 extends TestBase {
    // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.

    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");

        // 2 ) Bir metod olusturun: iframeTest
        //    - “An IFrame containing….” textinin erisilebilir
        //    oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframe = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframe.isEnabled());
        System.out.println(anIframe.getText());

        //    - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);

        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");

        //    - TextBox’in altinda bulunan “Elemental Selenium” linkini
        //    textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());
    }


}
