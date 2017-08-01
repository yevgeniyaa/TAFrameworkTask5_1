package com.epam.ta.framework.ui.steps;

import com.epam.ta.framework.ui.business_objects.User;
import com.epam.ta.framework.ui.pages.dashboard.DashBoardPage;
import com.epam.ta.framework.ui.pages.general.ActionsBlock;
import com.epam.ta.framework.ui.pages.login.LogOutBlock;
import com.epam.ta.framework.ui.pages.login.LoginPage;

public class BaseStep {

    private final String textWelcome = "Welcome to EPAM Cost Tracking Center";
    private final String textAfterSuccessfulLogin = "Logged in as ";

    //todo Чем обусловлено создание данных объектов именно здесь и именно так?
    private LoginPage loginPage = new LoginPage();
    private DashBoardPage dashBoardPage = new DashBoardPage();
    private ActionsBlock actionsBlock = new ActionsBlock();
    private User user = new User();

    public BaseStep() {
    }

    public boolean login(String baseUrl){
        loginPage.open(baseUrl).login(user.getLogin(), user.getPassword());
        return dashBoardPage.readLoggedinText().contains(textAfterSuccessfulLogin + user.getFullName());
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
