package ru.geekbrains.homeWork6;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

@Story("Тестирование CRM GeekBrains")
public class TestToCrmPageObject extends BaseTest{

    @Story("Создание проекта")
    @Test
    @Description("Тест логина и создания нового проекта")
    void loginInCrmAndCreateProjectPageObjectTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPageCrmGeekBrains(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Проекты");

        new ProjectsSubMenu(driver).goToProjectsAllPage();

        new ProjectAllPage(driver)
                .createProject()
                .fillName("Selenium_test_java")
                .selectOrganization()
                .fillOrganization("test")
                .optionOrganization()
                .selectProjectPriority("Низкий")
                .selectProjectFinanceSource("Внутреннее")
                .selectProjectBusinessUnit("Research & Development")
                .selectProjectCurator("Applanatest Applanatest Applanatest")
                .selectProjectRp("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectAdministrator("Applanatest1 Applanatest1 Applanatest1")
                .selectProjectManager("Applanatest1 Applanatest1 Applanatest1")
                .fillConfigManagement("TestTest")
                .buttonSaveAndClose.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Загрузка')]")));

        Assertions.assertEquals("Это значение уже используется.",
                new CreateProjectPage(driver).validationFailed.getText());
    }

    @Story("Создание контактного лица")
    @Test
    @Description("Тест логина и создания контактного лица")
    void loginInCrmAndCreateContactPageObjectTest() {
        driver.get("https://crm.geekbrains.space/");
        new LoginPageCrmGeekBrains(driver)
                .fillInputLogin("Applanatest1")
                .fillInputPassword("Student2020!")
                .clickLoginButton()
                .navigationMenu.openNavigationMenuItem("Контрагенты");

        new CounterpartiesSubMenu(driver).goToContactAllPage();

        new ContactFaceAllPage(driver)
                .createContact()
                .fillContactLastName("Petrov")
                .fillContactFirstName("Petr")
                .fillContactMiddleName("Petrovitch")
                .selectOrganization()
                .fillOrganization("test")
                .optionOrganization()
                .fillContactJobTitle("Engineer")
                .selectContactStatus("Активный")
                .buttonSaveAndClose.click();

        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(
                By.xpath("//div[contains(text(),'Загрузка')]")));

        assertThat(new CreateContactFacePage(driver).contactSavedSuccessfullyElement, isDisplayed());
    }
}
