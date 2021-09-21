package Advanced.DefiningClasses.SpeedRacing;

import java.util.HashMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        Map<String,Car> vehicles = new LinkedHashMap<>();
        for (int i = 0; i <number ; i++) {
            String []tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuel = Double.parseDouble(tokens[1]);
            double consumption = Double.parseDouble(tokens[2]);

            Car car = new Car(model,fuel,consumption);
            vehicles.put(model,car);
        }
        String input = scanner.nextLine();
        while(!input.equals("End")){
            String []tokens = input.split("\\s+");
            String model = tokens[1];
            int distanceToDrive = Integer.parseInt(tokens[2]);
            if(!vehicles.get(model).drive(distanceToDrive)){
                System.out.println("Insufficient fuel for the drive");
            }

            input=scanner.nextLine();
        }
        vehicles.values().stream().forEach(System.out::println);
    }
}
