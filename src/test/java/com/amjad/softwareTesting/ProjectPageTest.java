package com.amjad.softwareTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProjectPageTest {
    public WebDriver driver;

    private boolean downloaded = false;

    @BeforeAll
    public void setup() {
        var options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", "src//downloads"); // Bypass default download directory in Chrome
        prefs.put("safebrowsing.enabled", "false"); // Bypass warning message, keep file anyway (for .exe, .jar, etc.)
        prefs.put("profile.default_content_setting_values.automatic_downloads", 1);
        options.setExperimentalOption("prefs", prefs);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void downloadMultipleFiles() throws InterruptedException {
        var mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboardPage = loginPage.clickLogin();
        ProjectPage projectPage = dashboardPage.getFirstProject();
        System.out.println(projectPage.getBodyText());
        List<WebElement> btns = projectPage.getAllButtons();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (WebElement btn : btns) {
            btn.click();
            projectPage.clickDownloadButton();
        }

//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        System.out.println(jse.executeScript("browserstack_executor: {\"action\": \"fileExists\", \"arguments\": {\"fileName\": \"9.zip\"}}"));
    }

    @AfterAll
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
