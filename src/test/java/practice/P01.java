package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class P01 {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @AfterClass
    public static void teardown() {
        driver.close();
    }

    @Test
    public void test01() {

        // 1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement dropDownElement = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropDownElement);
        select.selectByIndex(1);

        // 2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        // 4.Tüm dropdown değerleri(value) yazdırın

        List<WebElement> options = select.getOptions();

        for (WebElement eachElement : options
        ) {
            System.out.println(eachElement.getText());
        }

        // 5. Dropdown’un boyutunun 4 olduğunu test edin

        int expectedSize = 3;
        int actualSize = options.size();

        Assert.assertEquals(expectedSize, actualSize);

    }
}
