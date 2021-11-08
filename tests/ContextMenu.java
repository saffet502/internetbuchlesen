package internetkitapokuwebseite.tests;

import internetkitapokuwebseite.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContextMenu extends TestBase {
    @Test
    public void menu(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement quadrat = driver.findElement(By.id("hot-spot"));
        actions.contextClick(quadrat).perform();

        String actualText = driver.switchTo().alert().getText();
        String expectedText = "You selected a context menu";
        Assert.assertEquals(actualText, expectedText);
        driver.switchTo().alert().accept();




    }
}
