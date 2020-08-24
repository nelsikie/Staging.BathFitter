package TestScenarios;

import Config.Config;
import Config.Generators;
import POM.DashBoard_POM;
import POM.ServiceCall_POM;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_NewServiceCall extends Config {

    public Generators generators;

    // Can this be called in the config for all other tests?
    @BeforeTest
    public void intiate() {
        objDashBoard = new DashBoard_POM(driver);
        objServiceCall = new ServiceCall_POM(driver);
        generators = new Generators();
    }

    @Test(priority = 1)
    public void goToServiceCall() {
        objDashBoard.newServiceCall();
    }

    @Test(priority = 2)
    public void createNewServiceCall() throws InterruptedException {
        objServiceCall.switchContentFrame1();
        Thread.sleep(3000);
        objServiceCall.validateSCStatusAndSubStatus();
    }

    // This needs to change positions maybe. Keep the priorities
    @Test(priority = 3)
    public void createNewCustomer() throws InterruptedException {
        objServiceCall.goToCreateNewContact();
        objServiceCall.createNewContact();
        objServiceCall.saveContact(1); // Button 1 = Save & Close
    }

    @Test(priority = 4)
    public void enterCustomerAddress() throws InterruptedException {
        objServiceCall.setServiceAddress("Automation Address ", "Automation Unit ", "Automation City ", "NH", "03032"); //Branch 193
    }

    @Test(priority = 5)
    public void setEOICommemnts() {
        objServiceCall.setEOIComments();
    }

    @Test(priority = 6)
    public void setServiceCallNotes() {
        objServiceCall.enterServiceCallNotes();
    }

    @Test(priority = 7)
    public void setCustomerNotes() {
        objServiceCall.enterCustomersNotes();
    }

    @Test(priority = 8)
    public void saveServiceCall() {
        objServiceCall.saveContact(0);
    }

//    @Test(priority = 9)
//    public void newServiceCallDetail() throws InterruptedException {
//        objServiceCall.createNewServiceCallDetails();
//        objServiceCall.enterServiceCallDetails();
//    }
}
