package internetkitapokuwebseite.tests;

import internetkitapokuwebseite.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HandlingAlerts extends TestBase {

    @Test
    public void acceptAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // Klick erste Button und danach Ok Button. Verifizier die Resultnachricht, ob sie angezeigt ist.
        WebElement ersteButton = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        ersteButton.click();
        System.out.println("Alert Nachricht: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        System.out.println("Result Nachricht: "+driver.findElement(By.id("result")));
        Assert.assertTrue(driver.findElement(By.id("result")).isDisplayed());


    }
    @Test
    public void dissmissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // Klick zweite Button und danach Ok Button. Verifizier die Resultnachricht, ob sie angezeigt ist.
        WebElement zweiteButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        zweiteButton.click();
        System.out.println("Alert Nachricht: "+driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        System.out.println("Result Nachricht: "+driver.findElement(By.xpath("//p[@style='color:green']")));
        Assert.assertTrue(driver.findElement(By.xpath("//p[@style='color:green']")).isDisplayed());

    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        // Klick dritte Button und tragt "Ibrahim" in die TextBox ein.
        WebElement dritteButton = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        dritteButton.click();
        driver.switchTo().alert().sendKeys("Ibrahim");
        driver.switchTo().alert().accept();
        //Danach verifizier die Resultnachricht, ob sie "You entered: Ibrahim" ist.
        WebElement resultNachrricht = driver.findElement(By.id("result"));
        System.out.println("Result Nachricht: "+resultNachrricht);
        String actualResult = resultNachrricht.getText();
        String expectedResult = "You entered: Ibrahim";

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualResult,expectedResult);
        softAssert.assertAll();
    }

}
