package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import javax.lang.model.type.MirroredTypeException;
import java.util.ArrayList;

public abstract class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if(name==null||name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }else {
            this.name = name;
        }
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    private void setOxygen(double oxygen) {
        if(oxygen<0) {
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }else {
            this.oxygen = oxygen;
        }
    }

    @Override
    public boolean canBreath() {
        if(getOxygen()-10>=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }
    public void addItems(String item){
        this.bag.addItems(item);
    }

    @Override
    public void breath() {
        if(getOxygen()-10>=0) {
            setOxygen(getOxygen() - 10);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s",getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Oxygen: %.2f",getOxygen()));
        sb.append(System.lineSeparator());
        if(getBag().getItems().size()==0){
            sb.append("none");
        }else {
            sb.append("Bag items: ");
        }
        for (String item : getBag().getItems()) {
            sb.append(item+", ");
        }
        String result = sb.substring(0,sb.length()-2);

        return result.trim();
    }
}
