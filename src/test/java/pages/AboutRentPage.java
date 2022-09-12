package pages;

import model.RentInformation;
import model.UserPersonalData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutRentPage extends BasePage{

    //     локатор для надписи на форме
    private By headingOfOrderForm = By.xpath("//div[text()='Про аренду']");
    //     локатор для Дата
    private By dateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //     локатор для на сколько заказ
    private By timeField = By.xpath("//div[@aria-haspopup='listbox']");
    //     локатор для опции
    private String timeOptionLocator = "//div[@class='Dropdown-option' and text()='%s']";
    //     локатор для черного цвета самоката
    private By blackColorCheckbox = By.xpath("//input[@id='black']");
    //     локатор для серого цвета самоката
    private By greyColorCheckbox = By.xpath("//input[@id='grey']");
    //     локатор для кнопки Заказать
    private By continueOrderButton = By.xpath("//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");
    //     локатор для всплывашки Хотите оформить заказ
    private By wannaOrderScooterForm = By.xpath("//div[contains(@class,'Order_Modal_')]");
    //     локатор для кнопки Посмотреть статус
    private By checkOrderStatusButton = By.xpath("//button[text()='Посмотреть статус']");


    public AboutRentPage(WebDriver driver) {
        super(driver);
        Assert.assertTrue("Не отображается заголовок - проверить, открылась ли форма",
                driver.findElement(headingOfOrderForm).isDisplayed());
    }

    public AboutRentPage fillAllFields(RentInformation info){
        fillDateField(info.getDate());
        fillTimeField(info.getTime());
        fillColorField(info.getColor());
        return this;
    }

    public AboutRentPage fillDateField(String date){
        WebElement dateForOrder = driver.findElement(dateField);
        dateForOrder.clear();
        dateForOrder.sendKeys(date);
        dateForOrder.sendKeys(Keys.ENTER);
        return this;
    }

    public AboutRentPage fillTimeField(String time){
        driver.findElement(timeField).click();
        driver.findElement(By.xpath(String.format(timeOptionLocator, time))).click();
        return this;
    }

    public AboutRentPage fillColorField(String color){
        if(color.equals("чёрный")){
            driver.findElement(blackColorCheckbox).click();
        }
        else if(color.equals("серый")){
            driver.findElement(greyColorCheckbox).click();
        }
        else {
            throw new AssertionError("ЦВЕТ НЕ ТОТ");
        }
        return this;
    }

    public void clickButtonsToOrderScooter(){
        driver.findElement(continueOrderButton).click();
        Assert.assertTrue("Не отображается форма с кнопками оформления заказа",
                driver.findElement(wannaOrderScooterForm).isDisplayed());
        driver.findElement(By.xpath("//button[text()='Да']")).click();
    }

    public String getMessageAboutSuccess(){
        Assert.assertTrue("Не отображается форма итоговая",
                driver.findElement(By.xpath("//div[contains(@class,'Order_ModalHeader')]")).isDisplayed());
        return driver.findElement(By.xpath("//div[contains(@class,'Order_ModalHeader')]")).getText();
    }

    public boolean isCheckOrderStatusButtonClickable(){
        WebElement button = driver.findElement(checkOrderStatusButton);
        return button.isDisplayed() && button.isEnabled();
    }

}
