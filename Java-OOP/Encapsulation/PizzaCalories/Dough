package PizzaCalories;

import java.util.Map;

public class Dough {

    private static final Map<String, Double> FLOUR_TYPE_WITH_MODIFIERS=
            Map.of("White",1.5 ,"Wholegrain",1.0);
    private static final Map<String, Double> BACKING_TECHNIQUES=
            Map.of("Crispy",0.9 ,"Chewy",1.1,"Homemade",1.0 );
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType,String bakingTechnique,double weight){
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    public String getFlourType() {
        return flourType;
    }

    private void setFlourType(String flourType) {
        if(!FLOUR_TYPE_WITH_MODIFIERS.containsKey(flourType)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!BACKING_TECHNIQUES.containsKey(bakingTechnique)){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        if(weight<0||weight>200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }
    ;
    public double calculateCalories(){
        return this.weight*2*FLOUR_TYPE_WITH_MODIFIERS.get(flourType)*BACKING_TECHNIQUES.get(bakingTechnique);
    }
}
