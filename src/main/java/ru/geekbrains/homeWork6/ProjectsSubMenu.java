package ru.geekbrains.homeWork6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectsSubMenu extends BaseView {

    public ProjectsSubMenu(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()='Все проекты']")
    public WebElement projectsAllMenuItem;

    public void goToProjectsAllPage() {
        projectsAllMenuItem.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath(ProjectAllPage.createProjectXpathLocator)));
    }
}
