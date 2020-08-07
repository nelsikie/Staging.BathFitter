package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Appointment_POM {

    WebDriver driver;

    By resource = By.id("bfr_ressource");
    By resourceField = By.id("bfr_ressource_ledit");
    By resourceMagnifyingGlass = By.id("bfr_ressource_i");
    By appointmentConfirmedCheckBox = By.id("bfr_appointmentconfirmed_i");
    By virtualConsultationCheckBox = By.id("bfr_virtualmeeting_i");
    By saveAndCloseButton = By.cssSelector(".ms-crm-CommandBarItem.ms-crm-CommandBar-Menu.ms-crm-CommandBar-Button");
    By duration = By.id("scheduleddurationminutes");
    By durationField = By.id("scheduleddurationminutes_iSelectInput");

    public Appointment_POM(WebDriver driver) {
        this.driver = driver;
    }

    public void selectwindow(int i) throws InterruptedException {
        Thread.sleep(5000);
        ArrayList<String> test = new ArrayList<>(driver.getWindowHandles());
        System.out.println("Test size " + test);
        driver.switchTo().window(test.get(i));
    }

    public void selectResource() {
        driver.findElement(resource).click();
        driver.findElement(resourceField).sendKeys("193 sc1");
        driver.findElement(resourceMagnifyingGlass).click();
        driver.findElement(By.xpath("//li[@id='item0']/a[2]/span/nobr/div/div[3]")).click();
    }

    public void selectAppointmentConfirmed() {
        driver.findElement(appointmentConfirmedCheckBox).click();
    }

    public void selectVirtualConsultation() {
        driver.findElement(virtualConsultationCheckBox).click();
    }

    public void saveAndClose() {
        List<WebElement> topMenuBar = driver.findElements((saveAndCloseButton));
        for (int i = 0; i < topMenuBar.size(); i++) {
            System.out.println("topMenuBar :" + topMenuBar.get(i));
        }
        topMenuBar.get(1).click();
    }

    public void setAppointmentDuration(String time) {
        driver.findElement(duration).click();
        driver.findElement(durationField).sendKeys(Keys.CONTROL, "a");
        driver.findElement(durationField).sendKeys(Keys.BACK_SPACE);
        driver.findElement(durationField).sendKeys(time);
        driver.findElement(durationField).sendKeys(Keys.ENTER);
    }
}
