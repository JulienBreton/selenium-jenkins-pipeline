package com.example.testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

public class WikipediaTest extends TestBase {

    @Test
    public void verifyWikipediaTitle() {
        // Le driver est déjà initialisé par le @BeforeMethod de TestBase
        driver.get("https://www.wikipedia.com");
        String title = driver.getTitle();
        System.out.println("🎬 Titre de la page : " + title);
        Assert.assertTrue(title.contains("Wikipedia"));
    }
}