package ru.geekbrains.homeWork5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDiaryRu {
    static WebDriver driver;
    WebDriverWait webDriverWait;

    private static void loginToDiaryWithCookie() {
        driver.get("https://diary.ru");
        Cookie authCookie = new Cookie("_identity_", "e7005cd0334f09765a69652717fd3fb4de9473109469e5d7d7d50f826918bb9fa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3552561%2C%22sv_mH4Qz4D1XXFFEFAu7v-NfAV40w8Tq%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();
    }

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 15);
        loginToDiaryWithCookie();
    }

    @Test
    void testNewPostDiary() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Новая запись']")));
        driver.findElement(By.xpath("//a[@title='Новая запись']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("postTitle")));
        driver.findElement(By.id("postTitle")).sendKeys("Запись от 01.09.2021");

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.xpath("//body")).sendKeys("Моя первая запись!");
        driver.switchTo().defaultContent();

        driver.findElement(By.id("closedPost")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='closeaccessmode7']")));
        driver.findElement(By.xpath("//input[@id='closeaccessmode7']")).click();

        driver.findElement(By.id("addoptionsCHECK")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("NoSendPost")));
        driver.findElement(By.id("NoSendPost")).click();
        driver.findElement(By.xpath("//input[@value='Опубликовать']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[text()='Запись от 01.09.2021']")));

        String recordIsPublished = driver.findElement(By.xpath("//a[text()='Запись от 01.09.2021']")).getText();
        Assertions.assertEquals("Запись от 01.09.2021", recordIsPublished);
    }

    @Test
    void testDiaryLeaveComment() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Мой дневник']")));
        driver.findElement(By.xpath("//a[@title='Мой дневник']")).click();

        driver.findElement(By.xpath("//a[text()='Запись от 02.09.2021']")).click();
        driver.findElement(By.xpath("//span[text()='Расширенная форма']")).click();

        Select extendedFormComment = new Select(driver.findElement(By.xpath("//select[@id='commentform-write_from']")));
        extendedFormComment.selectByVisibleText("От себя (test01092021)");

        driver.switchTo().frame(driver.findElement(By.id("text_ifr")));
        driver.findElement(By.xpath("//body")).sendKeys("Тестовый коммент");
        driver.switchTo().defaultContent();

        driver.findElement(By.id("btSubmit")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(text(), 'Тестовый коммент')]")));

        String textComment = driver.findElement(By.xpath("//div[contains(text(), 'Тестовый коммент')]")).getText();
        Assertions.assertEquals("Тестовый коммент", textComment);
    }

    @AfterEach
    void tearDown(){
        driver.quit();
    }
}
