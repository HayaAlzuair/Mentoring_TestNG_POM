package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CLHomePage {

    public CLHomePage() {


        CLHomePage homePage = new CLHomePage();
        PageFactory.initElements(Driver.getDriver(), this);
        homePage.signup.click();
    }
    @FindBy(id = "signup")
    public WebElement signup;

}