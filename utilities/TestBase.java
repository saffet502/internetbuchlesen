package internetkitapokuwebseite.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    // Bu Class'in Abstract yapilma sebebi Object olusturmamizdir.
    protected WebDriver driver;
    protected Actions actions;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        actions = new Actions(driver);
    }
/*
    @AfterClass
    public void tearDown(){
        driver.close();
    }

 */
}
