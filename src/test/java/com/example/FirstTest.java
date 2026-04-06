package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTest {
    @Test
    public void testSante() {
        System.out.println("✅ Le socle Maven est opérationnel !");
        Assert.assertTrue(true);
    }
}