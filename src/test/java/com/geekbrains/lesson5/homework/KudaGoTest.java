package com.geekbrains.lesson5.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//КЕЙС: Пользователь из Краснодара хочет посмотреть событие в Новосибирске в четверг 3 февраля.
public class KudaGoTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void init()
    {
        driver = new ChromeDriver();
        driver.get("https://krd.kudago.com");
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    void hoverMenuTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='userzone']/a[1]/span")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']")));
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='username']")).sendKeys("bakexol605@dkb3.com");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']")));
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/input[@name='password']")).sendKeys("ЕИ*01В");
        driver.findElement(By.xpath("//form[@class='authPopup-form tokenized']/button[@class='authPopup-button button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='location-switcher']")).click();
        driver.findElement(By.xpath("//a[@id='location-nsk']/span[.='в Новосибирске']")).click();
        driver.findElement(By.xpath("//a[@title='Мероприятия и события в Новосибирске. Куда сходить 11 февраля 2022']")).click();
        driver.findElement(By.xpath("//a[@title='Бесплатные онлайн-уроки по английскому языку в школах Wall Street English']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("obuchenie-besplatnyie-onlajn-uroki-po-anglijskomu"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}