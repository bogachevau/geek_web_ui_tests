package ru.geekbrains.homeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectAllPage extends BaseView {
    public ProjectAllPage(WebDriver driver) {
        super(driver);
    }

    public static final String createProjectXpathLocator = "//a[@title='Создать проект']";

    @FindBy(xpath = createProjectXpathLocator)
    public WebElement createProjectButton;

    public CreateProjectPage createProject() {
        createProjectButton.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(CreateProjectPage.saveAndCloseButtonXpathLocator)));
        return new CreateProjectPage(driver);
    }
}
