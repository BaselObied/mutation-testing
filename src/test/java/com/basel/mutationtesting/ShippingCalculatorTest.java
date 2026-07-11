package com.basel.mutationtesting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShippingCalculatorTest {

    ShippingCalculator calc;

    @BeforeEach
    void createShippingCalculator() {
        calc = new ShippingCalculator();
    }

    @Test
    void premiumMemberShipsFree() {
        assertEquals(0.0, calc.calculateShipping(50, 5, true));
    }

    @Test
    void orderOverThresholdShipsFree() {
        assertEquals(0.0, calc.calculateShipping(150, 5, false));
    }

    // new
    @Test
    void orderEqualThresholdShipsFree() {
        assertEquals(0.0, calc.calculateShipping(100, 5, false));
    }

    @Test
    void regularOrderHasCost() {
        assertEquals(15.0, calc.calculateShipping(50, 5, false));   // 5 + 5*2
    }

    @Test
    void heavyOrderHasSurcharge() {
        assertEquals(65.0, calc.calculateShipping(50, 25, false));
    } // 5 + 25*2 + 10

    //new
    @Test
    void exactlyAtHeavySurchargeLimit() {
        assertEquals(45.0, calc.calculateShipping(50, 20.0, false));
    }
}