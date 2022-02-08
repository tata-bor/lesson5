package com.geekbrains.homework6;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    /*
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']")));
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']")).sendKeys("bakexol605@dkb3.com");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']")));
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']")).sendKeys("ЕИ*01В");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']")).click();
     */

    @FindBy (xpath = "//form[@class='authPopup-form tokenized']/input[@name='username']")
    public WebElement loginInput;

    @FindBy (xpath = "//form[@class='authPopup-form tokenized']/input[@name='password']")
    public WebElement passwordInput;

    @FindBy (xpath = "//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']")
    public WebElement loginButton;

    @Step("Заполнить поле логина")
    public LoginPage fillLogin(String login) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']")));
        loginInput.sendKeys(login);
        return this;
    }

    @Step("Заполнить поле пароля")
    public LoginPage fillPassword(String password) {
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']")));
        passwordInput.sendKeys(password);
        return this;
    }


    @Step("Клик на кнопку логина")
    public void clickLoginButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
