package ru.geekbrains.homeWork6.diaryForTestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.homeWork6.BaseView;

public class CreateNewPostDiary extends BaseView {
    public CreateNewPostDiary(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postTitle")
    public WebElement titlePost;

    public CreateNewPostDiary fillPostTitle(String postName) {
        titlePost.sendKeys(postName);
        return this;
    }

}
