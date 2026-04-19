package com.example.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URI;

public class DriverFactory {

    public static WebDriver createDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();

        // On récupère une variable d'environnement ou une propriété Maven
        // Si "REMOTE" est vrai, on va sur le Hub Docker, sinon en local
        String runMode = System.getProperty("runMode", "remote");

        if ("remote".equalsIgnoreCase(runMode)) {
            System.out.println("🌐 Connexion au Selenium Hub Docker...");
            return new RemoteWebDriver(
                    URI.create("pc-hote:4444/wd/hub").toURL(),
                    options);
        } else {
            System.out.println("💻 Lancement du Chrome local...");
            return new ChromeDriver(options);
        }
    }
}