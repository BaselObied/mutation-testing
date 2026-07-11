package com.basel.mutationtesting;

public class ShippingCalculator {
    private static final double FREE_SHIPPING_THRESHOLD = 100.0;
    private static final double BASE_RATE = 5.0;
    private static final double PER_KG_RATE = 2.0;
    private static final double HEAVY_SURCHARGE = 10.0;
    public static final double ZERO_SHIPPING_COST = 0.0;

    public double calculateShipping(double orderTotal, double weightKg, boolean isPremiumMember) {
        if (isPremiumMember) {
            return ZERO_SHIPPING_COST;
        }
        if (orderTotal >= FREE_SHIPPING_THRESHOLD) {
            return ZERO_SHIPPING_COST;
        }

        double cost = BASE_RATE + (weightKg * PER_KG_RATE);

        if (weightKg > 20) {
            cost += HEAVY_SURCHARGE;
        }
        return cost;
    }

    public double getFreeShippingThreshold() {
        return FREE_SHIPPING_THRESHOLD;
    }
}
