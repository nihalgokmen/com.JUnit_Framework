package day08_testBase_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.beans.Transient;

public class C01_TestBaseFirstClass extends TestBase {

    @Test
    public void test01(){
        // amazona gidelim
        driver.get("https://www.amazon.com");

        // Nutella icin arama yapalim
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin "Nutella" icerdigini test edelim
        String expected = "Nutella";
        String actual = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]")).getText();

        Assert.assertTrue(actual.contains(expected));
    }
}
