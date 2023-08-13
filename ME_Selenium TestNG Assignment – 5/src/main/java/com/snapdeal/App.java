package com.snapdeal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class App {
    private WebDriver driver;

    public App(WebDriver driver) {
        this.driver = driver;
    }

    public void openSite() {
        driver.get("http://www.snapdeal.com");
    }

    public void moveToSignIn() {
        WebElement signInButton = driver.findElement(By.xpath("//span[text()='Sign In']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(signInButton).build().perform();
    }

    public void clickSignIn() {
        driver.findElement(By.xpath("//span[text()='Sign In']")).click();
    }

    public void enterEmail(String email) {
        driver.findElement(By.id("userName")).sendKeys(email);
        driver.findElement(By.id("checkUser")).click();
    }

    public void enterPassword(String password) {
        driver.findElement(By.id("j_password_login_uc")).sendKeys(password);
        driver.findElement(By.id("submitLoginUC")).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(By.xpath("//span[text()='Sign Out']")).isDisplayed();
    }
}
