package Advanced.DefiningClasses.Exe.CatLady;

import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Cats>catsMap = new LinkedHashMap<>();
        while (!input.equals("End")){
            String []tokens = input.split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            double number = Double.parseDouble(tokens[2]);
            switch (type){
                case "Siamese":
                    Cats cats = new Siamese(name,number);
                    catsMap.putIfAbsent(name,cats);
                    break;
                case "Cymric":
                    Cats cats1 = new Cymric(name,number);
                    catsMap.putIfAbsent(name,cats1);
                    break;
                case "StreetExtraordinaire":
                    Cats cats2 = new StreetExtraordinaire(name,number);
                    catsMap.putIfAbsent(name,cats2);
                    break;
            }
            input = scanner.nextLine();
        }
        String neededCat = scanner.nextLine();
        for (Map.Entry<String, Cats> entry : catsMap.entrySet()) {
            if(entry.getKey().equals(neededCat)){
                System.out.println(entry.getValue().toString());
            }
        }
    }
}
