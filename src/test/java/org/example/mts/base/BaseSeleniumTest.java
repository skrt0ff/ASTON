package org.example.mts.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest { //Абстрактный класс отвечает за настройку и завершение работы тестового окружения

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //Страница на весь экран
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //Вермя ожидания загрузки страницы
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Время ожидания элементов на странице
        driver.get("https://www.mts.by/");
        //BaseSeleniumPage.setDriver(driver);
    }

    @AfterTest
    public void tearDown() {
        driver.close(); //Закрываем ChromeDriver
        driver.quit(); //Закрываем браузер

    }
}
