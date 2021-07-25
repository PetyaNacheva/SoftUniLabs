package WildFarm2Exe;

public abstract class Animal {
    private String animalType;
    private String animalName;
    private Double animalWeight;
    private int foodEaten;

    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public int getFoodEaten() {
        return foodEaten;
    }

    public String getAnimalType() {
        return animalType;
    }

    public abstract void makeSound();

    public void setFoodEaten(int foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void eat(Food food);
}
