package day09_switchingWondow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsClass extends TestBase {

    @Test
    public void test01(){

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin

        Actions actions = new Actions(driver);
        WebElement accountsList = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        actions.moveToElement(accountsList).perform();
        WebElement createList = driver.findElement(By.xpath("//*[text()='Create a List']"));

        //3- “Create a list” butonuna basin
        createList.click();

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        WebElement yourList = driver.findElement(By.xpath("//div[@role='heading']"));

        String expected = "Your Lists";
        String actual = yourList.getText();

        Assert.assertEquals(expected,actual);
    }
}
