package com.amjad.softwareTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SettingPageTest {

    public WebDriver driver;
    ConfigFileReader configFileReader;

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testLoading() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin();
        SettingsPage settingsPage = dashboardPage.getSetingsPage();
        assertTrue(settingsPage.getBodyText().contains("Projects"));
    }

    @Test
    public void fillAboutMeTest() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin();
        SettingsPage settingsPage = dashboardPage.getSetingsPage();
        settingsPage.fillWhatIdoTextArea("Software Testing", "User");
        System.out.println(settingsPage.getUodateStatues());
        assertTrue(settingsPage.getUodateStatues().contains("Updated"));
    }

    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
