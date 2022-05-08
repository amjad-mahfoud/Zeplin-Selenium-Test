package com.amjad.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {

    private By menuButton = By.xpath("/html/body/header/div[3]/div/button");
    private By logoutButton = By.xpath("/html/body/div[5]/div/div/div/section[1]/div/div[6]");

    private By settingsDropDown = By.xpath("/html/body/header/div[3]/div/button");
    By profileLink = By.xpath("/html/body/div[5]/div/div/div/section[1]/div/a");
    private By projectTile = By.xpath("/html/body/main/div/div[2]/div[4]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/a");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage logout() {
        this.waitAndReturnElement(menuButton).click();
        this.waitAndReturnElement(logoutButton).click();
        wait.until(ExpectedConditions.urlContains("login"));
        return new LoginPage(driver);
    }

    public SettingsPage getSetingsPage(){
        this.waitAndReturnElement(settingsDropDown).click();
        this.waitAndReturnElement(profileLink).click();
        wait.until(ExpectedConditions.urlContains("profile"));
        return new SettingsPage(driver);
    }

    public ProjectPage getFirstProject() {
        this.waitAndReturnElement(projectTile).click();
        wait.until(ExpectedConditions.urlContains("project"));
        return new ProjectPage(this.driver);
    }
}
