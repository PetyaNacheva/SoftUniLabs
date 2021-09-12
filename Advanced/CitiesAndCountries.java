package Advanced.SetsAndMaps.Lab.Last;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CitiesAndCountries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, ArrayList<String>>>continentsAndCities= new LinkedHashMap<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <number ; i++) {
            String []data = scanner.nextLine().split("\\s+");
            String continent = data[0];
            String country = data[1];
            String city = data[2];
            if(!continentsAndCities.containsKey(continent)){
                continentsAndCities.put(continent,new LinkedHashMap<>());
            }
            if(!continentsAndCities.get(continent).containsKey(country)) {
                continentsAndCities.get(continent).put(country, new ArrayList<>());
                continentsAndCities.get(continent).get(country).add(city);
            }else {
                continentsAndCities.get(continent).get(country).add(city);
            }
        }
        continentsAndCities.entrySet().stream().forEach(e->{
            System.out.println(e.getKey()+":");
            e.getValue().entrySet().stream().forEach(v->{
                System.out.printf("%s -> ",v.getKey());
                String result = v.getValue().stream().collect(Collectors.joining(", "));
                System.out.println(result);
                });
            });
    }
}
