package com.epam.ta.framework.ui.steps.businesstrip;

import com.epam.ta.framework.ui.pages.businesstrip.BTListPage;
import com.epam.ta.framework.ui.pages.businesstrip.CreateBTPage;
import com.epam.ta.framework.ui.steps.BaseStep;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BusinessTripStep extends BaseStep {
    private CreateBTPage createBTPage = new CreateBTPage();
    private BTListPage btListPage = new BTListPage();
    private Date currentDate = new Date();
    private DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private DateFormat inputFormat = new SimpleDateFormat("MM/dd/yy");
    private long msDay = 7 * 24 * 60 * 60 * 1000;  //миллисекунд в 7 сутках
    private Integer estimatedBudget = 200000;
    private String plannedStartDate = inputFormat.format(currentDate); //
    private String plannedEndDate = inputFormat.format(currentDate.getTime() + msDay);
    private String summaryBT = "BT created by Selenium " + sdf.format(currentDate);

    public BusinessTripStep() {
    }

    public void createBT(){
        btListPage.newBtClick();
        createBTPage.chooseProject(projectName);
        createBTPage.inputEstimatedBudget(estimatedBudget);
        createBTPage.inputDestinationCountry(country);
        createBTPage.inputDestinationCity(destinationCity);
        createBTPage.inputDestinationAddress(destinationAddress);
        createBTPage.btDetailsBlock.inputTripDescription("Travel to " + destinationCity + " " + sdf.format(currentDate));
        createBTPage.inputStartDate(plannedStartDate);
        createBTPage.inputEndDate(plannedEndDate);
        createBTPage.inputSummary(summaryBT);
        createBTPage.saveItem();
    }

    public String openList(String baseUrl){
        btListPage.open(baseUrl);
        return btListPage.readListName();
    }

    public void editBT(){

    }

    public void cancelBT(){

    }

    public void rejectBT(){

    }

    public boolean checkBTid(){
        if (createBTPage.countBTid() == 19){
            return true;
        } else return false;
    }

    public boolean isSubmitted(){
        if ((createBTPage.getStatus().toLowerCase().contains("submitted")) || (createBTPage.getStatus().toLowerCase().contains("submited"))){
            return true;
        } else return false;
    }
}
