package Advanced.DefiningClasses.Exe.PokemonTrainer;


import java.util.*;

public class Trainer {
    private String name;
    private int numberBadges;
    private List<Pokemon> pokemonList;

    public Trainer(String name, int numberBadges){
        this.name = name;
        this.numberBadges = numberBadges;
        this.pokemonList = new ArrayList<>();
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public void setNumberBadges(int numberBadges) {
        this.numberBadges = numberBadges;
    }

    public int getNumberBadges() {
        return numberBadges;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",getName(),getNumberBadges(),getPokemonList().size());
    }
}
