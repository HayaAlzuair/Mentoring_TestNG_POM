package tasks;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBase;

public class T04_ComprehensiveNegativeTesting extends TestBase {


/*

Task 4: Comprehensive Negative Testing
Go to https://claruswaysda.github.io/signln.html
Do negative test with all scenarios

Requirements:
Create a FluentSignInPage class
Implement all negative test scenarios:
Empty username/password
Invalid username formats
Weak passwords
Cross-site scripting attempts
Chain validation operations for each negative scenario
Use soft assertions to collect all validation errors
Create comprehensive error reporting within fluent chains

*/

    @Test(dataProvider = "negativeLoginData")
    public void negativeTest(String username, String password) {

        LoginPage loginPage = new LoginPage();

        Driver.getDriver().get(ConfigReader.getProperty("CN_url"));
        loginPage.login(username, password);

        String errorMessage = loginPage.getErrorMessage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(errorMessage.contains("invalid"));
        softAssert.assertAll();

        Driver.closeDriver();
    }


    @DataProvider
    public Object[][] negativeLoginData() {
        return new Object[][]{
                // username and password incorrect
                {ConfigReader.getProperty("invalidUsername"), ConfigReader.getProperty("invalidPassword")},
                // Correct username, incorrect password
                {ConfigReader.getProperty("username"), ConfigReader.getProperty("invalidPassword")},
                // Incorrect username, correct password
                {ConfigReader.getProperty("invalidUsername"), ConfigReader.getProperty("password")},
                // Empty username, correct password
                {"", ConfigReader.getProperty("password")},
                // Correct username, empty password
                {ConfigReader.getProperty("username"), ""},
                // Both username and password empty
                {"",""},
                // invalid username format, valid password
                {ConfigReader.getProperty("invalidFormatUsername"), ConfigReader.getProperty("password")},
                // XSS attack in username, valid password
                {ConfigReader.getProperty("xssUsername"), ConfigReader.getProperty("password")},
                // Weak password, valid username
                {ConfigReader.getProperty("username"), ConfigReader.getProperty("weakPassword")},
        };
    }

}
