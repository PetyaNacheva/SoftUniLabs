package PizzaCalories;

import java.util.Map;
import java.util.Set;

public class Topping {
    private static final Map<String, Double> ALLOWED_TOPPING_TYPES =Map.of("Meat",1.2 ,"Veggies",0.8,"Cheese",1.1 ,"Sauce",0.9);
    private String toppingType;
    private double weight;

    public Topping(String toppingType,double weight){
        setToppingType(toppingType);
        setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        if(!ALLOWED_TOPPING_TYPES.containsKey(toppingType)){
            throw new IllegalArgumentException("Cannot place "+toppingType+" on top of your pizza.");
        }
        this.toppingType = toppingType;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if(weight<1||weight>50){
            throw new IllegalArgumentException(toppingType+" weight should be in the range [1..50].");
        }
        this.weight = weight;
    }

    public double calculateCalories(){
       return this.weight*2*ALLOWED_TOPPING_TYPES.get(this.toppingType);
    }
}
