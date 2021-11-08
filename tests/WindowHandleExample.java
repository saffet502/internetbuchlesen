package internetkitapokuwebseite.tests;

import internetkitapokuwebseite.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Set;

public class WindowHandleExample extends TestBase {
    @Test
    public void isDisplayed(){
        driver.get("https://the-internet.herokuapp.com/windows");
        // Verifizier den Text, dass es "Opening a new window" ist.
        String parentWindowHandle = driver.getWindowHandle();
        WebElement text = driver.findElement(By.xpath("//h3"));
        String actualText = text.getText();
        String expectedText = "Opening a new window";
        Assert.assertEquals(actualText,expectedText);
        //softAssert.assertAll(); // En alta bu methodu bir kez yazmak yeterli olacaktir.
        // Verifizier, dass der Titel der Webseite "The Internet" ist.
        //System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";
        SoftAssert softAssert1 = new SoftAssert();
        softAssert1.assertEquals(actualTitle, expectedTitle);
        softAssert1.assertAll();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String childWindowHandel : allWindowHandles) {
            if(!childWindowHandel.equals(parentWindowHandle)){
                driver.switchTo().window(childWindowHandel);
                System.out.println("Child Window Handle: "+childWindowHandel);
            }
        }
        String actualnewWindowTitle = driver.getTitle();
        String expectednewWindowTitle = "New Window";
        Assert.assertEquals(actualTitle, expectedTitle);
        //
        WebElement newWindowText = driver.findElement(By.className("example"));
        String actualText1 = newWindowText.getText();
        String expectedText1 = "New Window";
        Assert.assertEquals(actualText1, expectedText1);
        // Kehr vorherigen webseite zurück und verifizier, dass der Titel der Webseite "The Internet" ist.
        driver.switchTo().window(parentWindowHandle);
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "The Internet";
        Assert.assertEquals(actualText1, expectedText1);

    }

}
