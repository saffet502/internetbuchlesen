package internetkitapokuwebseite.tests;

import internetkitapokuwebseite.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EnableTest extends TestBase {
    @Test
            public void isEnable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Klick den Enable Button
        WebElement enableButton = driver.findElement(By.xpath("//button[@onclick='swapInput()']"));
        enableButton.click();
        //WebElement textCheck = driver.findElement(By.id("message")); wait kullanilacagi icin bu satir iptal edildi
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement enableMesaj = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(enableMesaj.getText(), "It's enabled!");
        WebElement textButton = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(textButton.isEnabled());// isEnabled() etkin olup olmadigini gosterir


    }

}
