package com.epam.ta.framework.ui.driver;

import com.epam.ta.framework.results.logger.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static final int PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS = 15;
    private static final int COMMAND_DEFAULT_TIMEOUT_SECONDS = 10;
    private static WebDriver instance;

    private Driver() {
    }

    public static WebDriver getDriverInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = initDriver();
    }

    private static WebDriver initDriver(){
        System.setProperty("webdriver.chrome.driver", "driverbinaries/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(COMMAND_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeBrowser(){
        if (instance != null) {
            try {
                instance.quit();
            } catch (Exception e) {
                Logger.error("Cannot kill browser");
            } finally {
                instance = null;
            }
        }
    }

}
