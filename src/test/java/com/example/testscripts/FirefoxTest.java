package com.example.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxTest extends TestBase {

    @Test
    public void verifyFirefoxTitle() {
        // Le driver est déjà initialisé par le @BeforeMethod de TestBase
        driver.get("https://www.firefox.com/fr/");
        String title = driver.getTitle();
        System.out.println("🎬 Titre de la page : " + title);
        Assert.assertTrue(title.contains("Firefox"));
    }
}