package internetkitapokuwebseite.tests;

import internetkitapokuwebseite.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UploadFile extends TestBase {

    @Test
    public void uploadFileMethods(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dateiAuswählen = driver.findElement(By.id("file-upload"));
        String filePath = "C:\\Users\\CC-Student\\Desktop\\bilder\\Bild.png";
        dateiAuswählen.sendKeys(filePath);
        WebElement upload = driver.findElement(By.id("file-submit"));
        upload.click();
        WebElement fileUploaded = driver.findElement(By.xpath("//h3"));
        String actualText = fileUploaded.getText();
        String expectedText = "File Uploaded!";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText, expectedText);
        softAssert.assertAll();


    }

}
