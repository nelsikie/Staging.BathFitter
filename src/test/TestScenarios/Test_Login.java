package TestScenarios;

// Custom files
import Config.Config;
import POM.Login_POM;

import org.testng.annotations.Test;

public class Test_Login extends Config {

    @Test(priority=0)
    public void test_Login() throws InterruptedException {
        // Create login page object
        objLogin = new Login_POM(driver);
        // Login
        objLogin.loginToCRM("bmmtl\\069ac", "BF!CRM90");

    }
}
