package com.amjad.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By footerBy = By.tagName("footer");
    private By loginButton = By.xpath("/html/body/header/div[2]/nav/ul/li[5]/a");

    ConfigFileReader configFileReader = new ConfigFileReader();

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get(configFileReader.getApplicationUrl());
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public LoginPage getLoginPage() {
        this.waitAndReturnElement(loginButton).click();
        return new LoginPage(this.driver);
    }
}
