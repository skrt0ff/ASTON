package org.example.mts.pageCommssion;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

abstract public class BaseSeleniumPage { //Содержит статическую ссылку на WebDriver, позволяя избежать необходимости передавать экземпляр для каждого Page Object

    protected static WebDriver driver;

    public BaseSeleniumPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    protected void switchToFrame(WebElement frame) { //Метод для перехода по фреймам
        driver.switchTo().frame(frame);
    }
}
