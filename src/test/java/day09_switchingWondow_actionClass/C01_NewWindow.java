package day09_switchingWondow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_NewWindow extends TestBase {

    /*
        Eger driver.switchTo().newWindow kullanilirsa
        driver otomatik olarak acilan yeni sayfaya gecer

        Eger gorevimizde yeni window'a girikten sonra
        windowlar arasi gecis islemi varsa
        uzerinde calistigimiz window'larin
        windiwHandle degerlerini alip kaydetmekte fayda var
     */


    @Test
    public void test01(){
        // Gerekli ayarlamalari yapip
        // amazon ana sayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaWHD = driver.getWindowHandle();

        // title'in amazon kelimsei icerdigini test edin
        String expected = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expected));

        // yeni bir tab acarak wisequarter ana sayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String ikinciSayfaWHD = driver.getWindowHandle();

        // ve url'in wisequarter icerdigini test edin
        expected = "wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expected));

        // tekrar amazon'un acik oldugu sayfaya gecin
        // ve url'in amazon icerdigini test edin

        driver.switchTo().window(ilkSayfaWHD);

        expected = "amazon";
        actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expected));

    }

}
