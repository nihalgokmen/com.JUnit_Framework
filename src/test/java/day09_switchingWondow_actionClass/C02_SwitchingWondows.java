package day09_switchingWondow_actionClass;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwitchingWondows extends TestBase{

    /*
        driver.switchTo().newWindow() kullanara actigimiz
        window'a driver otomatik olarak gecer

        ANCAK...
        biz newWindow() methodunu kullanmadan
        bir link tikladigimizda yeni window aciliyorsa
         driver eski window'da kalir
        Yeni window'a driver'i gecirebilmek icin
        yeni w'ndow'un WindowHandleDegerine ihtiyacimiz vardir.
     */

    @Test
    public void test01(){
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String expectedText = "Opening a new window";
        String  actualText = driver.findElement(By.tagName("h3")).getText();

        Assert.assertEquals(expectedText,actualText);

        String ilkWindowWHD = driver.getWindowHandle();

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        // 43. satir itibariyle yeni window acildi
        // artik 2 window var

        Set<String> whDegerlerSeti = driver.getWindowHandles();

        String ikinciWindowWHD = "";
        for (String eacWHD: whDegerlerSeti
             ) {
            if (!eacWHD.equals(ilkWindowWHD)){
                ikinciWindowWHD = eacWHD;
            }
        }
        // artik 2. window'un windowHandleDegerine sahibiz

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        driver.switchTo().window(ikinciWindowWHD);
        expectedTitle = "New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newWindowText = driver.findElement(By.tagName("h3"));
        expectedText = "New Window";
        actualText = newWindowText.getText();

        Assert.assertEquals(expectedText,actualText);

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkWindowWHD);

        expectedTitle = "The Internet";
        actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

    }

}
