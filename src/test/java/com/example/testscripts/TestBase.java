package com.example.testscripts;

import com.example.driver.DriverFactory; // Import de ton "usine" à driver
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;

public class TestBase {
    // On le met en "protected" pour que les classes enfants y aient accès
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        // Appelle la factory pour savoir s'il faut lancer en local ou remote
        driver = DriverFactory.createDriver();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}