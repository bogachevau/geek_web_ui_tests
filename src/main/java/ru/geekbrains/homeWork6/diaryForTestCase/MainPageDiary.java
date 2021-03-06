package ru.geekbrains.homeWork6.diaryForTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.homeWork6.BaseView;

public class MainPageDiary extends BaseView {
    public MainPageDiary(WebDriver driver) {
        super(driver);
    }

    public static final String createNewPost = "//a[@title='Новая запись']";

    @FindBy(xpath = createNewPost)
    public WebElement newPost;

    public CreateNewPostDiary newPostCreate() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(createNewPost)));
        newPost.click();
        return new CreateNewPostDiary(driver);
    }

}
