package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class ActionsClickDragPage {

    private WebDriver driver = Driver.getDriver();
    private Actions actions = new Actions(driver);
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    private By clickBtn = By.id("click");
    private By dblClickBtn = By.id("doubleClick");
    private By rightClickBtn = By.id("rightClick");
    private By dragElement = By.id("drag");
    private By dropElement = By.id("drop");

    private By clickResult = By.id("clickResult");
    private By dblClickResult = By.id("doubleClickResult");
    private By rightClickResult = By.id("rightClickResult");
    private By dragDropResult = By.id("dragDropResult");

    public ActionsClickDragPage clickButton() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(clickBtn));
        el.click();
        return this;
    }

    public ActionsClickDragPage doubleClickButton() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(dblClickBtn));
        actions.doubleClick(el).perform();
        return this;
    }

    public ActionsClickDragPage rightClickButton() {
        WebElement el = wait.until(ExpectedConditions.elementToBeClickable(rightClickBtn));
        actions.contextClick(el).perform();
        return this;
    }

    public ActionsClickDragPage dragAndDrop() {
        WebElement source = wait.until(ExpectedConditions.visibilityOfElementLocated(dragElement));
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(dropElement));
        actions.dragAndDrop(source, target).perform();
        return this;
    }

    public String getClickResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(clickResult)).getText();
    }

    public String getDoubleClickResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dblClickResult)).getText();
    }

    public String getRightClickResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickResult)).getText();
    }

    public String getDragDropResult() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dragDropResult)).getText();
    }
}