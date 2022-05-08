package com.amjad.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage{

    By whatIdoTextField = By.xpath("/html/body/main/div[1]/div[2]/div[2]/div/div[1]/div/div[4]/div[2]/div[1]/textarea");
    By submitButton = By.xpath("/html/body/main/div[1]/div[2]/div[2]/div/div[1]/div/button");
    By updatedMessage = By.xpath("/html/body/main/div[1]/div[2]/div[2]/div/div[1]/div/div[4]/div[2]/div[2]/p");
    By fullNameField = By.xpath("/html/body/main/div[1]/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/div/input");
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    public void fillWhatIdoTextArea(String value, String fullName){
        this.waitAndReturnElement(fullNameField).clear();
        this.waitAndReturnElement(fullNameField).sendKeys(fullName);
        this.waitAndReturnElement(whatIdoTextField).clear();
        this.waitAndReturnElement(whatIdoTextField).sendKeys(value);
        // wait until the button is clickable
        this.waitUntilClickable(submitButton).click();
    }

    public String getUodateStatues() {
        return this.waitAndReturnElement(updatedMessage).getText();
    }
}
