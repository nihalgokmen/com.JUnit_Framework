package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {

    static WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @Test
    public void paraDegeri(){
        // Google'a gider
        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.xpath("//*[@name='q']"));
        // Arama cubuguna karsilastirma yapmak istedigi para birimini girer
        searchBox.sendKeys("USD to TL" + Keys.ENTER);

        // Para birimlerinin karsilastirmasini alin
        WebElement resulElement = driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));
        String result = resulElement.getText().replace(",",".");
        double resaultDouble = Double.parseDouble(result);
        // 25'ten kucuk oldugunu test edin
        Assert.assertTrue(resaultDouble<25);

        if (resaultDouble<25){
            System.out.println("Neyseki hala 25'in altinda");
        }else {
            System.out.println("Gecmis olsuuun");
        }
    }

    @After
    public void tearDown(){
        driver.close();
    }
}
