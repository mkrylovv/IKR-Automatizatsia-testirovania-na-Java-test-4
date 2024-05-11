package com.max;

import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class UITest extends UIAbstractTest {

    @Test
    void testGBNotEmailLogin() {

//        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys("login");
//        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/input")).sendKeys("password");
//        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();
//
//        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/ul")).isEmpty());

        loginPage.inputEmail("login");
        loginPage.inputPassword("password");
        loginPage.clickLoginButton();

        Assertions.assertFalse(loginPage.getNotLoginError().isEmpty());
    }

    @Test
    void testGBWithoutPassword() {

//        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input")).sendKeys("login@login.ru");
//        driver.findElement(By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input")).click();
//
//        Assertions.assertFalse(driver.findElements(By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/ul")).isEmpty());

        loginPage.inputEmail("login@login.ru");
        loginPage.clickLoginButton();

        Assertions.assertFalse(loginPage.getNoPasswordError().isEmpty());
    }

}
