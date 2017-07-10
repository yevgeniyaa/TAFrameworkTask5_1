package com.epam.ta.framework.ui.steps;

import com.epam.ta.framework.ui.pages.login.LogOutBlock;
import com.epam.ta.framework.ui.pages.login.LoginPage;

public class BaseStep {
    private final String textWelcome = "Welcome to EPAM Cost Tracking Center";

    public BaseStep() {
    }

    public boolean logout(){
        new LogOutBlock().logout().confirmation();
        return new LoginPage().readIntroductionText().contains(textWelcome);
    }
}
