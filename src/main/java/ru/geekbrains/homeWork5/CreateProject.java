package ru.geekbrains.homeWork5;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.List;

public class CreateProject {
    private static WebDriver driver;
    private static WebDriverWait webDriverWait;
    private static Actions actions;

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.name("_username")).sendKeys("Applanatest1");
        driver.findElement(By.name("_password")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }

    public static void createProjectToCrm() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebElement projectElement = driver.findElement(By.xpath("//a/span[text()='Проекты']"));
        actions.moveToElement(projectElement).perform();
        driver.findElement(By.xpath("//li[@data-route='crm_project_index']/a")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Создать проект']")));
        driver.findElement(By.xpath("//a[@title='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.name("crm_project[name]")));
        driver.findElement(By.name("crm_project[name]")).sendKeys("Selenium_test_java");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();

        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("test");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='select2-result-label']")));
        List<WebElement> organizationVars = Collections.singletonList(driver.findElement(
                By.xpath("//div[@class='select2-result-label']")));
        organizationVars.get(0).click();

        //webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[text()='«Все организации»']")));
        //driver.findElement(By.xpath("//li/div[text()='«Все организации»']")).click();

        Select projectPriority = new Select(driver.
                findElement(By.xpath("//select[contains(@id,'crm_project_priority')]")));
        projectPriority.selectByVisibleText("Низкий");

        Select projectFinanceSource = new Select(driver.findElement(
                By.xpath("//select[contains(@id,'crm_project_financeSource')]")));
        projectFinanceSource.selectByVisibleText("Внутреннее");

        Select projectBusinessUnit = new Select(driver.findElement(
                By.xpath("//select[contains(@id,'crm_project_businessUnit')]")));
        projectBusinessUnit.selectByVisibleText("Research & Development");

        Select projectCurator = new Select(driver.findElement(
                By.xpath("//select[contains(@id,'crm_project_curator')]")));
        projectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");

        Select projectRp = new Select(driver.findElement(
                By.xpath("//select[contains(@id,'crm_project_rp')]")));
        projectRp.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select projectAdministrator = new Select(driver.findElement(
                By.xpath("//select[contains(@id,'crm_project_administrator')]")));
        projectAdministrator.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        Select projectManager = new Select(driver.findElement(
                By.xpath("//select[contains(@id, 'crm_project_manager')]")));
        projectManager.selectByVisibleText("Applanatest1 Applanatest1 Applanatest1");

        webDriverWait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@id, 's2id_crm_project_contactMain')]/a")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[@class='select2-container select2']")));

        driver.findElement(By.xpath("//div[contains(@id, 's2id_crm_project_contactMain')]/a")).click();
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Ferdinand");
        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys(Keys.ENTER);

        /*driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_planning')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(
                By.xpath("//iframe[contains(@id, 'crm_project_requirementsManagement')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_development')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test");
        driver.switchTo().defaultContent();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id, 'crm_project_testing')]")));
        driver.findElement(By.xpath("//body")).sendKeys("test");
        driver.switchTo().defaultContent();*/

        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_configManagement')]")).
                sendKeys("TestTest");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
    }
}
