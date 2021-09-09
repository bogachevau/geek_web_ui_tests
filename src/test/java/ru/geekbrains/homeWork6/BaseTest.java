package ru.geekbrains.homeWork6;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.homeWork7.CustomLogger;

import java.util.Iterator;

public class BaseTest {
    EventFiringWebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new CustomLogger());
        webDriverWait = new WebDriverWait(driver, 15);
    }

    @AfterEach
    void tearDown() {
        LogEntries browserConsoleLog = driver.manage().logs().get(LogType.BROWSER);
        Iterator<LogEntry> logEntryIterator = browserConsoleLog.iterator();

        while (logEntryIterator.hasNext()) {
            Allure.addAttachment("Элемент лога браузера", logEntryIterator.next().getMessage());
        }

        driver.quit();
    }
}
