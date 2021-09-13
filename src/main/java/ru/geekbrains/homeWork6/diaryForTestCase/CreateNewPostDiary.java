package ru.geekbrains.homeWork6.diaryForTestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.homeWork6.BaseView;

public class CreateNewPostDiary extends BaseView {
    public CreateNewPostDiary(WebDriver driver) {
        super(driver);
    }

    public static final String POST_TITLE_ID = "postTitle";
    public static final String CLOSE_ACCESS_MODE_XPATH = "//input[@id='closeaccessmode7']";
    public static final String NO_SEND_POST_ID = "NoSendPost";

    @FindBy(id = POST_TITLE_ID)
    public WebElement titlePost;

    public CreateNewPostDiary fillPostTitle(String postName) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(POST_TITLE_ID)));
        titlePost.sendKeys(postName);
        return this;
    }

    @FindBy(xpath = "//textarea[@id='message']")
    public WebElement textMessage;
    public CreateNewPostDiary fillTextMessage(String text) {
        textMessage.sendKeys(text);
        return this;
    }

    @FindBy(id = "closedPost")
    public WebElement closedRecord;

    public CreateNewPostDiary checkboxClosedRecord() {
        closedRecord.click();
        return this;
    }

    @FindBy(xpath = CLOSE_ACCESS_MODE_XPATH)
    public WebElement closedForAll;

    public CreateNewPostDiary radioClosedForAll() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_ACCESS_MODE_XPATH)));
        closedForAll.click();
        return this;
    }

    @FindBy(id = "addoptionsCHECK")
    public WebElement additionalParameters;

    public CreateNewPostDiary checkboxAdditionalParameters() {
        additionalParameters.click();
        return this;
    }

    @FindBy(id = NO_SEND_POST_ID)
    public WebElement noSendPost;

    public CreateNewPostDiary checkboxNoSendPost() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id(NO_SEND_POST_ID)));
        noSendPost.click();
        return this;
    }

    @FindBy(xpath = "//input[@value='Опубликовать']")
    public WebElement buttonToPublish;
}
