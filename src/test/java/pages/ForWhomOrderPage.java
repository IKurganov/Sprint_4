package pages;

import model.UserPersonalData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.desktop.AboutEvent;

public class ForWhomOrderPage extends BasePage {

    //     локатор для надписи на форме
    private By headingOfOrderForm = By.xpath("//div[text()='Для кого самокат']");
    //     локатор для поля Имя
    private By nameField = By.xpath("//input[@placeholder='* Имя']");
    //     локатор для Фамилия
    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    //     локатор для Адрес
    private By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //     локатор для Станция метро
    private By stationField = By.xpath("//input[@placeholder='* Станция метро']");
    //     локатор для опции Станции метро
    private String stationFieldOption = "//ul[@class='select-search__options']//div[text()='%s']/parent::button";
    //     локатор для телефон
    private By phoneField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //     локатор для кнопки Далее
    private By continueButton = By.xpath("//button[text()='Далее']");

    public ForWhomOrderPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue("Не отображается заголовок - проверить, открылась ли форма",
                driver.findElement(headingOfOrderForm).isDisplayed());
    }

    public ForWhomOrderPage fillAllFields(UserPersonalData info){
        fillNameField(info.getName());
        fillSurnameField(info.getSurname());
        fillAddressField(info.getAddress());
        fillStationField(info.getStation());
        fillPhoneField(info.getPhone());
        return this;
    }

    public ForWhomOrderPage fillNameField(String name){
        WebElement nameForOrder = driver.findElement(nameField);
        nameForOrder.clear();
        nameForOrder.sendKeys(name);
        return this;
    }

    public ForWhomOrderPage fillSurnameField(String surname){
        WebElement surnameForOrder = driver.findElement(surnameField);
        surnameForOrder.clear();
        surnameForOrder.sendKeys(surname);
        return this;
    }

    public ForWhomOrderPage fillAddressField(String address){
        WebElement addressForOrder = driver.findElement(addressField);
        addressForOrder.clear();
        addressForOrder.sendKeys(address);
        return this;
    }

    public ForWhomOrderPage fillStationField(String station){
        driver.findElement(stationField).click();
        WebElement stationForOrder = driver.findElement(By.xpath(String.format(stationFieldOption, station)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", stationForOrder);
        stationForOrder.click();
        return this;
    }

    public ForWhomOrderPage fillPhoneField(String phone){
        WebElement phoneForOrder = driver.findElement(phoneField);
        phoneForOrder.clear();
        phoneForOrder.sendKeys(phone);
        return this;
    }


    public AboutRentPage clickContinueButton(){
        driver.findElement(continueButton).click();
        return new AboutRentPage(driver);
    }
}
