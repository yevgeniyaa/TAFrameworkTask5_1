package com.epam.ta.framework.ui.pages.businesstrip;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;

public class BTDetailsBlock extends AbstractPage {
    private final By PLANNED_DURATION_LOCATOR = By.xpath("//span[@id='plannedDuration']");
    private final By PLANNED_START_DATE_LOCATOR = By.xpath("//input[@id='plannedStartDate_ui']");
    private final By PLANNED_END_DATE_LOCATOR = By.xpath("//input[@id='plannedEndDate_ui']");
    private final By DESTINATION_COUNTRY_LOCATOR = By.xpath(".//select[@name='destinationCountryId']");
    private final By DESTINATION_CITY_LOCATOR = By.xpath("//input[@name='destinationCity']");
    private final By DESTINATION_ADDRESS_LOCATOR = By.xpath("//textarea[@name='destinationAddress']");
    private final By DESCRIPTION_LOCATOR = By.xpath("//textarea[@id='description']");
    private final By TICKET_LOCATOR = By.xpath("//input[@id='ticketsRequired']");
    private final By CAR_LOCATOR = By.xpath("//input[@id='carRequired']");

    public BTDetailsBlock inputStartDate(String plannedStartDate){
        waitForElementVisibleEnabled(PLANNED_START_DATE_LOCATOR);
        Driver.getDriverInstance().findElement(PLANNED_START_DATE_LOCATOR).click();
        Driver.getDriverInstance().findElement(PLANNED_START_DATE_LOCATOR).clear();
        Driver.getDriverInstance().findElement(PLANNED_START_DATE_LOCATOR).sendKeys(plannedStartDate);
        return this;
    }
}
