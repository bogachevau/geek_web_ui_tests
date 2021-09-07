package ru.geekbrains.homeWork7;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateContactFacePage extends BaseView {
    public CreateContactFacePage(WebDriver driver) {
        super(driver);
    }

    public static final String searchOrganizationXpathLocator = "//div[@class='select2-result-label']";
    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_lastName')]")
    public WebElement contactLastName;

    @Step("Ввести фамилию")
    public CreateContactFacePage fillContactLastName(String lastName) {
        contactLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_firstName')]")
    public WebElement contactFirstName;

    @Step("Ввести имя")
    public CreateContactFacePage fillContactFirstName(String firstName) {
        contactFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_middleName')]")
    public WebElement contactMiddleName;

    @Step("Ввести отчество")
    public CreateContactFacePage fillContactMiddleName(String middleName) {
        contactMiddleName.sendKeys(middleName);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement specifyOrganization;

    @Step("Клик на поле Укажите организацию")
    public CreateContactFacePage selectOrganization() {
        specifyOrganization.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement searchOrganization;

    @Step("Ввести часть имени организации")
    public CreateContactFacePage fillOrganization(String name) {
        searchOrganization.sendKeys(name);
        return this;
    }

    @FindBy(xpath = searchOrganizationXpathLocator)
    public List<WebElement> organizationVars;

    @Step("Выбрать название организации из списка")
    public CreateContactFacePage optionOrganization() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchOrganizationXpathLocator)));
        organizationVars.get(0).click();
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_contact_jobTitle')]")
    public WebElement contactJobTitle;

    @Step("Ввести должность")
    public CreateContactFacePage fillContactJobTitle(String jobTitle) {
        contactJobTitle.sendKeys(jobTitle);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id, 'crm_contact_status')]")
    public WebElement contactStatusSelect;

    @Step("Выбрать статус контактного лица")
    public CreateContactFacePage selectContactStatus(String contactStatus) {
        new Select(contactStatusSelect).selectByVisibleText(contactStatus);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = "//*[text()='Контактное лицо сохранено']")
    public WebElement contactSavedSuccessfullyElement;
}
