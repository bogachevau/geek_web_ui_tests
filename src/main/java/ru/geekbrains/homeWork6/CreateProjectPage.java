package ru.geekbrains.homeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CreateProjectPage extends BaseView {
    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    public static final String searchOrganizationXpathLocator = "//div[@class='select2-result-label']";
    public static final String saveAndCloseButtonXpathLocator = "//button[contains(text(), 'Сохранить и закрыть')]";

    @FindBy(name = "crm_project[name]")
    public WebElement nameProject;

    public CreateProjectPage fillName(String name) {
        nameProject.sendKeys(name);
        return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']")
    public WebElement specifyOrganization;

    public CreateProjectPage selectOrganization() {
        specifyOrganization.click();
        return this;
    }

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement searchOrganization;

    public CreateProjectPage fillOrganization(String name) {
        searchOrganization.sendKeys(name);
        return this;
    }

    @FindBy(xpath = searchOrganizationXpathLocator)
    public List<WebElement> organizationVars;

    public CreateProjectPage optionOrganization() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchOrganizationXpathLocator)));
        organizationVars.get(0).click();
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_priority')]")
    public WebElement projectPrioritySelect;

    public CreateProjectPage selectProjectPriority(String projectPriority) {
        new Select(projectPrioritySelect).selectByVisibleText(projectPriority);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_financeSource')]")
    public WebElement projectFinanceSourceSelect;

    public CreateProjectPage selectProjectFinanceSource(String projectFinanceSource) {
        new Select(projectFinanceSourceSelect).selectByVisibleText(projectFinanceSource);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_businessUnit')]")
    public WebElement projectBusinessUnitSelect;

    public CreateProjectPage selectProjectBusinessUnit(String projectBusinessUnit) {
        new Select(projectBusinessUnitSelect).selectByVisibleText(projectBusinessUnit);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_curator')]")
    public WebElement projectCuratorSelect;

    public CreateProjectPage selectProjectCurator(String projectCurator) {
        new Select(projectCuratorSelect).selectByVisibleText(projectCurator);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_rp')]")
    public WebElement projectRpSelect;

    public CreateProjectPage selectProjectRp(String projectRp) {
        new Select(projectRpSelect).selectByVisibleText(projectRp);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id,'crm_project_administrator')]")
    public WebElement projectAdministratorSelect;

    public CreateProjectPage selectProjectAdministrator(String projectAdministrator) {
        new Select(projectAdministratorSelect).selectByVisibleText(projectAdministrator);
        return this;
    }

    @FindBy(xpath = "//select[contains(@id, 'crm_project_manager')]")
    public WebElement projectManagerSelect;

    public CreateProjectPage selectProjectManager(String projectManager) {
        new Select(projectManagerSelect).selectByVisibleText(projectManager);
        return this;
    }

    @FindBy(xpath = "//input[contains(@id, 'crm_project_configManagement')]")
    public WebElement configManagement;

    public CreateProjectPage fillConfigManagement(String configName) {
        configManagement.sendKeys(configName);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(), 'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = "//span[@class='validation-failed']")
    public WebElement validationFailed;
}
