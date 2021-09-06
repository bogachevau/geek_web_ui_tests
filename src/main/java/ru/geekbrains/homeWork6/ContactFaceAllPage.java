package ru.geekbrains.homeWork6;

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

    public CreateContactFacePage createContact() {
        createContactButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateContactFacePage.saveAndCloseButtonXpathLocator)));
        return new CreateContactFacePage(driver);
    }
}
