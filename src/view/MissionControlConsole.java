package view;

import java.util.Scanner;

public class MissionControlConsole {
    private Scanner scanner = new Scanner(System.in);

    // Приветствие пользователя
    public void welcomeUser() {
        System.out.println("===   ORBITAL LAUNCH CONTROL SYSTEM    ===");
        System.out.println("System initialized. Waiting for flight parameters...\n");
    }

    public int askMissionTarget() {
        System.out.println("\nSelect Mission Target:");
        System.out.println("1. Low Earth Orbit (LEO)  [7800 m/s]");
        System.out.println("2. Geostationary (GTO)    [10200 m/s]");
        System.out.println("3. Moon Transfer (TLI)    [11200 m/s]");
        System.out.println("4. Mars Transfer (TMI)    [11500 m/s]");
        System.out.print(">> Enter choice [1-4]: ");

        while (!scanner.hasNextInt()) {
            System.out.println(">> Invalid Input. Enter a number 1-4!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double askDouble(String message) {
        System.out.print(message + " ");

        while (!scanner.hasNextDouble()) {
            System.out.println(">> Input Error: Please enter a valid number!");
            System.out.print(message + " ");
            scanner.next();
        }

        return scanner.nextDouble();
    }

    public void displayMissionResult(boolean success, double deltaV, String targetName) {
        System.out.println("\n----------- REPORT -----------");
        System.out.println("Target Mission: " + targetName);
        System.out.printf("Vehicle Delta-V: %.2f m/s%n", deltaV);

        if (success) {
            System.out.println("STATUS: [SUCCESS] - TARGET REACHED");
            System.out.println("Message: Orbit insertion complete. Welcome to " + targetName + "!");
        } else {
            System.out.println("STATUS: [FAILURE] - MISSION ABORTED");
            System.out.println("Message: Insufficient velocity for " + targetName + ".");
        }
        System.out.println("----------------------------------------");
    }

    public void displayError(String errorMessage) {
        System.err.println("\n!!! CRITICAL LAUNCH ERROR: " + errorMessage + " !!!");
    }
}
