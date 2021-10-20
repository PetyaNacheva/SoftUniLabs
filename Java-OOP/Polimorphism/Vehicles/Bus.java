package VehiclesExe;

public class Bus extends Vehicles{
    private static final double ADDITIONAL_CONSUMPTION = 1.4;
   public Bus(double fuel, double consumption,double tankCapacity) {
        super(fuel, consumption+ADDITIONAL_CONSUMPTION,tankCapacity);
    }

    public void reduceConsumption() {
        this.setFuelConsumption(getFuelConsumption() - 1.4);
    }
}
