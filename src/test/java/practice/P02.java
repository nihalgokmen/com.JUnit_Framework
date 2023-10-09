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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class P02 {

    WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(2000);
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void test(){

        //tum kategorileri secin ve bakim-kozmetik option tiklayin
        WebElement kategoriler = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(kategoriler);
        select.selectByVisibleText("Kişisel Bakım ve Kozmetik");

        // Searcbox'a ruj yazin
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("ruj" + Keys.ENTER);

        // Maybelline New York secin
        driver.findElement(By.xpath("(//i[@class='a-icon a-icon-checkbox'])[1]")).click();

        // Cikan sonuc sayisinin 76 oldugunu test edin
        int expected = 20000;
        WebElement sonucSize = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String actual = sonucSize.getText();

        String[] sonucYaziKelimeleriArr = actual.split(" ");
        String sonucSayiAdediStr=sonucYaziKelimeleriArr[0];
        sonucSayiAdediStr = sonucSayiAdediStr.replaceAll("\\D","");
        int sonucSayisiInt= Integer.parseInt(sonucSayiAdediStr);

        Assert.assertEquals(expected,sonucSayisiInt);
    }
}
