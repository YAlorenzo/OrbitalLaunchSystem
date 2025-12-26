package controller;

import model.RocketData;
import view.MissionControlConsole;

public class LaunchDirector {
    private MissionControlConsole view;

    public LaunchDirector(MissionControlConsole view) {
        this.view = view;
    }

    public void initiateLaunchSequence() {
        view.welcomeUser();

        int choice = view.askMissionTarget();
        double requiredSpeed;
        String missionName;


        switch (choice) {
            case 1:
                missionName = "Low Earth Orbit (LEO)";
                requiredSpeed = 7800.0;
                break;
            case 2:
                missionName = "Geostationary Orbit (GTO)";
                requiredSpeed = 10200.0;
                break;
            case 3:
                missionName = "Moon (Luna)";
                requiredSpeed = 11200.0;
                break;
            case 4:
                missionName = "Mars (Red Planet)";
                requiredSpeed = 11500.0;
                break;
            default:
                System.out.println(">> Unknown selection. Defaulting to LEO.");
                missionName = "Low Earth Orbit (Default)";
                requiredSpeed = 7800.0;
        }

        double payloadMass = view.askDouble("Enter Payload Mass (kg):");
        double fuelMass = view.askDouble("Enter Fuel Mass (kg):");

        try {
            RocketData rocket = new RocketData(payloadMass, fuelMass);
            double deltaV = rocket.calculateDeltaV();

            boolean isSuccess = rocket.canReachOrbit(requiredSpeed);

            view.displayMissionResult(isSuccess, deltaV, missionName);

        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
        }
    }
}