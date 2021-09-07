package ru.geekbrains.homeWork7;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageCrmGeekBrains extends BaseView {

    public LoginPageCrmGeekBrains(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "prependedInput")
    public WebElement inputLogin;

    @FindBy(id = "prependedInput2")
    public WebElement inputPassword;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @Step("Заполнить поле логина")
    public LoginPageCrmGeekBrains fillInputLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPageCrmGeekBrains fillInputPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Кликнуть на кнопку Войти")
    public MainPage clickLoginButton() {
        loginButton.click();
        return new MainPage(driver);
    }

    public void login(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        loginButton.click();
    }
}
