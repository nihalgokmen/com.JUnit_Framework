package day10_actionsClass_Faker_FileTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_FileUploadTest extends TestBase {

    @Test
    public void test01(){

        /*
            Driver ile gittigimi bir web sayfasinda
            bilgisayarimizdaki bir dosyayi upload etmek istersek

            bilgisayarimizdaki klasorlere erismemiz gerekir
            Selenium webdriver biligisayardaki dosyalara erisemez

            bunun yerine 3 adimla su islemleri yapariz
            1- choose file butonunu locate edelim
            2- biligisayarimizdan yuklemek istedigimiz dosyanin dosya yolunu olusturalim
                (Mumkunse dinamik dosaya yolu olsun)
            3- chooseButonu.sendKeys(dosyaYolu) ile dosya yolunu sisteme tanitalim

         */

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonunu kullanarak
        // projemizdeki deneme.txt dosyasini secelim.
        WebElement chooseFileBuuton = driver.findElement(By.id("file-upload"));

        String herkesteFarkliOlan = System.getProperty("user.dir");
        String herkesteAyniOlan = "/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt";
        String dosyaYolu =herkesteFarkliOlan + herkesteAyniOlan;

        chooseFileBuuton.sendKeys(dosyaYolu);

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement fileUpload = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUpload.isDisplayed());

        // /Users/nihal/IdeaProjects/com.Team113JUnit/src/test/java/day10_actionsClass_Faker_FileTests/deneme.txt

    }
}
