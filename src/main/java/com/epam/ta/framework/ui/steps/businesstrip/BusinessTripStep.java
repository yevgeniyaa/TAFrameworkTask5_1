package com.epam.ta.framework.ui.steps.businesstrip;

import com.epam.ta.framework.ui.business_objects.BusinessTripBO;
import com.epam.ta.framework.ui.pages.businesstrip.BTListPage;
import com.epam.ta.framework.ui.pages.businesstrip.CreateBTPage;
import com.epam.ta.framework.ui.steps.BaseStep;

public class BusinessTripStep extends BaseStep {
    private CreateBTPage createBTPage = new CreateBTPage();
    private BTListPage btListPage = new BTListPage();
    private BusinessTripBO businessTripBO = new BusinessTripBO();

    public BusinessTripStep() {
    }

    public void createBT(){
        btListPage.newBtClick();
        createBTPage.chooseProject(businessTripBO.getProjectName());
        createBTPage.inputEstimatedBudget(businessTripBO.getEstimatedBudget());
        createBTPage.inputTripFromLocation(businessTripBO.getLocationFrom());
        createBTPage.inputDestinationCountry(businessTripBO.getCountry());
        createBTPage.inputDestinationCity(businessTripBO.getDestinationCity());
        createBTPage.inputDestinationAddress(businessTripBO.getDestinationAddress());
        createBTPage.inputTripDescription(businessTripBO.getDescription());
        createBTPage.inputStartDate(businessTripBO.getPlannedStartDate());
        createBTPage.inputEndDate(businessTripBO.getPlannedEndDate());
        createBTPage.inputSummary(businessTripBO.getSummary());
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
