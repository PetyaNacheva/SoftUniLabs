package groomingSalon;

import java.util.*;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add(Pet pet){
        if(getCount()+1<=capacity){
            data.add(pet);
            setCapacity(getCapacity()-1);
        }
    }
    public boolean remove(String name){
        return data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        Pet pet = null;
        pet = data.stream().filter(p->p.getName().equals(name)).filter(p->p.getOwner().equals(owner)).findFirst().orElse(null);
        return pet;
    }
    public int getCount(){
        return data.size();
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:");
        sb.append(System.lineSeparator());
        for (Pet datum : data) {
            sb.append(datum.getName());
            sb.append(" ");
            sb.append(datum.getOwner());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
