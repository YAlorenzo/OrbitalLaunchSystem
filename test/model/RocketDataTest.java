package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RocketDataTest {
    @Test
    void testSuccessfulLaunch() {
        RocketData strongRocket = new RocketData(100.0, 15000.0);

        assertTrue(strongRocket.canReachOrbit(7800), "Verification Error: Orbital Maneuver Verification Failure with Maximum Propellant Reserve");
    }

    @Test
    void testLaunchFailure() {
        RocketData heavyRocket = new RocketData(5000.0, 1000.0);
        assertFalse(heavyRocket.canReachOrbit(7800), "CRITICAL MODEL ERROR: False positive prediction. The system allowed launch with a critical working fluid deficiency.");
    }
}