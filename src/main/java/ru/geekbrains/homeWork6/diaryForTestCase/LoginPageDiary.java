package ru.geekbrains.homeWork6.diaryForTestCase;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import ru.geekbrains.homeWork6.BaseView;

public class LoginPageDiary extends BaseView {

    public LoginPageDiary(WebDriver driver) {
        super(driver);
    }

    public LoginPageDiary loginToDiaryWithCookie() {
        driver.get("https://diary.ru");
        Cookie authCookie = new Cookie("_identity_", "e7005cd0334f09765a69652717fd3fb4de9473109469e5d7d7d50f826918bb9fa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3552561%2C%22sv_mH4Qz4D1XXFFEFAu7v-NfAV40w8Tq%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();
        return this;
    }
}
