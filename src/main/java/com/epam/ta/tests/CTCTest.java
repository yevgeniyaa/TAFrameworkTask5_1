package com.epam.ta.tests;

//todo Убрать ненужный импорт
import com.epam.ta.framework.ui.business_objects.User;
import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.steps.BaseStep;
import com.epam.ta.framework.ui.steps.businesstrip.BusinessTripStep;
import com.epam.ta.framework.utils.Screenshoter;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CTCTest {
    private BusinessTripStep businessTripStep = new BusinessTripStep();
    private BaseStep baseStep = new BaseStep();//todo Зачем? BusinessTripStep ведь наследуется от BaseStep

    private final String sectionName = "Business Trips";


    @Test(description = "Log in")//todo Больше похоже на подготовительный шаг
    @Parameters({"baseUrl"})
    public void loginTest(String baseUrl){
        Assert.assertTrue(baseStep.login(baseUrl), "Impossible to login to CTC");
        Screenshoter.takeScreenshot();//todo После ассерта кода в тесте быть не должно (относится ко всем тестам здесь)
    }

    @Test(dependsOnMethods = "loginTest", description = "check opening the list of Bussiness Trips")
    @Parameters({"baseUrl"})
    public void openListOfBT(String baseUrl) {
        Assert.assertEquals(businessTripStep.openList(baseUrl), sectionName, "The section did not found");
        Screenshoter.takeScreenshot();
    }

    @Test(dependsOnMethods = "openListOfBT", description = "create new BT")
    public void createNewBt(){
        businessTripStep.createBT();
        Assert.assertTrue(businessTripStep.checkBTid(), "Business Trip is not created");
        Screenshoter.takeScreenshot();
    }

    @Test(dependsOnMethods = "createNewBt", description = "submit BT")
    public void submitBT(){
        baseStep.submitWithActionNote();
        Assert.assertTrue(businessTripStep.isSubmitted(), "Business Trip is not submited");
        Screenshoter.takeScreenshot();
    }

    @Test(dependsOnMethods = "submitBT", description = "Log out")//todo больше похоже на cleanUp шаг
    public void logOut() {
        Assert.assertTrue(baseStep.logout(),"Logout is not performed");
        Screenshoter.takeScreenshot();
    }

    @AfterClass(description = "Close browser")
    public void closeBrowser(){
        Driver.closeBrowser();
    }
}
