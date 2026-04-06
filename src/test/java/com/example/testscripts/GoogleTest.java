package com.example.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends TestBase {

    @Test
    public void verifyGoogleTitle() {
        // Le driver est déjà initialisé par le @BeforeMethod de TestBase
        driver.get("https://www.google.com");
        String title = driver.getTitle();
        System.out.println("🎬 Titre de la page : " + title);
        Assert.assertTrue(title.contains("Google"));
    }
}