package com.geekbrains.lesson5.homework.homework6;


import com.geekbrains.homework6.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KudaGoPageObjectTest {
    WebDriver driver;
    private final static String KUDAGO_URL = "https://krd.kudago.com";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void init()
    {
        driver = new ChromeDriver();
        driver.get(KUDAGO_URL);
    }

    @Test
    void Test () {
        driver.findElement(By.xpath("//*[@id='userzone']/a[1]/span")).click();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLogin("bakexol605@dkb3.com");
        loginPage.fillPassword("ЕИ*01В");
        loginPage.clickLoginButton();

    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
