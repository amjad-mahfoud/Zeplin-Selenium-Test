package com.amjad.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Predicate;

public class LoginPage extends BasePage {

    private By emailTextField = By.name("Handle");
    private By passwordTextField = By.name("Password");
    private By submitButton = By.xpath("/html/body/div/div[2]/div[2]/form/button");//By.className("loginFormButton");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public DashboardPage clickLogin(String username, String password) {
        this.waitAndReturnElement(emailTextField).sendKeys(username);
        this.waitAndReturnElement(passwordTextField).sendKeys(password);

        // wait until the button is clickable
        waitUntilClickable(submitButton).click();

        // wait until the page is loaded
        wait.until(ExpectedConditions.urlContains("projects"));
        return new DashboardPage(driver);
    }
}
