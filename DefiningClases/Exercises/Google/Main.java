package Advanced.DefiningClasses.Exe.Google;

import java.util.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Person>personMap = new LinkedHashMap<>();
        while (!input.equals("End")){
            String []tokens = input.split("\\s+");
            String name = tokens[0];
            Company company1 = new Company(" "," ",0.0);
            Car car = new Car(" ",0);
            switch (tokens[1]){
                case "company":
                    String companyName= tokens[2];
                    String department = tokens[3];
                    double salary = Double.parseDouble(tokens[4]);
                    Company company = new Company(companyName,department,salary);
                    if(personMap.containsKey(name)){
                        personMap.get(name).setCompany(company);
                    }else {
                        Person person = new Person(name, company, car);
                        personMap.put(name, person);
                    }
                    break;
                case "car":
                    String model = tokens[2];
                    int carSpeed = Integer.parseInt(tokens[3]);
                    Car car1 = new Car(model,carSpeed);
                    if(personMap.containsKey(name)){
                        personMap.get(name).setCar(car1);
                    }else {
                        Person person1 = new Person(name, company1, car1);
                        personMap.put(name, person1);
                    }
                    break;
                case "pokemon":
                    String pokemonName = tokens[2];
                    String element = tokens[3];
                    Pokemon pokemon = new Pokemon(pokemonName,element);
                    if(!personMap.containsKey(name)){
                        Person person2 = new Person(name, company1,car);
                        personMap.put(name,person2);
                        personMap.get(name).getPokemonList().add(pokemon);
                    }else{
                        personMap.get(name).getPokemonList().add(pokemon);
                    }
                    break;
                case "parents":
                    String parentName = tokens[2];
                    String parentBirthDate = tokens[3];
                    Parents parents = new Parents(parentName,parentBirthDate);
                    if(!personMap.containsKey(name)){
                        Person person2 = new Person(name, company1,car);
                        personMap.put(name,person2);
                        personMap.get(name).getParentsList().add(parents);
                    }else{
                       personMap.get(name).getParentsList().add(parents);
                    }
                    break;
                case "children":
                    String childrenName = tokens[2];
                    String childrenDate = tokens[3];
                    Children children = new Children(childrenName,childrenDate);
                    if(!personMap.containsKey(name)){
                        Person person2 = new Person(name, company1,car);
                        personMap.put(name,person2);
                        personMap.get(name).getChildrenList().add(children);
                    }else{
                        personMap.get(name).getChildrenList().add(children);
                    }
            }

            input=scanner.nextLine();
        }
        String neededName = scanner.nextLine();
        for (Map.Entry<String, Person> entry : personMap.entrySet()) {
            if(entry.getKey().equals(neededName)){
                System.out.println(entry.getKey());
                System.out.println(entry.getValue().getCompany().toString());
                System.out.println(entry.getValue().getCar().toString());
                System.out.println("Pokemon:");
                entry.getValue().getPokemonList().forEach(p-> System.out.println(p.toString()));
                System.out.println("Parents:");
                entry.getValue().getParentsList().forEach(e-> System.out.println(e.toString()));
                System.out.println("Children:");
                entry.getValue().getChildrenList().forEach(c-> System.out.println(c.toString()));
            }
        }
    }
}
