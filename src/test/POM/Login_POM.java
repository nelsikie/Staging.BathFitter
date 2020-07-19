package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class Login_POM {

    WebDriver driver;

    By userLogin = By.id("userNameInput");
    By userPassword = By.id("passwordInput");
    By loginButton = By.id("submitButton");

    // Constructor
    public Login_POM(WebDriver driver) {
        this.driver = driver;
    }

    // set user name in textbox
    public void setUserName(String strUserName) {
        driver.findElement(userLogin).sendKeys(strUserName);
        driver.findElement(userLogin).sendKeys(Keys.TAB);
    }

    // set password in password text box
    public void setPassword(String strUserName) {
        driver.findElement(userPassword).sendKeys(strUserName);
    }

    // Click on login button
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    /* This POM method will be exposed in test case to login in the applicatoin
     * @param strUserName
     * @param strPasword
     */

    public void loginToCRM(String strUserName, String strPassword) throws InterruptedException {
        // Fill user name
        this.setUserName(strUserName);
        // Fill password
        this.setPassword(strPassword);
        // Click Login button
        this.clickLogin();

    }
}
