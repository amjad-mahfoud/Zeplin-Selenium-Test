package com.amjad.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private By menuButton = By.xpath("/html/body/header/div[3]/div/button");
    private By logoutButton = By.xpath("/html/body/div[5]/div/div/div/section[1]/div/div[6]");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        this.waitAndReturnElement(menuButton).click();
        this.waitAndReturnElement(logoutButton).click();
        wait.until(ExpectedConditions.urlContains("login"));
        return new LoginPage(driver);
    }
}
