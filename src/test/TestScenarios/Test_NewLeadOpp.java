package TestScenarios;

import Config.Config;
import Config.DashBoard_POM;
import POM.LeadOpportunity_POM;
import org.testng.annotations.Test;

import java.awt.*;

public class Test_NewLeadOpp extends Config {

    //go to Next page
    @Test(priority = 1)
    public void goToLeadOpp() throws InterruptedException {
        objDashBoard = new DashBoard_POM(driver);
        objDashBoard.newLeadOpp();
    }

    //Create new LeadOpp
    @Test(priority = 2)
    public void createNewLeadOpp() throws InterruptedException, AWTException {
        objLeadOpportunity = new LeadOpportunity_POM(driver);

        objLeadOpportunity.switchContentFrame1();

        // BATHROOM INFORMATION
        objLeadOpportunity.enterBathroomInformation("2000", "1");

        // ADDRESS INFORMATION
        objLeadOpportunity.setServiceAddress("Automation Address ", "Automation Unit ", "Automation City ", "NH", "60148"); //Branch 193

        // INTEREST IN BATH FITTER  NOT WORKING CURRENTLY
        // objLeadOpportunity.randomInterestInBathFitter();

        // MARKETING INFORMATION
        objLeadOpportunity.setMarketingInformation("931-499-2044", "Bow"); //NMF - TV

        // Record Information
        objLeadOpportunity.selectOrigin("Phone");

        // CREATE A NEW CUSTOMER
        objLeadOpportunity.goToCreateContact();
        objLeadOpportunity.enterCustomer(); // All data is automatically generated
        objLeadOpportunity.saveContact();
        objLeadOpportunity.saveLead();
    }
}
