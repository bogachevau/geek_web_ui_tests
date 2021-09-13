package ru.geekbrains.homeWork6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.homeWork6.diaryForTestCase.CreateNewPostDiary;
import ru.geekbrains.homeWork6.diaryForTestCase.LoginPageDiary;
import ru.geekbrains.homeWork6.diaryForTestCase.MainPageDiary;

public class TestDiaryRuPageObject extends BaseTest {
    @Story("Тестирование Diary.ru")
    @Test
    @Description("Тест логина и создания новой записи")
    void loginInDiaryRuCreatePostTest() throws InterruptedException {
        driver.get("https://diary.ru/");

        new LoginPageDiary(driver).loginToDiaryWithCookie();

        new MainPageDiary(driver).newPostCreate();

        new CreateNewPostDiary(driver)
                .fillPostTitle("New Post in diary")
                .fillTextMessage("Hello world!!!")
                .checkboxClosedRecord()
                .radioClosedForAll()
                .checkboxAdditionalParameters()
                .checkboxNoSendPost()
                .buttonToPublish.click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//a[text()='New Post in diary']")));

        String recordIsPublished = driver.findElement(By.xpath("//a[text()='New Post in diary']")).getText();
        Assertions.assertEquals("New Post in diary", recordIsPublished);
    }
}
