package day14_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JAvaScriptExecuter extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");

        // asagiya inerek Software Development Engineer in Test - SDET
        // kursunda Explore the Course butonuna tilayin
        WebElement exploreButton = driver.findElement(By.xpath("(//a[@class='elementskit-btn whitespace--normal'])[2]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        // jse ile butona kadar scroll yapalim
        jse.executeScript("arguments[0].scrollIntoView();",exploreButton);

        // jse ile click yapalim
        jse.executeScript("arguments[0].click();",exploreButton);

        // jse ile alert olusturalim
        jse.executeScript("alert('Bu Is Bu Kadar');");

        Thread.sleep(3000);
    }
}
