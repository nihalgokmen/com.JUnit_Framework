package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class P05 extends TestBase {

    @Test
    public void test01(){
        ////div[@align='center']//iframe
        //*[@align='center']//iframe

        // 1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        // 2) sayfadaki iframe sayısını bulunuz.

        // 3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        WebElement youTube = driver.findElement(By.xpath("//div[@align='center']//iframe"));
        driver.switchTo().frame(youTube);

        driver.findElement(By.xpath("//*[@id='movie_player']/a/div/div[1]")).click();

        // 4) ilk iframe'den çıkıp ana sayfaya dönünüz
        driver.switchTo().defaultContent();

        // 5) ikinci iframe'deki (Jmeter Made Easy) linke

        // (https://www.guru99.com/live-selenium-project.html) tıklayınız



    }

}
