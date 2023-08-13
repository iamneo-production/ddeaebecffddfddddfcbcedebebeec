package com.snapdeal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AppTest {
    private WebDriver driver;
    private App app;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Documents\\New\\snapdeal\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        app = new App(driver);
    }

    @Test
    public void testSignIn() {
        app.openSite();
        app.moveToSignIn();
        app.clickSignIn();
        app.enterEmail("test@example.com");
        app.enterPassword("password");
        Assert.assertTrue(app.isUserLoggedIn(), "User is not logged in");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
