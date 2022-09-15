package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    //     локатор для стрелочки какого-либо вопроса
    private String questionArrow = ("//div[@class='accordion__button' and text()='%s']");
    //     локатор для ответа на какой-либо вопрос
    private By answerPanel = By.xpath(".//ancestor::div[@data-accordion-component='AccordionItem']/div[@data-accordion-component='AccordionItemPanel']");
    //     локатор для верхней кнопки Заказать
    private By upperOrderButton = By.xpath("//div[contains(@class,'Header_Nav')]/button[text()='Заказать']");
    //     локатор для нижней кнопки Заказать
    private By lowerOrderButton = By.xpath("//div[contains(@class,'Home_FinishButton')]/button[text()='Заказать']");
    //     локатор для УНИЧТОЖЕНИЯ КУК КАК БУКАШЕК
    private By accessCookieButton = By.id("rcc-confirm-button");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void open(String baseUrl) {
        driver.get(baseUrl);
        try {
            driver.findElement(accessCookieButton).click();
        } catch (NoSuchElementException e) {
            System.out.println("Кнопки принятия куки нет");
        }
    }

    public String clickOnQuestionAndGiveAnswer(String question) {
        WebElement questionElem = driver.findElement(By.xpath(String.format(questionArrow, question)));
        questionElem.sendKeys(Keys.END);
        questionElem.click();
        WebElement answer = questionElem.findElement(answerPanel);
        // Ожидание, что кнопка станет кликабельной; ожидание не больше 3 секунд
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOf(answer));
        return answer.getText();
    }

    public ForWhomOrderPage clickOnOrderButton(boolean isOrderButtonOnHeader) {
        if (isOrderButtonOnHeader) {
            driver.findElement(upperOrderButton).click();
        } else {
            WebElement lowerButton = driver.findElement(lowerOrderButton);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lowerButton);
            lowerButton.click();
        }
        return new ForWhomOrderPage(driver);
    }

}