package ru.geekbrains.homeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CounterpartiesSubMenu extends BaseView {

    public CounterpartiesSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Контактные лица']")
    public WebElement counterpartiesMenuItem;

    public void goToContactAllPage() {
        counterpartiesMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(ContactFaceAllPage.createContactXpathLocator)));
    }
}
