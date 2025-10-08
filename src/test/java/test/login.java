package test;
import base.base;
import pages.login_page;
import org.testng.annotations.Test;
import utils.TestDataReader;
import java.util.Map;
public class login extends base {
    @Test(description = "Verify that user is able to login as IT user")
    public void verifyITUserLogin() {
        // Load test data for 'validITUser'
        Map<String, Object> testData = TestDataReader.getTestData("validITUser");
        String email = (String) testData.get("email");
        String password = (String) testData.get("password");
        String url = (String) testData.get("url");
        // Navigate to the URL
        driver.get(url);
        // Use Page Object Model to perform login
        login_page loginPage = new login_page(driver);
        loginPage.login(email, password);
    }
}