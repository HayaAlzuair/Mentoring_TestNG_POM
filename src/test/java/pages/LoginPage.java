package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class LoginPage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By submitButton = By.id("submit");
    private By errorMessage = By.id("error");


    public LoginPage getUsername(String username) {
        Driver.getDriver().findElement(this.username).sendKeys(username);
        return this;
    }

    public LoginPage getPassword(String password) {
        Driver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public LoginPage getSubmitButton() {
        Driver.getDriver().findElement(this.submitButton).click();
        return this;
    }

    public void login(String username, String password) {
        getUsername(username);
        getPassword(password);
        getSubmitButton();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return error.getText();
    }
}
