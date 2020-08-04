package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Appointment_POM {

    WebDriver driver;

    String contentFrame0 = "contentIFrame0";
    By resource = By.id("bfr_ressource");
    By resourceField = By.id("bfr_ressource_ledit");
    By resourceMagnifyingGlass = By.id("bfr_ressource_i");

    public Appointment_POM(WebDriver driver) {
        this.driver = driver;
    }

    public void switchContentFrame0() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(contentFrame0);
    }


    public void selectwindow() throws InterruptedException {
        Thread.sleep(5000);
        ArrayList<String> test = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("Test size " + test);
        driver.switchTo().window(test.get(1));
        switchContentFrame0();
    }

    public void selectResource() {
        driver.findElement(resource).click();
        driver.findElement(resourceField).sendKeys("193 sc1");
        driver.findElement(resourceMagnifyingGlass).click();
        driver.findElement(By.xpath("//li[@id='item0']/a[2]/span/nobr/div/div[3]")).click();
    }
}
