package com.epam.ta.framework.ui.pages;

import com.epam.ta.framework.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//todo Давай все-таки применим PageFactory для всех страниц
public abstract class AbstractPage {
    private static final int WAIT_FOR_ELEMENT_TIMEOUT_SECONDS = 20;

    //todo Для ожиданий нужно создать отдельный утильный класс
    protected void waitForElementPresent(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementVisible(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void waitForElementEnabled(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementVisibleEnabled(By locator) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(
                ExpectedConditions.and(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(locator),
                    ExpectedConditions.elementToBeClickable(locator)));
    }

    protected void waitForFillingField(final By locator, final String expectedResult) {
        new WebDriverWait(Driver.getDriverInstance(), WAIT_FOR_ELEMENT_TIMEOUT_SECONDS).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return (!d.findElement(locator).getText().toLowerCase().equals(expectedResult));
            }
        });
    }


}
