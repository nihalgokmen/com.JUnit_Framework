package day13_ExcelOtomasyonu_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumSayfaScreenshot extends TestBase {

    @Test
    public void teste01() throws IOException {
        // amazona gidelim
        driver.get("https://www.amazon.com");

        // Nutella aratalim
        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));

        // Sonuclarin Nutella icerdigini test edelim
        aramaCubugu.sendKeys("Nutella" + Keys.ENTER);

        // Sonuclarin Nutella icerdigini test edelim
        WebElement sonucElementi = driver.findElement(By.xpath("//*[@class='a-color-state a-text-bold']"));

        String actual = sonucElementi.getText();
        String expected = "Nutella";
        Assert.assertTrue(actual.contains(expected));

        // rapora eklenmek uzere, tum sayfanin ekran goruntusunu alalim
        TakesScreenshot tss = (TakesScreenshot) driver;

        File tumSayfaResim = new File("target/ekranResimleri/tumSayfaResim.png");

        File geciciResim = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumSayfaResim);

        ReusableMethods.tumSayfaFotoCek(driver);

    }
}
