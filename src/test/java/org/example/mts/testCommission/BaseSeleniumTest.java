package org.example.mts.testCommission;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

abstract public class BaseSeleniumTest { //Абстрактный класс отвечает за настройку и завершение работы тестового окружения

    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //Страница на весь экран
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //Вермя ожидания загрузки страницы
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //Время ожидания элементов на странице
        driver.get("https://www.mts.by/");
        acceptCookies();
    }

    private void acceptCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement agreeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Принять']")));
            agreeButton.click();
        } catch (TimeoutException e) {
            System.out.println("Куки не найдены! "); //Если кнопка не найдена в течение 10 секунд, то мы продолжаем работу
        }
    }

    @AfterTest
    public void tearDown() {
        driver.close(); //Закрываем ChromeDriver
        driver.quit(); //Закрываем браузер

    }
}
