package com.amjad.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    private By footerBy = By.tagName("footer");
    private By getStartedButton = By.xpath("//*[@id=\"block-a21b485c9d05\"]/div[1]/div[2]/a");
    private By alreadyHaveAccountButton = By.xpath("//*[@id=\"signupPageContainer\"]/div/div[2]/div[3]/span/a");
    private By loginButton = By.xpath("/html/body/header/div[2]/nav/ul/li[5]/a");

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://zeplin.io");
    }

    public String getFooterText() {
        return this.waitAndReturnElement(footerBy).getText();
    }

    public LoginPage getLoginPage() {
        this.waitAndReturnElement(loginButton).click();
        return new LoginPage(this.driver);
    }
}
