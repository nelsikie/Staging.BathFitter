package POM;

import Config.Config;
import Config.Generators;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeadOpportunity_POM extends Config {

    // Test Branch 193, Postal code 03032, State NH New Hampsire
    private final String timeStamp = new SimpleDateFormat("yyyy_MMMMM_dd_HH.mm.ss.SSSS").format(new Date()); // Can be standardized in generic or generator class
    public Generators generators;
    WebDriver driver;
    String contentFrame0 = "contentIFrame0";    // Make Generic class
    String contentFrame1 = "contentIFrame1";    // Make Generic class
    // Top Text
    // Pop out button
    By Origin_DD_Selection = By.id("bfr_mainsource_i");
    // BATHROOM INFORMATION
    By yearBuild = By.id("bfr_yearbuilt");
    By yearBuildField = By.id("bfr_yearbuilt_i");
    By noBathrooms = By.id("bfr_nobathrooms");
    By noBathroomsField = By.id("bfr_nobathrooms_i");
    // MARKETING INFORMATION
    By inboundPhone = By.id("bfr_inboundphone");
    By inboundPhoneField = By.id("bfr_inboundphone_i");
    By Source = By.id("campaignid");
    By SourceField = By.id("campaignid_ledit");
    // INTEREST IN BATH FITTER (checkboxes)
    By tubLiner = By.id("bfr_tubliner_i");
    By showerLiner = By.id("bfr_showerliner_i");
    By wall = By.id("bfr_wall_i");
    By ceiling = By.id("bfr_ceiling_i");
    By showerReplacement = By.id("bfr_showerreplacement_i");
    By showerToTubConversion = By.id("bfr_showertotubconversion_i");
    By tubToShowerConversion = By.id("bfr_tubtoshowerconversion_i");
    By tubReplacement = By.id("bfr_tubreplacement_i");
    // SERVICE ADDRESS
    By address = By.id("bfr_address");
    By addressField = By.id("bfr_address_i");
    By unit = By.id("bfr_unit");
    By unitField = By.id("bfr_unit_i");
    By city = By.id("bfr_city");
    By cityField = By.id("bfr_city_i");
    By stateProvince = By.id("bfr_stateprovinceid");
    By stateProvinceField = By.id("bfr_stateprovinceid_ledit");
    By zipPostalCode = By.id("bfr_zippostalcode");
    By zipPostalCodeField = By.id("bfr_zippostalcode_i");
    // New Contact / Contact: BFINSIGHT
    By contactField = By.id("parentcontactid");
    By magnifyingGlassNew = By.id("parentcontactid_i");
    By newContact = By.xpath("//a[@class='ms-crm-InlineLookup-FooterSection-AddAnchor']");
    By salutation = By.id("bfr_salutation");
    By firstName = By.id("fullname");
    By firstNameField = By.id("fullname_compositionLinkControl_firstname_i");
    By lastName = By.id("fullname_compositionLinkControl_lastname");
    By lastNameField = By.id("fullname_compositionLinkControl_lastname_i");
    By FirstLastNameDoneButton = By.xpath("//button[@id='fullname_compositionLinkControl_flyoutLoadingArea-confirm']/div/div/span");
    By language = By.id("bfr_preferredlanguage");   // THIS IS AN OPTION FIELD THIS NEEDS TO BE FIGURED OUT HOW TO SELECT THE LANGUAGE. RANDOMLY
    By telePhone2 = By.id("telephone2");
    By telePhone2Field = By.id("telephone2_i");
    By telePhone1 = By.id("telephone1");
    By telePhone1Field = By.id("telephone1_i");
    By personalNotes = By.id("description");
    By personalNotesField = By.id("description_i");
    By mobilePhone = By.id("mobilephone");
    By mobilePhoneField = By.id("mobilephone_i");
    By emailAddress = By.id("emailaddress1");
    By emailAddressField = By.id("emailaddress1_i");
    By customerSaveButton = By.xpath("(//a[@onclick='return false'])[2]");
    // Appointment
    By addActivitiesLeadOpp = By.id("leadoppActivities_addImageButtonImage");
    // RECORD INFORMATION
    By origin = By.id("bfr_mainsource_d");

    // Constructor
    public LeadOpportunity_POM(WebDriver driver) {
        this.driver = driver;
    }

    // RANDOM GENERATOR || This should be done in the GENERATOR file... Figure this one out and remove it
    public String getTimeStamp() {
        return timeStamp;
    }

    // Needs to be in generic call file
    public void switchContentFrame0() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(contentFrame0);
    }

    // Needs to be in generic call file
    public void switchContentFrame1() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(contentFrame1);
    }

    public void selectOrigin(String strOrigin) {
        driver.findElement(origin).click();
        new Select(driver.findElement(Origin_DD_Selection)).selectByVisibleText(strOrigin);
    }

    /*
     * BATHROOM INFORMATION
     */
    public void setBathroomInformation(String strYearBuild, String strNoBathrooms) {
        driver.findElement(yearBuild).click();
        driver.findElement(yearBuildField).sendKeys(strYearBuild);
        driver.findElement(noBathrooms).click();
        driver.findElement(noBathroomsField).sendKeys(strNoBathrooms);
    }

    /*
     * MARKETING INFORMATION
     */
    public void setMarketingInformation(String strInboundPhone, String strCampaign) {
        driver.findElement(inboundPhone).click();
        driver.findElement(inboundPhoneField).sendKeys(strInboundPhone);
        driver.findElement(Source).click();
        driver.findElement(SourceField).sendKeys(strCampaign);
        driver.findElement(SourceField).sendKeys(Keys.TAB);
    }

    /*
     * INTEREST IN BATH FITTER || Does not work yet. Fix it
     */
    public void setInterestInBathFitter(int intRandom) {

        switch (intRandom) {
            case 1:
                driver.findElement(tubLiner).click();
                break;
            case 2:
                driver.findElement(showerLiner).click();
                break;
            case 3:
                driver.findElement(wall).click();
                break;
            case 4:
                driver.findElement(ceiling).click();
                break;
            case 5:
                driver.findElement(showerReplacement).click();
                break;
            case 6:
                driver.findElement(showerToTubConversion).click();
                break;
            case 7:
                driver.findElement(tubToShowerConversion).click();
                break;
            case 8:
                driver.findElement(tubReplacement).click();
                break;
        }
    }

    /*
     * SERVICE ADDRESS
     */
    public void setServiceAddress(String strAddress, String strUnit, String strCity, String strStateProvince, String strZipPostalCode) throws InterruptedException {
        driver.findElement(address).click();
        driver.findElement(addressField).sendKeys(strAddress + getTimeStamp());
        driver.findElement(unit).click();
        driver.findElement(unitField).sendKeys(strUnit + getTimeStamp());
        driver.findElement(city).click();
        driver.findElement(cityField).sendKeys(strCity + getTimeStamp());
        driver.findElement(stateProvince).click();

        driver.findElement(stateProvinceField).sendKeys(strStateProvince);
        driver.findElement(stateProvinceField).sendKeys(Keys.TAB);
        Thread.sleep(2500);
        driver.findElement(zipPostalCode).click();
        driver.findElement(zipPostalCodeField).sendKeys(strZipPostalCode);
    }

    public void goToCreateContact() throws InterruptedException {
        driver.findElement(contactField).click(); //Field is already active
        driver.findElement(magnifyingGlassNew).click();
        Thread.sleep(5000);
        driver.findElement(newContact).click();
        driver.switchTo().defaultContent(); // Select new Lead-Opp iFrame;
    }

    public void setContact() throws InterruptedException {
        generators = new Generators();
        // NEED A RANDOM NAME GENERATOR
        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());          // WINDOW SELECTION NEEDS TO BE IN A GENERIC SPOT
        Thread.sleep(5000);
        driver.switchTo().window(window.get(1));
        System.out.println("Title of the page" + driver.getTitle());
        driver.switchTo().frame(contentFrame0);
        driver.findElement(salutation).click();
        new Select(driver.findElement(By.id("bfr_salutation_i"))).selectByVisibleText(generators.salutation());                // TO STATIC NEEDS TO BE MODULAR
        driver.findElement(language).click();
        new Select(driver.findElement(By.id("bfr_preferredlanguage_i"))).selectByVisibleText(generators.language());                        // TO STATIC NEEDS TO BE MODULAR
        driver.findElement(firstName).click();
        driver.findElement(firstNameField).sendKeys(generators.firstNameGenerator() + " " + generators.timeStampShort());
        driver.findElement(lastName).click();
        driver.findElement(lastNameField).sendKeys(generators.lastNameGenerator() + " " + generators.timeStampShort());
        driver.findElement(FirstLastNameDoneButton).click();
        driver.findElement(telePhone2).click();
        driver.findElement(telePhone2Field).sendKeys(generators.phoneNR());
        driver.findElement(telePhone1).click();
        driver.findElement(telePhone1Field).sendKeys(generators.phoneNR());
        driver.findElement(mobilePhone).click();
        driver.findElement(mobilePhoneField).sendKeys(generators.phoneNR());
        driver.findElement(emailAddress).click();
        driver.findElement(emailAddressField).sendKeys("BF_" + generators.getTimeStamp() + "@automation.com");
        driver.findElement(personalNotes).click();
        driver.findElement(personalNotesField).sendKeys("Personal Notes Field" + generators.getTimeStamp());
    }

    public void saveContact() {
        driver.switchTo().defaultContent();
        driver.findElement(customerSaveButton).click();
    }

    public void saveLead() {
        ArrayList<String> window = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(window.get(0));
        List<WebElement> topMenuBar = driver.findElements(By.cssSelector(".ms-crm-CommandBarItem.ms-crm-CommandBar-Menu.ms-crm-CommandBar-Button"));
        topMenuBar.get(0).click();
    }

    public void createSalesActivity() {
        switchContentFrame1();
        driver.findElement(addActivitiesLeadOpp).click();
    }

    public void enterBathroomInformation(String strYearBuild, String strNoBathrooms) {
        this.setBathroomInformation(strYearBuild, strNoBathrooms);
    }

    public void randomInterestInBathFitter() {
        setInterestInBathFitter(8); // Temp placement
    }

    // This needs to be removed
    public void enterCustomer() throws InterruptedException {
        this.setContact();
    }

    // This needs to be in POM
//    public void openNewScheduledSalesConsultation() throws InterruptedException {
//        driver.get("https://crmqa.bathfitter.com/main.aspx?etc=3&extraqs=&histKey=658095976&id=%7bD006D79B-20D8-EA11-80E2-00155D00CDC6%7d&newWindow=true&pagetype=entityrecord#87807381");
//
//        WebElement CF0 = driver.findElement(By.id("contentIFrame0"));
//        String test = CF0.getAttribute("innerHTML");
//        test.toString();
//        System.out.println(test);
//        switchContentFrame0();
//        Thread.sleep(2000);
//        WebElement salesAppointment = driver.findElement(By.id("gridBodyTable_primaryField_{0D09BCA4-20D8-EA11-80E2-00155D00CDC6}_0"));
//        salesAppointment.click();
//        /*
//            List<WebElement> appointments = driver.findElements(By.cssSelector(".ms-crm-List-Link")); //By.xpath("//*[contains(@id,'gridBodyTable_primaryField_')]")
//            System.out.println("Appointments found: " + appointments.size());
//            appointments.get(0).click();
//        */
//    }
}