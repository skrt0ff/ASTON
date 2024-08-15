package org.example.mts.testCommission;


import org.openqa.selenium.WebElement;
import pageCommssion.CommissionPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CommissionTest extends BaseSeleniumTest {

     /*Необходимо написать автотесты для сайта mts.by - http://mts.by  . Суть тестов заключается в проверке блока «Онлайн пополнение без комиссии»:
    1. Проверить название указанного блока;
    2. Проверить наличие логотипов платёжных систем;
    3. Проверить работу ссылки «Подробнее о сервисе»;
    4. Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)*/

    private CommissionPage commissionPage;

    @BeforeTest
    public void initPage() {
        commissionPage = new CommissionPage(driver);
    }

    @Test
    public void testBlockTitle() { //Проверка названия указанного блока
        String expectedBlockTitle = "Онлайн пополнение\nбез комиссии";
        String actualBlockTitle = commissionPage.getBlockTitle();
        Assert.assertEquals(actualBlockTitle, expectedBlockTitle, "Неправильное название блока!");
    }

    @Test
    public void testPaymentLogosCount(){ //Проверка наличия логотипов платежных систем
        Assert.assertEquals(commissionPage.getPaymentLogosCount(), 5, "Ожидалось 5 логотипов!");
    }

    @Test
    public void testPaymentLogos() { //Проверка каждого элемента
        List<WebElement> paymentLogos = commissionPage.getPaymentLogos();
        List<String> expectedLogos = Arrays.asList("Visa", "Verified By Visa", "MasterCard", "MasterCard Secure Code", "Белкарт");
        for (WebElement logo : paymentLogos) {
            String logoText = logo.getText();
            Assert.assertTrue(expectedLogos.contains(logoText), "Логотипа '" + logoText + "' нет");
        }
    }

    @Test
    public void testLinkOfService() { //Проверка ссылки "Подробнее о сервисе"
        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";
        commissionPage.clickLinkOfService();
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Неправильный URL при переходе по ссылке");
        driver.navigate().back();
    }

    @Test
    public void testContinueBtn() { //Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи», номер для теста 297777777)
        String serviceNumber = "297777777";
        String cost = "200";
        commissionPage.enterServiceNumber(serviceNumber, cost);
        Assert.assertTrue(commissionPage.isIframePresent());
        driver.navigate().refresh();
    }
}
