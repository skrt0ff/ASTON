package org.example.mts.pageCommssion;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class CommissionPage extends BaseSeleniumPage { //Класс, предоставляющий страницу с комиссией.
    // Наследуется от BaseSeleniumPage и содержит методы для взаимодействия с элементами страницы

    @FindBy(xpath = "//h2[text()='Онлайн пополнение ']")
    private WebElement nameBlock1;

    @FindBy(xpath = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul")
    private WebElement paymentLogosContainer;

    @FindBy(xpath = "//a[text()='Подробнее о сервисе']")
    private WebElement linkOfService;

    @FindBy(xpath = "//*[text()='Принять']")
    private WebElement agreeBtn;

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement inputNumber;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement inputCost;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueBtn;

    @FindBy(xpath = "//*[text()='Номер телефона указан неверно']")
    private WebElement incorrectNumber;

    private List<WebElement> paymentLogos;


    public CommissionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /*Необходимо написать автотесты для сайта mts.by - http://mts.by  . Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
    1. Проверить название указанного блока;
    2. Проверить наличие логотипов платёжных систем;
    3. Проверить работу ссылки «Подробнее о сервисе»;
    4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)*/

    public String getBlockTitle() {
        return nameBlock1.getText(); //Возвращаем текст блока
    }

    public int getPaymentLogosCount(){
        List<WebElement> paymentLogos = paymentLogosContainer.findElements(By.tagName("li"));
        return paymentLogos.size(); //Возвращаем количество логотипов, тем самым проверяя их наличие
    }

    public void clickLinkOfService() {
        linkOfService.click(); //Переходим по ссылке
    }

    public void enterServiceNumber(String serviceNumber, String cost){
        inputNumber.sendKeys(serviceNumber);
        inputCost.sendKeys(cost);
        continueBtn.click();
    }

    public boolean isPayPopupDisplayed() {
        try {
            return incorrectNumber.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
