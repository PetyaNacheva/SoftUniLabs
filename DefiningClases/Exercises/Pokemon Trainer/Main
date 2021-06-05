package Advanced.DefiningClasses.Exe.PokemonTrainer;


import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Pokemon> pokemonList = new ArrayList<>();
        Map<String, Trainer> trainerMap = new LinkedHashMap<>();
        while (!input.equals("Tournament")){
            String [] tokens = input.split("\\s+");
            String name = tokens[0];
            String pokemonName= tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            int numberOfBadges =0;
            Pokemon pokemon = new Pokemon(pokemonName,pokemonElement,pokemonHealth);
            Trainer trainer = new Trainer(name,numberOfBadges);
            trainerMap.putIfAbsent(name,trainer);
            trainerMap.get(name).getPokemonList().add(pokemon);
            pokemonList.add(pokemon);
            input=scanner.nextLine();
        }
         input = scanner.nextLine();
        while (!input.equals("End")){

           for (Map.Entry<String, Trainer> entry : trainerMap.entrySet()) {
               if(entry.getValue().getPokemonList().size()>0){
                   boolean havePokemon = false;
                   for(Pokemon pokemon:entry.getValue().getPokemonList()){
                       if(pokemon.getElement().equals(input)){
                           havePokemon = true;
                           int currentBadgets = entry.getValue().getNumberBadges();
                           entry.getValue().setNumberBadges(currentBadgets+1);
                           break;
                       }
                   }
                   if(!havePokemon){
                       entry.getValue().getPokemonList().stream().forEach(e->{
                           int currentHealth = e.getHealth();
                           e.setHealth(currentHealth-10);
                       });
                       entry.getValue().getPokemonList().removeIf(pokemon -> pokemon.getHealth()==0);
                   }
               }
           }
            input= scanner.nextLine();
        }
       trainerMap.entrySet().stream().sorted((f,s)->Integer.compare(s.getValue().getNumberBadges(),f.getValue().getNumberBadges()))
                   .forEach(e -> System.out.println(e.getValue().toString()));
    }
}
