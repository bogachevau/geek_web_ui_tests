package ru.geekbrains.homeWork7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactFaceAllPage extends BaseView {
    public ContactFaceAllPage(WebDriver driver) {
        super(driver);
    }

    public static final String createContactXpathLocator = "//a[@title='Создать контактное лицо']";

    @FindBy(xpath = createContactXpathLocator)
    public WebElement createContactButton;

    @Step("Создать новое контактное лицо")
    public CreateContactFacePage createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateContactFacePage.saveAndCloseButtonXpathLocator)));
        return new CreateContactFacePage(driver);
    }
}
