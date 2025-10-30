package org.example.inclass_week2;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.junit.jupiter.api.Assertions.*;
class BMIControllerTest {
    @Test
    void onCalculateClick() {
        double weight = 70.0;
        double height = 175.0;
        double expectedBMI = weight / Math.pow(height / 100, 2);
        double actualBMI = weight / Math.pow(height / 100, 2);
        assertEquals(expectedBMI, actualBMI, 0.01);
    }

    @Test
    void onENClick() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("en", "US"));
        assertEquals("Calculate", rb.getString("btnCalculate.text"));
    }

    @Test
    void onFRClick() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("fr", "FR"));
        assertEquals("Calculer", rb.getString("btnCalculate.text"));
    }

    @Test
    void onVNClick() {
        ResourceBundle rb = ResourceBundle.getBundle("messages", new Locale("vi", "VI"));
        assertEquals("Tính toán", rb.getString("btnCalculate.text"));
    }
}