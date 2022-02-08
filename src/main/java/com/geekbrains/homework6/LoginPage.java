package com.geekbrains.homework6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    public LoginPage (WebDriver driver) {
        this.driver  = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    @FindBy (xpath = "//form[@class='authPopup-form tokenized']/input[@name='username']")
    public WebElement loginInput;

    @FindBy (xpath = "//form[@class='authPopup-form tokenized']/input[@name='password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']")
    public WebElement loginButton;
}
