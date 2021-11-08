package internetkitapokuwebseite.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReports1 {

    public ExtentReports extentReports;// um Report zu beginnen, braucht man.
    public ExtentHtmlReporter extentHtmlReporter;// um Report zu konfigurieren, braucht man
    public ExtentTest extentTest;// um Testschritte zu definieren und um Anmerkungen hinzufügen, braucht man
    @BeforeTest
    public void setup(){                      // klasor report, dosya adi:extentreport.html
    extentHtmlReporter = new ExtentHtmlReporter("./reports/extentreport.html");
    }
    @Test
    public void buecher(){

    }
}
