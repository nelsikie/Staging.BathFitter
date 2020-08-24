package TestScenarios;

import Config.Config;
import POM.Appointment_POM;
import POM.DashBoard_POM;
import POM.LeadOpportunity_POM;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_NewLeadOpp extends Config {

    // Can this be called in the config for all other tests?
    @BeforeTest
    public void initiate() {
        objDashBoard = new DashBoard_POM(driver);
        objLeadOpportunity = new LeadOpportunity_POM(driver);
        objAppointment = new Appointment_POM(driver);

    }

    //go to Next page
    @Test(priority = 1)
    public void goToLeadOpp() {
        objDashBoard.newLeadOpp();
    }

    //Create new LeadOpp
    @Test(priority = 2)
    public void createNewLeadOpp() throws InterruptedException {


        objLeadOpportunity.switchContentFrame1();       // This should be called in the POM. Other people will not know which one to call

        // BATHROOM INFORMATION
        objLeadOpportunity.enterBathroomInformation("2000", "1");

        // ADDRESS INFORMATION
        objLeadOpportunity.setServiceAddress("Automation Address ", "Automation Unit ", "Automation City ", "NH", "03032"); //Branch 193

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

    @Test(priority = 3)
    public void createNewSalesAppointment() throws InterruptedException {
        objLeadOpportunity.createSalesActivity();
        objAppointment.selectwindow(1);  // Select sales appointment window
        objLeadOpportunity.switchContentFrame0();
        objAppointment.selectResource();
        objAppointment.selectAppointmentConfirmed();
        objAppointment.selectVirtualConsultation();
        objAppointment.setAppointmentDuration("1 minute");
        driver.switchTo().defaultContent();
        objAppointment.saveAndClose();
        //objAppointment.selectwindow(0);
    }

//    @Test(priority = 4)
//    public void openSalesAppointment() throws InterruptedException {
//        objLeadOpportunity.openNewScheduledSalesConsultation();
//    }
}