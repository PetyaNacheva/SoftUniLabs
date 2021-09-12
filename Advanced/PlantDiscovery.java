package FinalExam;

import java.util.*;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberPlants = Integer.parseInt(scanner.nextLine());
        Map<String,Integer> plants = new LinkedHashMap<>();
        for (int i = 0; i <numberPlants ; i++) {
            String []input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
                plants.put(plant,rarity);
            }
        Map<String, Double> plantAndRate = new LinkedHashMap<>();
        for (String s : plants.keySet()) {
            plantAndRate.put(s,0.0);
        }
        String input=scanner.nextLine();
        while (!input.equals("Exhibition")){
            String []token = input.split(": ");
            String command = token[0];
            String text = token[1];
            switch (command){
                case "Rate":
                    String[] textToChange = text.split(" - ");
                    String plant =textToChange[0];
                    int rate = Integer.parseInt(textToChange[1]);
                    if(plants.containsKey(plant)){
                        double oldRate= plantAndRate.get(plant);
                        double newRate =0.0;
                        if(oldRate==0.0){
                            newRate = rate;
                        }else{
                            newRate = (oldRate+rate)/2;
                        }

                   plantAndRate.put(plant,newRate);}
                    else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                   String []textToSplit = text.split(" - ");
                    plant=textToSplit[0];
                    int newRarity = Integer.parseInt(textToSplit[1]);
                    if(plants.containsKey(plant)){
                    plants.put(plant,newRarity);}
                    else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    plant = text;
                    if(plants.containsKey(plant)){
                    plantAndRate.put(plant,0.0);}
                    else {
                        System.out.println("error");
                    }
                    break;
            }
            input=scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.entrySet().
                stream().
                sorted((f,s)->s.getValue().compareTo(f.getValue())).
                forEach(e->
                        System.out.printf("- %s; Rarity: %d; Rating: %.2f%n",e.getKey(),e.getValue(),plantAndRate.get(e.getKey())));
    }
}

