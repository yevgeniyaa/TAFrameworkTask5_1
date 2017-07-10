package com.epam.ta.tests;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.businesstrip.BTListPage;
import com.epam.ta.framework.ui.pages.businesstrip.CreateBTPage;
import com.epam.ta.framework.ui.pages.dashboard.DashBoardPage;
import com.epam.ta.framework.ui.pages.login.LogOutBlock;
import com.epam.ta.framework.ui.pages.login.LoginPage;
import com.epam.ta.framework.ui.steps.BaseStep;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CTCTest {

    private final String projectName = "ENRC-TRD";
    private final String country = "Belarus";
    private final String destinationCity = "Minsk";
    private final String destinationAddress = "Minsk";
    private final String textAfterSuccessfulLogin = "Logged in as ";
    private final String sectionName = "Business Trips";


    @Test(description = "Log in")
    @Parameters({"baseUrl", "userName", "pwdName", "firstName"})
    public void loginTest(String baseUrl, String userName, String pwdName, String firstName){
        DashBoardPage loginPage = new LoginPage().open(baseUrl).login(userName, pwdName);
        Assert.assertTrue(loginPage.readLoggedinText().contains(textAfterSuccessfulLogin + firstName), "Impossible to login to CTC");
    }

    @Test(dependsOnMethods = "loginTest", description = "check opening the list of Bussiness Trips")
    @Parameters({"baseUrl"})
    public void openListOfBT(String baseUrl) {
        BTListPage btListPage = new BTListPage().open(baseUrl);
        Assert.assertEquals(btListPage.readListName(), sectionName, "The section did not found");
    }

    @Test(dependsOnMethods = "openListOfBT", description = "create new BT")
    public void createNewBt(){
        CreateBTPage createBTPage = new BTListPage().newBtClick().fillMandatoryFields(projectName,country, destinationCity, destinationAddress).saveForm();
        Assert.assertEquals(createBTPage.getBTid().length(), 19, "Business Trip is not created");
    }

    @Test(dependsOnMethods = "createNewBt", description = "Log out")
    public void logOut() {
        Assert.assertTrue(new BaseStep().logout(),"Logout is not performed");
    }

    @AfterClass(description = "Close browser")
    public void closeBrowser(){
        Driver.closeBrowser();
    }
}
