package com.amjad.softwareTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginPageTest {
    public WebDriver driver;
    private String username = "xehax63274@bamibi.com";
    private String password = "9FwxJynb#A2.$Y.";

    @BeforeAll
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginPage() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        assertTrue(loginPage.getBodyText().contains("You can login to access your workspace."));
    }

    @Test
    public void testLoginAction() {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin(username, password);
        assertTrue(dashboardPage.getBodyText().contains("Workspace"));
    }

    @Test
    public void testLogoutAction() throws InterruptedException {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin(username, password);
        assertTrue(dashboardPage.getBodyText().contains("Workspace"));
        loginPage = dashboardPage.logout();
        assertTrue(loginPage.getBodyText().contains("Login"));
    }
}
