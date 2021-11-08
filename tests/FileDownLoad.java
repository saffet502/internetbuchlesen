package internetkitapokuwebseite.tests;

import internetkitapokuwebseite.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownLoad extends TestBase {
    @Test
    public void isExist(){
        driver.get("https://the-internet.herokuapp.com/download");
        String vorliegenFile = System.getProperty("user.dir");
        System.out.println(vorliegenFile);
        String benutzerFile = System.getProperty("user.home");
        System.out.println(benutzerFile);
        String filePath = benutzerFile+"\\Desktop\\bilder\\Bild.png";
        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);
    }
    @Test
    public void downloadTest(){
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement flowerFile = driver.findElement(By.linkText("flower.jpeg"));
        flowerFile.click();
        String flowerExistVorliegend = System.getProperty("user.dir");
        System.out.println(flowerExistVorliegend);
        String flowerExistBenuzter = System.getProperty("user.home");
        System.out.println(flowerExistBenuzter);
        String filePath = flowerExistBenuzter+"\\IdeaProjects\\EbayTestNGFramework";
        boolean isFileExist = Files.exists(Paths.get(filePath));
        Assert.assertTrue(isFileExist);

    }
}
