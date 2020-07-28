package Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard_POM {
    WebDriver driver;
    String LeadOppDashboardURL = "https://crmqa.bathfitter.com/main.aspx?area=nav_oppts&etc=3&page=BFR&pageType=EntityList&web=true";
    String serviceCallDashboardURL = "https://crmqa.bathfitter.com/main.aspx?area=nav_cases&etc=112&page=BFI&pageType=EntityList&web=true#876057831";
    By newLeadButton = By.xpath("//a[@onclick='return false']");
    By newServiceCallButton = By.cssSelector(".ms-crm-CommandBar-Button.ms-crm-Menu-Label");

    // Constructor
    public DashBoard_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to "Open Lead-Opps" page
    public void newLeadOpp() throws InterruptedException {
        driver.get(LeadOppDashboardURL);
        driver.findElement(newLeadButton).click();
    }
}
