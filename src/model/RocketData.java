package model;

public class RocketData {
    double payloadMass;
    double fuelMass;
    public static final int STRUCTURAL_MASS = 1000;
    public static final double ENGINE_EFFICIENCY = 3070.0;

    public RocketData(double payloadMass, double fuelMass){
        if(payloadMass < 0){
            throw new IllegalArgumentException("The payload mass cannot be negative!");
        }
        if(fuelMass < 0){
            throw new IllegalArgumentException("The fuel mass cannot be negative!");
        }

        this.payloadMass = payloadMass;
        this.fuelMass = fuelMass;

    }

    public double calculateDeltaV(){
        double totalMass = STRUCTURAL_MASS + payloadMass + fuelMass;
        double dryMass = totalMass - fuelMass;


        return ENGINE_EFFICIENCY * Math.log(totalMass/dryMass);
    }

    public boolean canReachOrbit(double requiredSpeed) {
        return calculateDeltaV() >= requiredSpeed;
    }

}
