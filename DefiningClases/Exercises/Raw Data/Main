package Advanced.DefiningClasses.Exe.RawData;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<Car> fragileCargo = new ArrayList<>();
        List<Car> flamableCargo = new ArrayList<>();
        for (int i = 0; i <number ; i++) {
            List<Tire> tireList = new ArrayList<>();
            String []tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String type = tokens[4];
            double tireOnePressure = Double.parseDouble(tokens[5]);
            int tireOneAge = Integer.parseInt(tokens[6]);
            double tireTwoPressure = Double.parseDouble(tokens[7]);
            int tireTwoAge = Integer.parseInt(tokens[8]);
            double tireThreePressure = Double.parseDouble(tokens[9]);
            int tireThreeAge = Integer.parseInt(tokens[10]);
            double tireFourPressure = Double.parseDouble(tokens[11]);
            int tireFourAge = Integer.parseInt(tokens[12]);
            Cargo cargo = new Cargo(weight,type);
            Engine engine = new Engine(speed,power);
            Tire tireOne = new Tire(tireOnePressure,tireOneAge);
            Tire tireTwo = new Tire(tireTwoPressure,tireTwoAge);
            Tire tireThree = new Tire(tireThreePressure,tireThreeAge);
            Tire tireFour = new Tire(tireFourPressure,tireFourAge);
            tireList.add(tireOne);
            tireList.add(tireTwo);
            tireList.add(tireThree);
            tireList.add(tireFour);
            Car car = new Car(model, engine, cargo,tireList);
            if(type.equals("fragile")){
                if(tireOne.getPressure()<1||tireTwo.getPressure()<1||tireThree.getPressure()<1||tireFour.getPressure()<1) {
                    fragileCargo.add(car);
                }
            }else {
                if(power>250) {
                    flamableCargo.add(car);
                }
            }
        }
        String input = scanner.nextLine();
        if(input.equals("fragile")){
            fragileCargo.stream().forEach(e-> System.out.println(e.getModel()));
        }else {
            flamableCargo.stream().forEach(e-> System.out.println(e.getModel()));
        }
    }
}
