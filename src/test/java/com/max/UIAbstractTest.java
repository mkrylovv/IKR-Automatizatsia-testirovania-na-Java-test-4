package com.max;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class UIAbstractTest {

    static ChromeOptions options;
    static WebDriver driver;
    static WebDriverWait wait;

    LoginPage loginPage;


    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        options = new ChromeOptions();
        options.addArguments("--incognito");
        //options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://gb.ru/login");
        loginPage = new LoginPage(driver, wait);
    }

    @AfterEach
    void quit() {
        driver.quit();
    }
}
