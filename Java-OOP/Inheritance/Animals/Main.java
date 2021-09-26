package Animals2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!input.equals("Beast!")) {

            String[] tokens = scanner.nextLine().split("\\s+");

            Animal animal;
            try {
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String gender = tokens[2];
                switch (input){
                    case "Dog":
                        animal = new Dog(name,age,gender);
                        animals.add(animal);
                        break;
                    case "Cat":
                        animal = new Cat(name,age,gender);
                        animals.add(animal);
                        break;
                    case "Frog":
                        animal = new Frog(name,age,gender);
                        animals.add(animal);
                        break;
                    case "Kittens":
                        animal = new Kitten(name,age);
                        animals.add(animal);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name,age);
                        animals.add(animal);
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
