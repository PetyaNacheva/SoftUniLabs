package WildFarm2Exe;

import java.sql.SQLOutput;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        List<Animal> animalList = new ArrayList<>();
        while (!"End".equals(line=scanner.nextLine())){
        String [] animalInfor =line.split("\\s+");
        String type = animalInfor[0];
        String name = animalInfor[1];
        double weight = Double.parseDouble(animalInfor[2]);
        String livingRegion =animalInfor[3];
        Animal animal = null;
        switch (type){
            case "Mouse":
                animal = new Mouse(type,name,weight,livingRegion);

                break;
            case "Zebra":
                animal = new Zebra(type,name,weight,livingRegion);

                break;
            case "Cat":
                String breed = animalInfor[4];
                animal = new Cat(type,name,weight,livingRegion,breed);

                break;
            case "Tiger":
                animal = new Tiger(type,name,weight,livingRegion);

                break;
        }
            animal.makeSound();
        String []foodTokens =scanner.nextLine().split("\\s+");
        Food food = null;
        int foodQuantity = Integer.parseInt(foodTokens[1]);
        if(foodTokens[0].equals("Vegetable")){
            food = new Vegetable(foodQuantity);
        }else{
            food = new Meet(foodQuantity);
        }
        try {
            animal.eat(food);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        animalList.add(animal);

        }

        for (Animal animal : animalList) {
            System.out.println(animal.toString());
        }
    }
}
