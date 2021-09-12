package Advanced.SetsAndMaps.Lab.Last;

import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Map<String,Long>>countryData =new LinkedHashMap<>();
        while (!input.equals("report")){
        String []tokens = input.split("\\|");
        String city = tokens[0];
        String country = tokens[1];
       long  population = Long.parseLong(tokens[2]);
        if(!countryData.containsKey(country)){
            countryData.put(country,new LinkedHashMap<>());
            countryData.get(country).put(city,population);
        }else{
            countryData.get(country).put(city,population);
        }

            input=scanner.nextLine();
        }
        countryData.entrySet().stream().sorted((c1,c2)->{
            long p1 = c1.getValue().values().stream().mapToLong(l->l).sum();
            long p2 = c2.getValue().values().stream().mapToLong(l->l).sum();
            return Long.compare(p2,p1);
        }).forEach(c->{
            long totalPopulation = c.getValue().values().stream().mapToLong(l->l).sum();
            System.out.printf("%s (total population: %d)%n",c.getKey(),totalPopulation);
            Map<String, Long> value = c.getValue();
            value.entrySet().stream().sorted((s1,s2)->Long.compare(s2.getValue(),s1.getValue()))
                    .forEach(s-> System.out.printf("=>%s: %d%n",s.getKey(),s.getValue()));

        });
        
    }
}
