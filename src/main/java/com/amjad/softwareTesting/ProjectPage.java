package com.amjad.softwareTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProjectPage extends BasePage{

    ///html/body/main/div/div/div[2]/div/div[3]/div[2]/div/div[1]/div/div/div[1]/div[2]/button[3]
    private By allDropDownButtons = By.xpath("//Button[@class = 'sectionOptionsButton']");

    private By downloadButton = By.xpath("//Button[@class = 'menuitem noSelect ellipsis']");
    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllButtons(){
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(allDropDownButtons));
        return this.driver.findElements(allDropDownButtons);
    }

    public void clickDownloadButton() {
        WebElement b = this.waitAndReturnElement(By.xpath("//div[@class ='contextMenu sectionMenu']//Button[@class='menuitem noSelect ellipsis'][4]"));
        b.click();
    }
}
