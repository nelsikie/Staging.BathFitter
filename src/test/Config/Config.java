package Config;

import POM.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Config {

    public static WebDriver driver;
    public LeadOpportunity_POM objLeadOpportunity;
    public DashBoard_POM objDashBoard;
    public Login_POM objLogin;
    public Appointment_POM objAppointment;
    public ServiceCall_POM objServiceCall;

    @BeforeSuite
    public void Setup() {
        WebDriverManager.chromedriver().setup();

        //Create a map to store  preferences
        Map<String, Object> prefs = new HashMap<String, Object>();

        //add key and value to map as follow to switch off browser notification
        //Pass the argument 1 to allow and 2 to block
        prefs.put("profile.default_content_setting_values.notifications", 2);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");

        // set ExperimentalOption - prefs
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://crmqa.bathfitter.com/");
    }

//    @AfterSuite
//    public void close() {
//        driver.quit();
//    }
//
//    public WebDriver getDriver() {
//        return driver;
//    }
//
//    public void setDriver(WebDriver driver) {
//        this.driver = driver;
//    }
}
