package VehiclesExe;

import java.text.DecimalFormat;

public abstract class Vehicles {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;

    protected Vehicles(double fuel, double consumption,double tankCapacity){
        this.fuelQuantity=fuel;
        this.fuelConsumption = consumption;
        this.tankCapacity = tankCapacity;
    }

    public String drive(double kilometers){
    double fuelNeeded = kilometers*this.fuelConsumption;
    if(fuelNeeded>this.fuelQuantity){
        return this.getClass().getSimpleName()+" needs refueling";
    }
    this.fuelQuantity-=fuelNeeded;
        DecimalFormat df = new DecimalFormat("#.##");

    return String.format("%s travelled %s km", this.getClass().getSimpleName(),df.format(kilometers));
    }

    public void refuel(double litters){
        if(litters<=0){
            System.out.println("Fuel must be a positive number");
        }else if(this.fuelQuantity+litters>tankCapacity){
            System.out.println("Cannot fit fuel in tank");
        }
        else {
            this.fuelQuantity += litters;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f",this.getClass().getSimpleName(),this.fuelQuantity);
    }

    protected double getFuelConsumption(){
        return this.fuelConsumption;
    }

    protected void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }
}
