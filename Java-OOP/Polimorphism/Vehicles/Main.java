package VehiclesExe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String []tokens = scanner.nextLine().split("\\s+");
        Vehicles car = new Car(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));
        String []token = scanner.nextLine().split("\\s+");
        Vehicles truck = new Truck(Double.parseDouble(token[1]),Double.parseDouble(token[2]),Double.parseDouble(token[3]));
        String []input = scanner.nextLine().split("\\s+");
        Vehicles bus = new Bus(Double.parseDouble(input[1]),Double.parseDouble(input[2]),Double.parseDouble(input[3]));
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String command = scanner.nextLine();
            String [] params = command.split("\\s+");
            double argument = Double.parseDouble(params[2]);
            if(command.contains("Drive")){
                if(params[1].equals("Car")){
                    System.out.println(car.drive(argument));
                }else if(params[1].equals("Truck")){
                    System.out.println(truck.drive(argument));
                }else {
                    if (command.contains("DriveEmpty")) {
                        if(bus.drive(argument).contains("refueling")){
                            System.out.println(bus.drive(argument));
                        }else {
                            ((Bus) bus).reduceConsumption();
                        }
                    } else {
                        System.out.println(bus.drive(argument));
                    }
                }

            }else {
                if(params[1].equals("Car")){

                    car.refuel(argument);
                }else if(params[1].equals("Truck")){
                    truck.refuel(argument);
                }else{
                    bus.refuel(argument);
                }
            }
        }
        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
