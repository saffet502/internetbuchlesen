package internetkitapokuwebseite.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IframeTest {
    WebDriver driver;
    @BeforeClass
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    public void iframeTest(){
        // Screib "An IFrame containing" Text in Console
        WebElement text = driver.findElement(By.xpath("//h3"));
        System.out.println("Text: "+text.getText().substring(0, 20));

        //driver.switchTo().frame(0);// index kullanilarak iframe'e gidildi
        driver.switchTo().frame("mce_0_ifr"); // value kullanilarak iframe'e gidildi
        WebElement textBox = driver.findElement(By.xpath("//p"));

        textBox.clear();
        textBox.sendKeys("Hallo Welt");

        driver.switchTo().parentFrame();// Burada defaultContent() kullanilabilirdi. Ancak bu method en üst Frame'e cikarir.
        WebElement seleniumText = driver.findElement(By.linkText("Elemental Selenium"));
        System.out.println("Selenium Text: "+seleniumText.getText());

    }
}
