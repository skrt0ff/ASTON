package org.example.mts.pageCommssion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CommissionPage extends BaseSeleniumPage { //Класс, предоставляющий страницу с комиссией.
    // Наследуется от BaseSeleniumPage и содержит методы для взаимодействия с элементами страницы

    @FindBy(xpath = "//input[@id='connection-phone']")
    private WebElement communicationServicesNumberPlaceHolder, inputNumber;

    @FindBy(xpath = "//input[@id='connection-sum']")
    private WebElement communicationServicesSumPlaceHolder, inputCost;

    @FindBy(xpath = "//input[@placeholder='E-mail для отправки чека']")
    private WebElement communicationServicesEmailPlaceHolder;

    @FindBy(xpath = "//*[@id='internet-phone']")
    private WebElement internetPhonePlaceHolder;

    @FindBy(xpath = "//*[@id='internet-sum']")
    private WebElement internetSumPlaceHolder;

    @FindBy(xpath = "//*[@id='internet-email']")
    private WebElement internetEmailPlaceHolder;

    @FindBy(xpath = "//*[@id='score-instalment']")
    private WebElement InstalmentScorePlaceHolder;

    @FindBy(xpath = "//*[@id='instalment-sum']")
    private WebElement InstalmentSumPlaceHolder;

    @FindBy(xpath = "//*[@id='instalment-email']")
    private WebElement InstalmentEmailPlaceHolder;

    @FindBy(xpath = "//*[@id='score-arrears']")
    private WebElement ScoreArrearsPlaceHolder;

    @FindBy(xpath = "//input[@id='arrears-sum']")
    private WebElement ArrearsSumPlaceHolder;

    @FindBy(xpath = "//input[@id='arrears-email']")
    private WebElement ArrearsEmailPlaceHolder;

    @FindBy(xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueBtn;

    @FindBy(xpath = "//div[@class='pay-description__cost']")
    private WebElement paymentAmountSpan;

    @FindBy(xpath = "//div[@class='pay-description__text']")
    private WebElement paymentNumberSpan;

    @FindBy(css = "div.content.ng-tns-c46-1 label")
    private WebElement paymentCardNumberPlaceHolder;

    @FindBy(xpath = "//label[text()='Срок действия']")
    private WebElement paymentPeriodPlaceHolder;

    @FindBy(xpath = "//label[text()='CVC']")
    private WebElement paymentCVCPlaceHolder;

    @FindBy(xpath = "//label[text()='Имя держателя (как на карте)']")
    private WebElement paymentNamePersonPlaceHolder;

    @FindBy(xpath = "//div[@class='icons-container ng-tns-c46-1']")
    private WebElement paymentIcons;

    @FindBy(css = "button.colored.disabled")
    private WebElement paymentButtonText;

    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement paymentFrame;

    @FindBy(css = "div.pay-description__cost > span")
    private WebElement paymentOrderCost;

    @FindBy(css = "div.pay-description__text > span")
    private WebElement paymentOrderText;

    public CommissionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Методы для вкладки "Услуги связи"
    public String getCommunicationNumberPlaceholder() {
        return communicationServicesNumberPlaceHolder.getAttribute("placeholder");
    }

    public String getCommunicationSumPlaceHolder() {
        return communicationServicesSumPlaceHolder.getAttribute("placeholder");
    }

    public String getCommunicationEmailPlaceHolder() {
        return communicationServicesEmailPlaceHolder.getAttribute("placeholder");
    }

    //Методы для вкладки "Домашний интернет"
    public String getInternetPhonePlaceHolder() {
        return internetPhonePlaceHolder.getAttribute("placeholder");
    }

    public String getInternetSumPlaceHolder() {
        return internetSumPlaceHolder.getAttribute("placeholder");
    }

    public String getInternetEmailPlaceHolder() {
        return internetEmailPlaceHolder.getAttribute("placeholder");
    }

    //Методы для вкладки "Рассрочка"
    public String getInstallmentsScorePlaceHolder() {
        return InstalmentScorePlaceHolder.getAttribute("placeholder");
    }

    public String getInstallmentsSumPlaceHolder() {
        return InstalmentSumPlaceHolder.getAttribute("placeholder");
    }

    public String getInstallmentsEmailPlaceHolder() {
        return InstalmentEmailPlaceHolder.getAttribute("placeholder");
    }

    //Методы для вкладки "Задолженность"
    public String getScoreArrearsPlaceHolder() {
        return ScoreArrearsPlaceHolder.getAttribute("placeholder");
    }

    public String getArrearsSumPlaceHolder() {
        return ArrearsSumPlaceHolder.getAttribute("placeholder");
    }

    public String getArrearsEmailPlaceHolder() {
        return ArrearsEmailPlaceHolder.getAttribute("placeholder");
    }

    //Второе задание

    public void enterServiceNumber(String serviceNumber, String cost) {
        inputNumber.sendKeys(serviceNumber);
        inputCost.sendKeys(cost);
        continueBtn.click();
        switchToFrame(paymentFrame);
    }

    public int getPaymentLogosCount() {
        List<WebElement> paymentLogos = paymentIcons.findElements(By.tagName("img"));
        return paymentLogos.size();
    }

    //Методы для ввода реквизитов
    public String getPaymentCardNumberLabel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement cardNumberLabel = wait.until(ExpectedConditions.visibilityOf(paymentCardNumberPlaceHolder));
        return cardNumberLabel.getText();
    }

    public String getPaymentPeriodLabel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement periodLabel = wait.until(ExpectedConditions.visibilityOf(paymentPeriodPlaceHolder));
        return periodLabel.getText();
    }

    public String getPaymentCVCLabel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement CVCLabel = wait.until(ExpectedConditions.visibilityOf(paymentCVCPlaceHolder));
        return CVCLabel.getText();
    }

    public String getPaymentNamePersonLabel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement namePersonLabel = wait.until(ExpectedConditions.visibilityOf(paymentNamePersonPlaceHolder));
        return namePersonLabel.getText();
    }

    //Для уточнения суммы, номера, текста на кнопке
    public String getOrderCost() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orderCost = wait.until(ExpectedConditions.visibilityOf(paymentOrderCost));
        return orderCost.getText();
    }

    public String getOrderText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orderText = wait.until(ExpectedConditions.visibilityOf(paymentOrderText));
        return orderText.getText();
    }

    public String getOrderBtnText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement orderBtnText = wait.until(ExpectedConditions.visibilityOf(paymentButtonText));
        return orderBtnText.getText();
    }
}
