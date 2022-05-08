package com.amjad.softwareTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProjectPageTest {
    public WebDriver driver;
    ConfigFileReader configFileReader;

    @BeforeAll
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
//        prefs.put("download.default_directory", "src//downloads");
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void downloadMultipleFiles() throws InterruptedException {
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin();
        ProjectPage projectPage = dashboardPage.getFirstProject();
        System.out.println(projectPage.getBodyText());
        List<WebElement> btns = projectPage.getAllButtons();
        for (WebElement btn : btns) {
            btn.click();
            projectPage.clickDownloadButton();
        }
    }

//    @AfterAll
//    public void close() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
