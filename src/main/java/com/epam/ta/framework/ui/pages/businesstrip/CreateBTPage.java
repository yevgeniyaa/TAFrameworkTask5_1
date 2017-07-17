package com.epam.ta.framework.ui.pages.businesstrip;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CreateBTPage extends AbstractPage {
    public BTDetailsBlock btDetailsBlock = new BTDetailsBlock();
    public BTGeneralInfoBlock btGeneralInfoBlock = new BTGeneralInfoBlock();

    private final By SAVE_BUTTON_LOCATOR = By.xpath("//button[text()[contains(.,'Save Changes')]]");

    public void inputSummary(String summary){
//        btGeneralInfoBlock.clearSummary();
        btGeneralInfoBlock.inputSummary(summary);
    }

    public void chooseProject(String projectName) {
        btGeneralInfoBlock.clearProject();
        btGeneralInfoBlock.chooseProject().changeFilter().searchProjectOrCost(projectName).clickByOK();
    }

    public void inputEstimatedBudget(Integer estimatedBudget){
        btGeneralInfoBlock.inputEstimatedBudget(estimatedBudget);
    }

    public void inputDestinationCountry(String country){
        btDetailsBlock.inputDestinationCountry(country);
    }

    public void inputDestinationCity(String destinationCity){
        btDetailsBlock.inputDestinationCity(destinationCity);
    }

    public void inputDestinationAddress(String destinationAddress){
        btDetailsBlock.inputDestinationAddress(destinationAddress);
    }

    public void inputStartDate(String plannedStartDate){
        btDetailsBlock.inputStartDate(plannedStartDate);
    }

    public void inputEndDate(String plannedEndDate){
        btDetailsBlock.inputEndDate(plannedEndDate);
    }

    public void saveItem(){
        waitForElementVisibleEnabled(SAVE_BUTTON_LOCATOR);

//        System.out.println(btDetailsBlock.getPlannedDuration());
        String executeString = Driver.getDriverInstance().findElement(SAVE_BUTTON_LOCATOR).getAttribute("onclick");
        ((JavascriptExecutor)Driver.getDriverInstance()).executeScript(executeString);
    }

    public CreateBTPage saveForm() {
//        waitForElementVisibleEnabled(PLANNED_START_DATE_LOCATOR);
        waitForElementVisibleEnabled(SAVE_BUTTON_LOCATOR);
//        waitForFillingPlanningDuration(PLANNED_DURATION_LOCATOR, "0");

        String executeString = Driver.getDriverInstance().findElement(SAVE_BUTTON_LOCATOR).getAttribute("onclick");
        ((JavascriptExecutor)Driver.getDriverInstance()).executeScript(executeString);
        return this;
    }

//    public boolean countBTid(){
//        if (btGeneralInfoBlock.getBTid().length() == 19){
//            return true;
//        } else return false;
//    }

    public Integer countBTid(){
        return btGeneralInfoBlock.getBTid().length();
    }

    public String getDuration() {
        String startDate = btDetailsBlock.getPlannedStartDate();
        String endDate = btDetailsBlock.getPlannedEndDate();
        return startDate + " - " + endDate;
    }
}
