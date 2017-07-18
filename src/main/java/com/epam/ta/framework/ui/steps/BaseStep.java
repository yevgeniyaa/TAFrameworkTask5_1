package com.epam.ta.framework.ui.steps;

import com.epam.ta.framework.ui.pages.dashboard.DashBoardPage;
import com.epam.ta.framework.ui.pages.general.ActionsBlock;
import com.epam.ta.framework.ui.pages.login.LogOutBlock;
import com.epam.ta.framework.ui.pages.login.LoginPage;

public class BaseStep {
    protected final String projectName = "ENRC-TRD";
    protected final String country = "Belarus";
    protected final String destinationCity = "Minsk";
    protected final String destinationAddress = "Minsk";
    public final String sectionName = "Business Trips";

    private final String textWelcome = "Welcome to EPAM Cost Tracking Center";
    private final String textAfterSuccessfulLogin = "Logged in as ";

    private LoginPage loginPage = new LoginPage();
    private DashBoardPage dashBoardPage = new DashBoardPage();
    private ActionsBlock actionsBlock = new ActionsBlock();

    public BaseStep() {
    }

    public boolean login(String baseUrl, String userName, String pwdName, String Name){
        loginPage.open(baseUrl).login(userName, pwdName);
        return dashBoardPage.readLoggedinText().contains(textAfterSuccessfulLogin + Name);
    }

    public boolean logout(){
        new LogOutBlock().logout().confirmation();
        return new LoginPage().readIntroductionText().contains(textWelcome);
    }

    public void submitWithActionNote(){
        actionsBlock.clickSubmit();
        actionsBlock.fillActionNote();
        actionsBlock.submitConfirmation();
    }

    public void submitWithoutActionNote(){
        actionsBlock.clickSubmit();
        actionsBlock.submitConfirmation();

    }
}
