package org.example.mts.comission;

import org.example.mts.base.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

public class CommissionPage extends BaseSeleniumPage { //Страница с блоком "Онллайн пополнение без комиссии"

    /*Необходимо написать автотесты для сайта mts.by - http://mts.by  . Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
    1. Проверить название указанного блока;
    2. Проверить наличие логотипов платёжных систем;
    3. Проверить работу ссылки «Подробнее о сервисе»;
    4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)*/
    private WebElement nameBlock1; //Название блока
    private WebElement paymentLogosContainer; //Логотипы платежных систем
    private WebElement linkOfService; //Сыллка "Подробнее о сервисе"
    private WebElement inputNumber; //Поле для номера
    private WebElement inputCost; //Поле для стоимости
    private WebElement continueBtn; //Кнопка "Продолжить"
    private WebElement agreeBtn; //Кнопка "Принять"
    private WebElement incorrectNumber;


    public CommissionPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        nameBlock1 = driver.findElement(By.xpath("//h2[text()='Онлайн пополнение ']"));
        paymentLogosContainer = driver.findElement(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[2]/ul"));
        linkOfService = driver.findElement(By.xpath("//a[text()='Подробнее о сервисе']"));
        inputNumber = driver.findElement(By.xpath("//input[@id='connection-phone']"));
        inputCost = driver.findElement(By.xpath("//input[@id='connection-sum']"));
        continueBtn = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        agreeBtn = driver.findElement(By.xpath("//*[text()='Принять']"));
    }

    private  void acceptCookies() {
        agreeBtn.click();
    }

    public String getBlockTitle() {
        acceptCookies(); //Принять обработку куки файлов
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


    public String getFieldValueByLocator(String locator) {
        WebElement element = driver.findElement(By.xpath(locator));
        return element.getAttribute("value");
    }

    public boolean isPayPopupDisplayed() {

        try {
            incorrectNumber = driver.findElement(By.xpath("//*[text()='Номер телефона указан неверно']"));
            return incorrectNumber.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
