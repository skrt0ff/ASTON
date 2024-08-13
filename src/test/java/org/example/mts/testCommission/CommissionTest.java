package org.example.mts.testCommission;

import org.example.mts.pageCommssion.CommissionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommissionTest extends BaseSeleniumTest {

    private CommissionPage commissionPage;
    String serviceNumber = "297777777";
    String cost = "200";

    @BeforeTest
    public void initPage() {
        commissionPage = new CommissionPage(driver);
    }

    //Первое задание
    //Для полей услуг связи
    @Test
    public void communicationPlaceHolderNumberInputTest() {
        String servicePlaceHolder = commissionPage.getCommunicationNumberPlaceholder();
        Assert.assertEquals(servicePlaceHolder, "Номер телефона");
    }

    @Test
    public void communicationPlaceHolderSumInputTest() {
        String servicePlaceHolder = commissionPage.getCommunicationSumPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "Сумма");
    }

    @Test
    public void communicationPlaceHolderEmailInputTest() {
        String servicePlaceHolder = commissionPage.getCommunicationEmailPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "E-mail для отправки чека");
    }

    //Для вкладки домашний интернет
    @Test
    public void internetPlaceHolderInternetNumberInputTest() {
        String servicePlaceHolder = commissionPage.getInternetPhonePlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "Номер абонента");
    }

    @Test
    public void internetPlaceHolderInternetSumInputTest() {
        String servicePlaceHolder = commissionPage.getInternetSumPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "Сумма");
    }

    @Test
    public void internetPlaceHolderInternetEmailInputTest() {
        String servicePlaceHolder = commissionPage.getInternetEmailPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "E-mail для отправки чека");
    }

    //Для вкладки рассрочка
    @Test
    public void installmentPlaceHolderNumberInputTest() {
        String servicePlaceHolder = commissionPage.getInstallmentsScorePlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "Номер счета на 44");
    }

    @Test
    public void installmentPlaceHolderSumInputTest() {
        String servicePlaceHolder = commissionPage.getInstallmentsSumPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "Сумма");
    }

    @Test
    public void installmentPlaceHolderEmailInputTest() {
        String servicePlaceHolder = commissionPage.getInstallmentsEmailPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "E-mail для отправки чека");
    }

    //Для вкладки задолженность
    @Test
    public void arrearsPlaceHolderNumberInputTest() {
        String servicePlaceHolder = commissionPage.getScoreArrearsPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "Номер счета на 2073");
    }

    @Test
    public void arrearsPlaceHolderSumInputTest() {
        String servicePlaceHolder = commissionPage.getArrearsSumPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "Сумма");
    }

    @Test
    public void arrearsPlaceHolderEmailInputTest() {
        String servicePlaceHolder = commissionPage.getArrearsEmailPlaceHolder();
        Assert.assertEquals(servicePlaceHolder, "E-mail для отправки чека");
    }

    //Второе задание
    //Для проверки логотипов
    @Test
    public void paymentLogosTest() {
        Assert.assertEquals(commissionPage.getPaymentLogosCount(), 5);
    }

    //Для полей ввода
    @Test
    public void paymentCardNumberLabelTest() {
        Assert.assertEquals(commissionPage.getPaymentCardNumberLabel(), "Номер карты");
    }

    @Test
    public void paymentPeriodLabelTest() {
        Assert.assertEquals(commissionPage.getPaymentPeriodLabel(), "Срок действия");
    }

    @Test
    public void paymentCVCLabelTest() {
        commissionPage.enterServiceNumber(serviceNumber, cost);
        Assert.assertEquals(commissionPage.getPaymentCVCLabel(), "CVC");
    }

    @Test
    public void paymentNamePersonLabelTest() {
        Assert.assertEquals(commissionPage.getPaymentNamePersonLabel(), "Имя держателя (как на карте)");
    }

    //Для проверки корректности суммы, номера и текста на кнопке
    @Test
    public void paymentOrderCostTest() {
        Assert.assertEquals(commissionPage.getOrderCost(), cost + ".00 BYN");
    }

    @Test
    public void paymentOrderTextTest() {
        Assert.assertEquals(commissionPage.getOrderText(), "Оплата: Услуги связи Номер:375" + serviceNumber);
    }

    @Test
    public void paymentOrderBtnTextTest() {
        Assert.assertEquals(commissionPage.getOrderBtnText(), "Оплатить " + cost + ".00 BYN");
    }
}
