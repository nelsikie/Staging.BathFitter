package POM;

import Config.Generators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ServiceCall_POM {

    // Test Branch 193, Postal code 03032, State NH, New Hampsire

    Generators generators = new Generators();
    WebDriver driver;
    String contentFrame0 = "contentIFrame0";
    String contentFrame1 = "contentIFrame1";

    // Status section
    By status = By.id("Status_label");
    By subStatus = By.id("SubStatus_label");
    By branch = By.id("header_bfr_branch_lookupValue");
    By callDate = By.id("header_bfr_calldate");

    // Get to Create new contact section
    By magnifyingGlass = By.id("bfr_contactid_i");
    By newCContact = By.linkText("New");

    // Create contact section. Is this not the same?
    By salutation = By.id("bfr_salutation");
    By fullName = By.id("fullname");
    By firstName = By.id("fullname_compositionLinkControl_firstname_i");
    By lastName = By.id("fullname_compositionLinkControl_lastname_i");
    By preferredLanguage = By.id("bfr_preferredlanguage");
    By emailAddress = By.id("emailaddress1");
    By emailAddressField = By.id("emailaddress1_i");
    By telephoneHome = By.id("telephone2");
    By telephoneHomeField = By.id("telephone2_i");
    By telephoneBusiness = By.id("telephone1");
    By telephoneBusinessField = By.id("telephone1_i");
    By telephoneMobile = By.id("mobilephone");
    By telephoneMobileField = By.id("mobilephone_i");
    By personalNotes = By.id("description");
    By personalNotesField = By.id("description_i");
    By saveContact = By.cssSelector(".ms-crm-CommandBarItem.ms-crm-CommandBar-Menu.ms-crm-CommandBar-Button");

    // SERVICE ADDRESS. NOTE THESE ARE THE SAME IN LEAD OPP SHOULD THEY BE PUT IN A GENERIC FILE
    By address = By.id("bfr_address");
    By addressField = By.id("bfr_address_i");
    By unit = By.id("bfr_unit");
    By unitField = By.id("bfr_unit_i");
    By city = By.id("bfr_city");
    By cityField = By.id("bfr_city_i");
    By stateProvince = By.id("bfr_stateprovinceid");
    By stateProvinceField = By.id("bfr_stateprovinceid_ledit");
    By country = By.id("bfr_country");
    By countryField = By.id("id=bfr_country_i");
    By zipPostalCode = By.id("bfr_zippostalcode");
    By zipPostalCodeField = By.id("bfr_zippostalcode_i");

    // Original Installed EOI section
    By eOIComments = By.id("bfr_eoicomments");
    By eOICommentsField = By.id("bfr_eoicomments_i");

    // Service call notes
    By serviceCallNotes = By.id("description");
    By serviceCallNotesField = By.id("description_i");

    // Customer notes
    By customerNotes = By.id("bfr_customernotes");
    By customerNotesField = By.id("bfr_customernotes_i");

    // Service Call Details [Bottom of Page]
    By callTakenBy = By.id("bfr_calltakenby");

    // Service Call Details
    By addServiceCallDetail = By.id("DetailsList_addImageButtonImage");

    By productMagnifyingglass = By.id("bfr_product");
    By Product = By.id("bfr_product_i");        // This is EXACT products from bathfitter product list
    By repairProduct = By.id("bfr_repairproduct");
    By repairProductField = By.id("bfr_repairproduct_i");   // Already selected when the window is opened [Select Menu]

    By atFault = By.id("bfr_atfault");
    By atFaultField = By.id("bfr_atfault_i");
    By outCome = By.id("bfr_outcome");
    By outComeField = By.id("bfr_outcome_i");
    By nature = By.id("bfr_nature");
    By natureField = By.id("bfr_nature_i");     // [Select Menu]

    By responsible = By.id("bfr_responsible");
    By responsibleField = By.id("bfr_responsible_ledit");

    By underWarrantyCheckBox = By.id("bfr_underwarranty_i");        // If activated it adds field "Warranty Reason" field
    By warrantyReason = By.id("bfr_warrantyreason");
    By warrantyReasonField = By.id("bfr_warrantyreason_i");

    By saveAndCloseButton = By.id(".ms-crm-CommandBarItem.ms-crm-CommandBar-Menu.ms-crm-CommandBar-Button");



    public ServiceCall_POM(WebDriver driver) {
        this.driver = driver;
    }

    public void switchContentFrame0() {
        driver.switchTo().frame(contentFrame0);
    }

    // Needs to be in generic call file. Plus can make it an int input
    public void switchContentFrame1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(contentFrame1);
    }

    public void validateSCStatusAndSubStatus(/*String SCStatus, String SCSubStatus*/) {
        Assert.assertEquals("New", driver.findElement(status).getText());
        Assert.assertEquals("New", driver.findElement(subStatus).getText());
        Assert.assertEquals("--", driver.findElement(branch).getText());
        Assert.assertEquals(generators.getTodaysDate(), driver.findElement(callDate).getText());
    }

    public void setServiceAddress(String strAddress, String strUnit, String strCity, String strStateProvince, String strZipPostalCode) throws InterruptedException {
        System.out.println("Should not need to switch to content frame ?");
        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());          // WINDOW SELECTION NEEDS TO BE IN A GENERIC SPOT
        Thread.sleep(5000);
        driver.switchTo().window(window.get(0));
        switchContentFrame1();
        driver.findElement(address).click();
        driver.findElement(addressField).sendKeys(strAddress + generators.getTimeStamp());
        driver.findElement(unit).click();
        driver.findElement(unitField).sendKeys(strUnit + generators.getTimeStamp());
        driver.findElement(city).click();
        driver.findElement(cityField).sendKeys(strCity + generators.getTimeStamp());
        driver.findElement(stateProvince).click();
        driver.findElement(stateProvinceField).sendKeys(strStateProvince);
        driver.findElement(stateProvinceField).sendKeys(Keys.TAB);
        driver.findElement(country).sendKeys(Keys.TAB);
        driver.findElement(zipPostalCode).click();
        driver.findElement(zipPostalCodeField).sendKeys(strZipPostalCode);
    }

    public void setEOIComments() {
        driver.findElement(eOIComments).click();
        driver.findElement(eOICommentsField).sendKeys("Service Call EOI comments " + generators.getTimeStamp());
    }

    public void goToCreateNewContact() {
        driver.findElement(magnifyingGlass).click();
        driver.findElement(newCContact).click();
    }

    public void createNewContact() throws InterruptedException {
        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());          // WINDOW SELECTION NEEDS TO BE IN A GENERIC SPOT
        //Thread.sleep(5000); // Why is this here? Should be before?
        driver.switchTo().window(window.get(1));
        switchContentFrame0();
        driver.findElement(salutation).click();
        new Select(driver.findElement(By.id("bfr_salutation_i"))).selectByVisibleText(generators.salutation());
        driver.findElement(fullName).click();
        driver.findElement(firstName).click();
        driver.findElement(firstName).sendKeys(generators.firstNameGenerator() + " " + generators.timeStampShort());
        driver.findElement(firstName).sendKeys(Keys.TAB);
        //driver.findElement(lastName).click();
        driver.findElement(lastName).sendKeys(generators.firstNameGenerator() + " " + generators.timeStampShort());
        driver.findElement(lastName).sendKeys(Keys.TAB);
        List<WebElement> nameDoneButton = driver.findElements(By.cssSelector(".ui-button.ui-widget.ui-state-default.ui-corner-all.ui-button-text-only"));
        nameDoneButton.get(0).click();
        driver.findElement(preferredLanguage).click();
        new Select(driver.findElement(By.id("bfr_preferredlanguage_i"))).selectByVisibleText(generators.language());
        driver.findElement(emailAddress).click();
        driver.findElement(emailAddressField).sendKeys("BF_" + generators.getTimeStamp() + "@automation.com");
        driver.findElement(telephoneHome).click();
        driver.findElement(telephoneHomeField).sendKeys(generators.phoneNR());
        driver.findElement(telephoneBusiness).click();
        driver.findElement(telephoneBusinessField).sendKeys(generators.phoneNR());
        driver.findElement(telephoneMobile).click();
        driver.findElement(telephoneMobileField).sendKeys(generators.phoneNR());
        driver.findElement(personalNotes).click();
        driver.findElement(personalNotesField).sendKeys("Personal Notes Field" + generators.getTimeStamp());
    }

    public void saveContact(int button) {
        driver.switchTo().defaultContent();
        List<WebElement> topMenuBar = driver.findElements(saveContact);
        topMenuBar.get(button).click();
    }

    public void enterServiceCallNotes() {
        driver.findElement(serviceCallNotes).click();
        driver.findElement(serviceCallNotesField).sendKeys("EOI Comments field" + generators.getTimeStamp());
    }

    public void enterCustomersNotes() {
        driver.findElement(customerNotes).click();
        driver.findElement(customerNotesField).sendKeys("Customer Notes field" + generators.getTimeStamp());
    }

    public void createNewServiceCallDetails() throws InterruptedException {
        switchContentFrame0();
        Thread.sleep(7000);
        driver.findElement(addServiceCallDetail).click();
    }
    public void enterServiceCallDetails() throws InterruptedException {
        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());          // WINDOW SELECTION NEEDS TO BE IN A GENERIC SPOT
        driver.switchTo().window(window.get(1));
        switchContentFrame0();
        new Select(driver.findElement(repairProductField)).selectByVisibleText(generators.repairProduct());
        Thread.sleep(3000);
        driver.findElement(nature).click();
        new Select(driver.findElement(natureField)).selectByVisibleText(generators.nature());
        driver.findElement(atFault).click();
        new Select(driver.findElement(atFaultField)).selectByVisibleText(generators.atFault());
        driver.findElement(responsible).click();
        driver.findElement(responsibleField).sendKeys("193 AC");
        driver.findElement(responsibleField).sendKeys(Keys.TAB);
        //new Select(driver.findElement(responsibleField)).selectByVisibleText(generators.responsible());
        Thread.sleep(3000);
//        driver.findElement(outCome).click();
        new Select(driver.findElement(outComeField)).selectByVisibleText(generators.outCome());

        driver.switchTo().defaultContent();
        List<WebElement> topMenuBar = driver.findElements((saveAndCloseButton));
        topMenuBar.get(1).click();
        // Element not interactable
//        driver.findElement(underWarrantyCheckBox).click();
//        driver.findElement(warrantyReason).click();
//        new Select(driver.findElement(warrantyReasonField)).selectByVisibleText(generators.warrantyReason());
    }
}
