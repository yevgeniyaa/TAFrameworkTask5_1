package com.epam.ta.framework.ui.pages.businesstrip;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

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

    public BTDetailsBlock inputEndDate(String plannedEndDate){
        waitForElementVisibleEnabled(PLANNED_END_DATE_LOCATOR);
        Driver.getDriverInstance().findElement(PLANNED_END_DATE_LOCATOR).click();
        Driver.getDriverInstance().findElement(PLANNED_END_DATE_LOCATOR).clear();
        Driver.getDriverInstance().findElement(PLANNED_END_DATE_LOCATOR).sendKeys(plannedEndDate);
        return this;
    }

    public BTDetailsBlock inputTripFromLocation(){
        return this;
    }

    public BTDetailsBlock inputDestinationCountry(String country){
        waitForElementVisibleEnabled(DESTINATION_COUNTRY_LOCATOR);
        Select countrySelect = new Select(Driver.getDriverInstance().findElement(DESTINATION_COUNTRY_LOCATOR));
        countrySelect.selectByVisibleText(country);
        return this;
    }

    public BTDetailsBlock inputDestinationCity(String destinationCity){
        Driver.getDriverInstance().findElement(DESTINATION_CITY_LOCATOR).sendKeys(destinationCity);
        return this;
    }

    public BTDetailsBlock inputDestinationAddress(String destinationAddress){
        Driver.getDriverInstance().findElement(DESTINATION_ADDRESS_LOCATOR).sendKeys(destinationAddress);
        return this;
    }

    public BTDetailsBlock inputTripDescription(String description){
        Driver.getDriverInstance().findElement(DESCRIPTION_LOCATOR).sendKeys(description);
        return this;
    }

    public BTDetailsBlock selectTicket(){
        if (!Driver.getDriverInstance().findElement(TICKET_LOCATOR).isSelected()) {
            Driver.getDriverInstance().findElement(TICKET_LOCATOR).click();
        }
        return this;
    }

    public BTDetailsBlock selectCar(){
        if (!Driver.getDriverInstance().findElement(CAR_LOCATOR).isSelected()) {
            Driver.getDriverInstance().findElement(CAR_LOCATOR).click();
        }
        return this;
    }

    public String getPlannedDuration(){
        return Driver.getDriverInstance().findElement(PLANNED_DURATION_LOCATOR).getText();
    }

    public String getPlannedEndDate() {
        return Driver.getDriverInstance().findElement(PLANNED_END_DATE_LOCATOR).getAttribute("value");
    }

    public String getPlannedStartDate() {
        return Driver.getDriverInstance().findElement(PLANNED_START_DATE_LOCATOR).getAttribute("value");
    }
}
