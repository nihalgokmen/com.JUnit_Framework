package day07_JUnit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class C03_RadioButton {

    // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void radioButton(){
        // a. Verilen web sayfasına gidin.
        //     https://facebook.com
        driver.get("https://facebook.com");

        // b. Cookies’i kabul edin
        // cookie cikmadi

        // c. Create an account buton’una basin
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();

        // d. Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        WebElement maleRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement customRadioButton = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        femaleRadioButton.click();

        // e. Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(femaleRadioButton.isSelected());
        Assert.assertFalse(maleRadioButton.isSelected());
        Assert.assertFalse(customRadioButton.isSelected());
    }
}
