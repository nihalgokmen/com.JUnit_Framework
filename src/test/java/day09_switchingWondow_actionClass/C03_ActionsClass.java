package day09_switchingWondow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.time.LocalTime;
import java.util.Set;

public class C03_ActionsClass extends TestBase {

    @Test
    public void test01(){

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);
        actions.contextClick(ciziliAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualText = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedText,actualText);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        // linke tikladigimida yeni window acildigindan
        // tiklamadan once ilk window'un WHD almamiz gerekir
        String ilkWHD = driver.getWindowHandle();
        driver.findElement(By.linkText("Elemental Selenium")).click();

        // ikinci sayfa biz new window demeden acildigindan
        // ikinciWindow'un WHD degerini Java kullanrak bulmaliyiz

        String ikinciWHD = "";
        Set<String> windowHDSeti =  driver.getWindowHandles(); // icinde iki tane WHD var
        // ilkWHD'e esit olmayani ikinciWHD'ye atayalim

        for (String eachWHD: windowHDSeti
             ) {
            if (!eachWHD.equals(ilkWHD)){
                ikinciWHD = eachWHD;
            }
        }
        driver.switchTo().window(ikinciWHD);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        expectedText = "Elemental Selenium";
        WebElement textElement = driver.findElement(By.tagName("h1"));
        actualText = textElement.getText();

        Assert.assertEquals(expectedText,actualText);

    }
}
