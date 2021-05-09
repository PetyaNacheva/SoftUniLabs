package FinalExam;

import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;

public class NeedForSpeedIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carAndMileage = new TreeMap<>();
        Map<String, Integer> carAndFuel = new HashMap<>();
        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            carAndMileage.put(car, mileage);
            carAndFuel.put(car, fuel);
        }
        String token = scanner.nextLine();
        while (!token.equals("Stop")) {
            String[] inputToken = token.split(" : ");
            String command = inputToken[0];
            String modelCar = inputToken[1];
            switch (command) {
                case "Drive":
                    int distance = Integer.parseInt(inputToken[2]);
                    int needFuel = Integer.parseInt(inputToken[3]);

                    if (carAndFuel.get(modelCar) >= needFuel) {
                        int newMileage = carAndMileage.get(modelCar) + distance;
                        carAndMileage.put(modelCar, newMileage);
                        int newFuel = carAndFuel.get(modelCar) - needFuel;
                        carAndFuel.put(modelCar, newFuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", modelCar, distance, needFuel);
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    if (carAndMileage.get(modelCar) >= 100000) {
                        System.out.printf("Time to sell the %s!%n", modelCar);
                        carAndMileage.remove(modelCar);
                        carAndMileage.remove(modelCar);
                    }
                    break;
                case "Refuel":
                    int fuelToRefill = Integer.parseInt(inputToken[2]);
                    int newFuel = carAndFuel.get(modelCar) + fuelToRefill;
                    if (newFuel <= 75) {
                        carAndFuel.put(modelCar, newFuel);
                        System.out.printf("%s refueled with %d liters%n", modelCar, fuelToRefill);
                    } else {
                        int moreFuel = newFuel - 75;
                        newFuel = carAndFuel.get(modelCar) + (fuelToRefill - moreFuel);
                        carAndFuel.put(modelCar, newFuel);
                        System.out.printf("%s refueled with %d liters%n", modelCar, fuelToRefill - moreFuel);
                    }
                    break;
                case "Revert":
                    int kilometersToRevert = Integer.parseInt(inputToken[2]);
                    int newKilometers = carAndMileage.get(modelCar) - kilometersToRevert;
                    if (newKilometers < 10000) {
                        newKilometers = 10000;
                        carAndMileage.put(modelCar, newKilometers);
                    } else {
                        carAndMileage.put(modelCar, newKilometers);
                        System.out.printf("%s mileage decreased by %d kilometers%n", modelCar, kilometersToRevert);
                    }
                    break;
            }


            token = scanner.nextLine();
        }

        carAndMileage
                .entrySet()
                .stream()
                .sorted((l, r) -> r.getValue() - l.getValue())
                .forEach(e -> System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                        e.getKey(), e.getValue(), carAndFuel.get(e.getKey())));

    }
    }

