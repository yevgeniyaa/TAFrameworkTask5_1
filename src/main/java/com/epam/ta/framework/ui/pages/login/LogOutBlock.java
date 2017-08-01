package com.epam.ta.framework.ui.pages.login;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;

public class LogOutBlock extends AbstractPage {
    private final By LOGOUT_LOCATOR = By.xpath("//a[@href='logout.do']");

    public LogOutBlock logout(){
        waitForElementVisible(LOGOUT_LOCATOR);
        waitForElementEnabled(LOGOUT_LOCATOR);
        Driver.getDriverInstance().findElement(LOGOUT_LOCATOR).click();
        return this;
    }

    public LogOutBlock confirmation(){//todo Общий метод. Вынеси в общий класс
        Driver.getDriverInstance().switchTo().alert().accept();
        return this;
    }


}
