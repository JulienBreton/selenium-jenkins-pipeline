package com.example.testscripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostChecks  extends TestBase {
    
    @Test
    public void verifyStatutPtfOK() {
        driver.get("https://julienbreton.github.io/selenium-jenkins-pipeline/statut_ptf?status=ok");
        String statut = driver.findElement(By.id("status-message")).getText();
        System.out.print("✅ Vérification du statut de la plateforme : " + statut);
        Assert.assertTrue(statut.contains("la plateforme est ok"));
    }

    @Test
    public void verifyStatutPtfKO() {
        driver.get("https://julienbreton.github.io/selenium-jenkins-pipeline/statut_ptf?status=ko");
        String statut = driver.findElement(By.id("status-message")).getText();
        System.out.print("❌ Vérification du statut de la plateforme : " + statut);    
        //On s'attend à ce que la ptf soit ok avant de démarrer les tests.    
        Assert.assertTrue(statut.contains("la plateforme est ok"));
    }
}
