package ru.geekbrains.homeWork7;

import org.openqa.selenium.WebDriver;

public class MainPage extends BaseView {
    public NavigationMenu navigationMenu;

    public MainPage(WebDriver driver) {
        super(driver);
        navigationMenu = new NavigationMenu(driver);
    }
}
