package com.epam.ta.framework.ui.pages.general;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionsBlock extends AbstractPage {
    private Date currentDate = new Date();//todo Здесь не место (уже объясняла). Убрать
    private DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");//todo Здесь не место (уже объясняла). Убрать

    private final By SUBMIT_BUTTON_LOCATOR = By.xpath("//input[@value='Submit']");
    private final By CANCEL_BUTTON_LOCATOR = By.xpath("//input[@value='Cancel']");
    private final By ACTION_FRAME_LOCATOR = By.xpath("//iframe[@id='frLookupDialog']");
    private final By ACTION_NOTE_LOCATOR = By.xpath("//textarea[@id='actionNote']");
    private final By WORKFLOW_TITLE_LOCATOR = By.xpath("//td[@class='captionTitle']/h1");
    private final By SUBMIT_BUTTON_IN_FRAME_LOCATOR = By.xpath("//input[contains(@value,'Submit')]");


    public void clickSubmit() {
        waitForElementPresent(SUBMIT_BUTTON_LOCATOR);
        Driver.getDriverInstance().findElement(SUBMIT_BUTTON_LOCATOR).click();
        Driver.getDriverInstance().switchTo().frame(Driver.getDriverInstance().findElement(ACTION_FRAME_LOCATOR));
    }

    public void clickCancel() {
        waitForElementPresent(CANCEL_BUTTON_LOCATOR);
        Driver.getDriverInstance().findElement(CANCEL_BUTTON_LOCATOR).click();
        Driver.getDriverInstance().switchTo().frame(Driver.getDriverInstance().findElement(ACTION_FRAME_LOCATOR));
    }

    public void fillActionNote(){
        waitForElementVisibleEnabled(ACTION_NOTE_LOCATOR);
        Driver.getDriverInstance().findElement(ACTION_NOTE_LOCATOR).sendKeys(Driver.getDriverInstance().findElement(WORKFLOW_TITLE_LOCATOR).getText() + " performed " + sdf.format(currentDate));
    }

    public void submitConfirmation(){
        waitForElementVisibleEnabled(SUBMIT_BUTTON_IN_FRAME_LOCATOR);
        Driver.getDriverInstance().findElement(SUBMIT_BUTTON_IN_FRAME_LOCATOR).click();
    }
}
