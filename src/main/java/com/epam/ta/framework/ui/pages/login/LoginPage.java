package com.epam.ta.framework.ui.pages.login;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.dashboard.DashBoardPage;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;

public class LoginPage extends AbstractPage {
    private final String ADDITIONAL_URL = "/login.do?logout=true&tz=GMT%2B06:00";
    private final By USER_NAME_INPUT_LOCATOR = By.xpath("//input[@name='username']");
    private final By PASSWORD_INPUT_LOCATOR = By.xpath("//input[@name='password']");
    private final By LOGIN_BUTTON_LOCATOR = By.xpath("//input[@name='Login']");
    private final By LOGIN_PAGE_TEXT_LOCATOR = By.xpath("//td[@class='header1']/h1");

    public DashBoardPage login(String userName, String pwdName){
        Driver.getDriverInstance().findElement(USER_NAME_INPUT_LOCATOR).sendKeys(userName);
        Driver.getDriverInstance().findElement(PASSWORD_INPUT_LOCATOR).sendKeys(pwdName);
        Driver.getDriverInstance().findElement(LOGIN_BUTTON_LOCATOR).click();
        return new DashBoardPage();
    }

    public LoginPage open(String baseUrl){//todo Уже писала про этот метод. Вынести в общий
        Driver.getDriverInstance().get(baseUrl + ADDITIONAL_URL);
        return this;
    }

    public String readIntroductionText(){
        waitForElementVisible(LOGIN_PAGE_TEXT_LOCATOR);
        return Driver.getDriverInstance().findElement(LOGIN_PAGE_TEXT_LOCATOR).getText();
    }
}
