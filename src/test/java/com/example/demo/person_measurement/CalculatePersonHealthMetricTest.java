package com.example.demo.person_measurement;

import com.example.demo.person_measurement.api.dto.PhysicalActivityLevel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatePersonHealthMetricTest {

    @Test
    void testCalculateBMIWithValidInput() {
        double weight = 70.0;
        double height = 175.0;
        double expectedBMI = 22.86;

        double result = CalculatePersonHealthMetric.calculateBMI(weight, height);
        assertEquals(expectedBMI, result);
    }

    @Test
    void testCalculatePPMForWoman() {

        double weight = 70.0;
        double height = 175.0;
        int age = 30;
        String sex = "Women";
        double expectedPPM = 1508.0;

        double result = CalculatePersonHealthMetric.calculatePPM(weight, height, age, sex);
        assertEquals(expectedPPM, result);
    }

    @Test
    void testCalculatePPMForMan() {

        double weight = 70.0;
        double height = 175.0;
        int age = 30;
        String sex = "Man";
        double expectedPPM = 1701.0;

        double result = CalculatePersonHealthMetric.calculatePPM(weight, height, age, sex);
        assertEquals(expectedPPM, result);
    }

    @Test
    void testCalculateCPMWithPAL1() {

        double ppm = 1500.0;
        PhysicalActivityLevel pal = PhysicalActivityLevel.PAL_1;
        double expectedCPM = 1800.0;

        double result = CalculatePersonHealthMetric.calculateCPM(ppm, pal);
        assertEquals(expectedCPM, result);
    }

    @Test
    void testCalculateCPMWithPAL2() {

        double ppm = 1500.0;
        PhysicalActivityLevel pal = PhysicalActivityLevel.PAL_2;
        double expectedCPM = 2100.0;

        double result = CalculatePersonHealthMetric.calculateCPM(ppm, pal);
        assertEquals(expectedCPM, result);
    }

    @Test
    void testCalculateCPMWithPAL3() {

        double ppm = 1500.0;
        PhysicalActivityLevel pal = PhysicalActivityLevel.PAL_3;
        double expectedCPM = 2400.0;

        double result = CalculatePersonHealthMetric.calculateCPM(ppm, pal);
        assertEquals(expectedCPM, result);
    }

    @Test
    void testCalculateCPMWithPAL4() {

        double ppm = 1500.0;
        PhysicalActivityLevel pal = PhysicalActivityLevel.PAL_4;
        double expectedCPM = 2700.0;

        double result = CalculatePersonHealthMetric.calculateCPM(ppm, pal);
        assertEquals(expectedCPM, result);
    }
    @Test
    void testCalculateCPMWithPAL5() {

        double ppm = 1500.0;
        PhysicalActivityLevel pal = PhysicalActivityLevel.PAL_5;
        double expectedCPM = 3000.0;

        double result = CalculatePersonHealthMetric.calculateCPM(ppm, pal);
        assertEquals(expectedCPM, result);
    }

    @Test
    void testCalculateProteinPerGram() {

        double cpm = 2000.0;
        double expectedProteinPerGram = 50.0;

        double result = CalculatePersonHealthMetric.calculateProteinPerGram(cpm);
        assertEquals(expectedProteinPerGram, result);
    }

    @Test
    void testCalculateFatPerGram() {

        double cpm = 2000.0;
        double expectedFatPerGram = 67.0;

        double result = CalculatePersonHealthMetric.calculateFatPerGram(cpm);
        assertEquals(expectedFatPerGram, result);
    }

    @Test
    void testCalculateCarbsPerGram() {

        double cpm = 2000.0;
        double expectedCarbsPerGram = 300.0;

        double result = CalculatePersonHealthMetric.calculateCarbsPerGram(cpm);
        assertEquals(expectedCarbsPerGram, result);

    }

}