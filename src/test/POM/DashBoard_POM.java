package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashBoard_POM {
    WebDriver driver;
    String LeadOppDashboardURL = "https://crmqa.bathfitter.com/main.aspx?area=nav_oppts&etc=3&page=BFR&pageType=EntityList&web=true";
    String serviceCallDashboardURL = "https://crmqa.bathfitter.com/main.aspx?area=nav_cases&etc=112&page=BFI&pageType=EntityList&web=true#876057831";
    // "https://crmqa.bathfitter.com/main.aspx?etc=112&extraqs=&histKey=297498001&id=%7b93B54B2B-E0E3-EA11-80E2-00155D00CDC6%7d&newWindow=true&pagetype=entityrecord#340652178" Service call appointment
    By newLeadButton = By.xpath("//a[@onclick='return false']");
    By newServiceCallButton = By.cssSelector(".ms-crm-CommandBar-Button.ms-crm-Menu-Label");

    // Constructor
    public DashBoard_POM(WebDriver driver) {
        this.driver = driver;
    }

    // Navigate to "Open Lead-Opps" page
    public void newLeadOpp() {
        driver.get(LeadOppDashboardURL);
        driver.findElement(newLeadButton).click();
    }

    public void newServiceCall() {
        driver.get(serviceCallDashboardURL);
        List<WebElement> topMenuBar = driver.findElements((newServiceCallButton));
        for (int i = 0; i < topMenuBar.size(); i++) {
            System.out.println("topMenuBar :" + topMenuBar.get(i));
        }
        topMenuBar.get(0).click();
    }
}