package ru.geekbrains.homeWork3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateContactFace {
    public static WebDriver driver;

    public static void loginToCrm() {
        driver.get("https://crm.geekbrains.space/user/login");
        driver.findElement(By.name("_username")).sendKeys("Applanatest1");
        driver.findElement(By.name("_password")).sendKeys("Student2020!");
        driver.findElement(By.xpath("//button")).click();
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginToCrm();

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        Actions actions = new Actions(driver);
        WebElement counterparties = driver.findElement(By.xpath("//a/span[text()='Контрагенты']"));
        actions.moveToElement(counterparties).perform();

        driver.findElement(By.xpath("//a/span[text()='Контактные лица']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Создать контактное лицо']")));

        driver.findElement(By.xpath("//a[@title='Создать контактное лицо']")).click();

        webDriverWait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_lastName')]")).sendKeys("Ivanov");
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_firstName')]")).sendKeys("Ivan");
        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_middleName')]")).
                sendKeys("Ivanovitch");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li/div[text()='«Все организации»']")));
        driver.findElement(By.xpath("//li/div[text()='«Все организации»']")).click();

        driver.findElement(By.xpath("//input[contains(@id, 'crm_contact_jobTitle')]")).sendKeys("Инженер");

        Select contactStatus = new Select(driver.findElement(By.xpath("//select[contains(@id, 'crm_contact_status')]")));
        contactStatus.selectByVisibleText("Активный");

        driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);
    }
}
