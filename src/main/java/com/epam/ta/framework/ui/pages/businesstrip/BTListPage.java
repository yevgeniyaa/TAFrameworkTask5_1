package com.epam.ta.framework.ui.pages.businesstrip;

import com.epam.ta.framework.ui.driver.Driver;
import com.epam.ta.framework.ui.pages.AbstractPage;
import org.openqa.selenium.By;

public class BTListPage extends AbstractPage {
    private final String BUSINESS_TRIP_LOCATION = "/businesstrip/list.do";
    private final By BT_LIST_NAME_LOCATOR = By.xpath("//td[@class='header1']/h1");
    private final By CREATE_BUTTON_LOCATOR = By.xpath("//input[@title='Create New Business Trip Request']");

    //todo Это общий метод. Его нужно выносить в общий класс
    //todo И вот это, кстати, отличная возможность применить еще один порождающий паттерн - снова не скажу какой, но ты его упоминал
    public BTListPage open(String baseUrl){
        Driver.getDriverInstance().get(baseUrl + BUSINESS_TRIP_LOCATION);
        return this;
    }

    public CreateBTPage newBtClick(){
        waitForElementEnabled(CREATE_BUTTON_LOCATOR);
        Driver.getDriverInstance().findElement(CREATE_BUTTON_LOCATOR).click();
        return new CreateBTPage();//todo Чем обусловлен возврат именно этого объекта?
    }

    public String readListName(){//todo наименование метода не отражает сути
        waitForElementPresent(BT_LIST_NAME_LOCATOR);
        return Driver.getDriverInstance().findElement(BT_LIST_NAME_LOCATOR).getText();
    }
}
