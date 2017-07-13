package com.epam.ta.framework.ui.pages.general;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;

public class ChooseProjectBlock extends AbstractPage {
    private final String frameLookupDialogName = "frLookupDialog";
    private final By FILTER_LOCATOR = By.xpath("//select[@name='filter']");
    private final By SEARCH_INPUT_LOCATOR = By.xpath("//input[@name='keywordSearch']");
    private final By GO_BUTTON_LOCATOR = By.xpath("//input[@value='Go']");
    private final By OK_BUTTON_LOCATOR = By.xpath("//input[@value='OK']");

    public ChooseProjectBlock changeFilter(){
        Driver.getDriverInstance().switchTo().frame(frameLookupDialogName);
        waitForElementVisibleEnabled(FILTER_LOCATOR);
        Driver.getDriverInstance().findElement(FILTER_LOCATOR).sendKeys("My projects");
        return this;
    }

    public ChooseProjectBlock searchProjectOrCost(String projectName){
        waitForElementVisibleEnabled(SEARCH_INPUT_LOCATOR);
        Driver.getDriverInstance().findElement(SEARCH_INPUT_LOCATOR).sendKeys(projectName);
        Driver.getDriverInstance().findElement(GO_BUTTON_LOCATOR).click();
        Driver.getDriverInstance().findElement(By.xpath("//input[@type='checkbox' and @projectcostobjectname='" + projectName + "']")).click();
        return this;
    }

    public ChooseProjectBlock clickByOK (){
        waitForElementVisibleEnabled(OK_BUTTON_LOCATOR);
        Driver.getDriverInstance().findElement(OK_BUTTON_LOCATOR).click();
        return this;
    }

}
