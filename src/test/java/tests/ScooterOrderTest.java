package tests;

import model.RentInformation;
import model.UserAndHisWishes;
import model.UserPersonalData;
import org.junit.Assert;
import org.junit.Test;
import pages.AboutRentPage;
import pages.ForWhomOrderPage;
import pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class ScooterOrderTest extends TestBase {

    // здесь лежат вторые тесты
    @Test
    public void checkOrdersForDifferentUsers(){
//   МОЖНО БЫЛО СДЕЛАТЬ НА 2 МЕТОДА , СДЕЛАЛ ТАК - ДЛЯ ТОГО, ЧТОБЫ НЕ ТРАТИТЬ ЛИШНИЕ РЕСУРСЫ - ГДЕ-ТО В ГРУППЕ ТГ ПИСАЛИ ОБ ЭТОМ
        List<UserAndHisWishes> users = new ArrayList<UserAndHisWishes>();
        UserAndHisWishes ahmadijon = new UserAndHisWishes(
                new UserPersonalData("Ахмадиджон", "Люцифербеков",
                        "Москвабад", "Орехово", "88005553535"),
                new RentInformation("25.05.2022", "трое суток", "чёрный"));
        UserAndHisWishes borec = new UserAndHisWishes(
                new UserPersonalData("Работайте", "Братья",
                        "Ленинград, ул.Петра Четвертого", "Люблино", "+7905553535"),
                new RentInformation("28.02.2021", "двое суток", "серый"));

        users.add(ahmadijon);
        users.add(borec);
        for (UserAndHisWishes user: users) {
            checkOrderingForUser(user);
        }
    }

    private void checkOrderingForUser(UserAndHisWishes user){

        MainPage mainPage = new MainPage(driver);
        mainPage.open(baseUrl);

        ForWhomOrderPage forWhomOrderPage = mainPage.clickOnOrderButton();
        forWhomOrderPage.fillAllFields(user.getUserPersonalData());

        AboutRentPage aboutRentPage = forWhomOrderPage.clickContinueButton();
        aboutRentPage.fillAllFields(user.getRentInformation()).clickButtonsToOrderScooter();


        String textAboutSuccessfulOrder = aboutRentPage.getMessageAboutSuccess();
//TODO библиотека AssertJ -> SoftAssertions
        Assert.assertTrue("Окно не содержит текст об успешном оформлении",
                textAboutSuccessfulOrder.contains("Заказ оформлен"));
        Assert.assertTrue("Кнопка, которая появляется после оформления статуса, не кликабельна",
                aboutRentPage.isCheckOrderStatusButtonClickable());
    }
}