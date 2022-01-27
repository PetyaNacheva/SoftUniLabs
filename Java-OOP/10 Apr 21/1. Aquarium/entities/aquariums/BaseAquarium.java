package aquarium.entities.aquariums;

import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    @Override
    public int calculateComfort() {
        int sum=0;
        for (Decoration decoration : decorations) {
           sum=decoration.getComfort();

        }
        return sum;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void addFish(Fish fis) {
    if(fish.size()+1>capacity){
    throw new IllegalArgumentException(ConstantMessages.NOT_ENOUGH_CAPACITY);
    }
    fish.add(fis);
    }

    @Override
    public void removeFish(Fish fis) {
    fish.remove(fis);
    }

    @Override
    public void addDecoration(Decoration decoration) {
    decorations.add(decoration);
    }

    @Override
    public void feed() {
    fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2= new StringBuilder();
       sb.append( String.format("%s (%s):",getName(),getClass().getSimpleName()));
       sb.append(System.lineSeparator());
       sb.append("Fish: ");
        if(fish.size()==0){
            sb.append("none");
        }else {
            for (Fish fish1 : fish) {
                sb2.append(fish1.getName()+" ");
            }
            String result = sb2.substring(0,sb2.length()-1);
            sb.append(result);
        }
        sb.append(System.lineSeparator());
        sb.append(String.format("Decorations: %d", decorations.size()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Comfort: %d",calculateComfort()));
        sb.append(System.lineSeparator());
        return sb.toString().trim();
    }

    @Override
    public Collection<Fish> getFish() {
        return new ArrayList<>(fish);
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return new ArrayList<>(decorations);
    }
}
