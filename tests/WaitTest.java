package internetkitapokuwebseite.tests;

import internetkitapokuwebseite.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest extends TestBase {
    @Test(groups = "grouptest1")
    public void implicitWait(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@autocomplete='off']"));
        removeButton.click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Eger mesaji almasi uzun sürerse fail oluyor
                                                                          //  Buraya implicitly wait konularak pass alinir
                                                                          // TestBase Class'ta oldugunda burada wait gerekmez
        WebElement textItGone = driver.findElement(By.id("message"));
        String actualText = textItGone.getText();
        String expectedText = "It's gone!";
        Assert.assertEquals(actualText,expectedText);
    }
    @Test(groups = "grouptest1")
    public void explicitWait(){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = driver.findElement(By.xpath("//button[@autocomplete='off']"));
        removeButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        WebElement textItGone = driver.findElement(By.id("message"));
        String actualText = textItGone.getText();
        String expectedText = "It's gone!";
        Assert.assertEquals(actualText,expectedText);
    }
}
