package day09_switchingWondow_actionClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("//*[@id='droppable'][1]"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragMe,dropHere).perform();

        Thread.sleep(2000);

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropped = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        String expected = "Dropped!";
        String actual = dropped.getText();

        Assert.assertEquals(expected,actual);


    }
}
