package day10_actionsClass_Faker_FileTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class C08_Waits {

    @Test
    public void test01(){

        // implicitly wait'in rolunu gorebilmek icin
        // baslangic ayarlarini bu test method'unda yapalim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

       // 3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

       // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();

       // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGone = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));

        Assert.assertTrue(itsGone.isDisplayed());

        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[@autocomplete='off'][1]")).click();

        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));

        Assert.assertTrue(itsBack.isDisplayed());

        driver.close();
    }
}
