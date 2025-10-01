
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ActionsClickDragPage;
import pages.ActionsFormPage;
import pages.AddRecordPage;
import utilities.Driver;

import java.util.List;

public class C03_ActionsForm {
/*
        Go to https://claruswaysda.github.io/ActionsForm.html
        Fill form and submit
        Do all actions and assert
    */

    @Test
    void C03_ActionsFormTest() {
        ActionsFormPage formPage = new ActionsFormPage();

//        Go to https://claruswaysda.github.io/ActionsForm.html
        Driver.getDriver().get("https://claruswaysda.github.io/ActionsForm.html");

//        Fill form and submit
        formPage
                .enterName("John")
                .enterAge("30")
                .selectDepartment("IT Department")
                .clickCoding()
                .clickMale()
                .clickGenerate()
                .handleJSAlertPasscode()
                .clickSubmit();

//        Do all actions and assert
        ActionsClickDragPage actionsPage = new ActionsClickDragPage();

        actionsPage.clickButton();
        Assert.assertEquals(actionsPage.getClickResult(), "You clicked!", "Click action failed!");

        actionsPage.doubleClickButton();
        Assert.assertEquals(actionsPage.getDoubleClickResult(), "You double clicked!", "Double Click failed!");

        actionsPage.rightClickButton();
        Assert.assertEquals(actionsPage.getRightClickResult(), "You right clicked!", "Right Click failed!");

        actionsPage.dragAndDrop();
        Assert.assertEquals(actionsPage.getDragDropResult(), "Dropped!", "Drag and Drop failed!");

        Driver.closeDriver();
    }


    }

