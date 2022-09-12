package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;

public class ImportantQuestionsTest extends TestBase {

    // здесь лежат первые тесты
    @Test
    public void checkAnswerAboutPrice(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Сколько это стоит? И как оплатить?");
        Assert.assertEquals("Неправильный ответ на вопрос о цене",
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",answer);
    }

    @Test
    public void checkAnswerAboutQuantity(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Хочу сразу несколько самокатов! Так можно?");
        Assert.assertEquals("Неправильный ответ на вопрос о кол-ве",
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",answer);
    }

    @Test
    public void checkAnswerAboutTime(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Как рассчитывается время аренды?");
        Assert.assertEquals("Неправильный ответ на вопрос о времени",
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
                answer);
    }

    @Test
    public void checkAnswerAboutToday(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Можно ли заказать самокат прямо на сегодня?");
        Assert.assertEquals("Неправильный ответ на вопрос об аренде на сегодня",
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",answer);
    }

    @Test
    public void checkAnswerAboutNotStandartSituations(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Можно ли продлить заказ или вернуть самокат раньше?");
        Assert.assertEquals("Неправильный ответ на вопрос о разных ситуациях с заказом",
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
                answer);
    }

    @Test
    public void checkAnswerAboutScooterCharging(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Вы привозите зарядку вместе с самокатом?");
        Assert.assertEquals("Неправильный ответ на вопрос о зарядке для самоката",
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
                answer);
    }

    @Test
    public void checkAnswerAboutOrderCancelling(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Можно ли отменить заказ?");
        Assert.assertEquals("Неправильный ответ на вопрос об отмене заказа",
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
                answer);
    }

    @Test
    public void checkAnswerAboutDistantDelivery(){
        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);
        String answer = mainPage.clickOnQuestionAndGiveAnswer("Я жизу за МКАДом, привезёте?");
        Assert.assertEquals("Неправильный ответ на вопрос о доставке за МКАД",
                "Да, обязательно. Всем самокатов! И Москве, и Московской области.",
                answer);
    }
}