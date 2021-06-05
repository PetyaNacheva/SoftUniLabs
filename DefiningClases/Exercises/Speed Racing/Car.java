package Advanced.DefiningClasses.SpeedRacing;

public class Car {
   private String model;
   private double fuel;
   private double consumption;
   private int traveledDistance;

   public Car(String model,double fuel,double consumption){
       this.model = model;
       this.fuel = fuel;
       this.consumption = consumption;
       this.traveledDistance = 0;
   }

    public boolean drive(int distanceToDrive) {
       double neededFuel = distanceToDrive*consumption;
       if(neededFuel<=this.fuel){
           this.traveledDistance+=distanceToDrive;
           this.fuel-=neededFuel;
           return true;
       }
       return false;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %d",this.model,this.fuel,this.traveledDistance);
    }
}
