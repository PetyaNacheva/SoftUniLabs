package FinalExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;

public class PiratesNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> townPopulation = new TreeMap<>();
        Map<String, Integer>townGold = new HashMap<>();
        while (!input.equals("Sail")){
            String []token = input.split("\\|\\|");
            String town = token[0];
            int population = Integer.parseInt(token[1]);
            int gold = Integer.parseInt(token[2]);
            if(!townPopulation.containsKey(town)){
                townPopulation.put(town,population);
                townGold.put(town,gold);
            }else {
                townPopulation.put(town,townPopulation.get(town)+population);
                townGold.put(town,townGold.get(town)+gold);
            }
            input=scanner.nextLine();
        }
        String text = scanner.nextLine();
        while (!text.equals("End")){
            String []tokenText = text.split("=>");
            String command = tokenText[0];
            String town = tokenText[1];
            switch (command){
                case "Plunder":
                    int people = Integer.parseInt(tokenText[2]);
                    int gold = Integer.parseInt(tokenText[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n",town,gold,people);
                    townGold.put(town,townGold.get(town)-gold);
                    townPopulation.put(town,townPopulation.get(town)-people);
                    int restGold = townGold.get(town);
                    int restPeople = townPopulation.get(town);
                    if(restGold==0||restPeople==0){
                        System.out.printf("%s has been wiped off the map!%n",town);
                       townGold.remove(town);
                        townPopulation.remove(town);
                    }
                    break;
                case "Prosper":
                    int goldToProsper = Integer.parseInt(tokenText[2]);
                    if(goldToProsper<=0){
                        System.out.println("Gold added cannot be a negative number!");
                    }else{
                        townGold.put(town,townGold.get(town)+goldToProsper);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n",goldToProsper,town,townGold.get(town));
                    }
                    break;
            }

            text=scanner.nextLine();
        }
        if(townGold.size()>0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n",townGold.size());
            townGold.entrySet().stream()
                    .sorted((f,s)->s.getValue().compareTo(f.getValue()))
                    .forEach(e->{
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n",e.getKey(),townPopulation.get(e.getKey()),e.getValue());
                    });
        }else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
