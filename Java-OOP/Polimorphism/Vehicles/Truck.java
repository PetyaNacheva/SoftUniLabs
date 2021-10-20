package VehiclesExe;

public class Truck extends Vehicles{
    private static final double AIR_CONDITIONER = 1.6;

    public Truck(double fuelQuantity,double fuelConsumption,double tankCapacity){
      super(fuelQuantity,fuelConsumption+AIR_CONDITIONER,tankCapacity);
    }

    @Override
    public void refuel(double litters) {
        super.refuel(litters*0.95);
    }



}
