package spaceStation.models.astronauts;

import spaceStation.common.ExceptionMessages;
import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import static spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_NAME;
import static spaceStation.common.ConstantMessages.REPORT_ASTRONAUT_OXYGEN;

public abstract class BaseAstronaut implements Astronaut{
    private String name;
    private double oxygen;
    private Bag bag;

    protected BaseAstronaut(String name, double oxygen){
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    public void setName(String name) {
        if(name==null||name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public void setOxygen(double oxygen) {
        if(oxygen<0){
            throw new IllegalArgumentException(ExceptionMessages.ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    @Override
    public boolean canBreath() {
        return this.oxygen>0;
    }

    @Override
    public Bag getBag() {
        return this.bag;
    }

    @Override
    public void breath() {
        if(canBreath()&&getOxygen()-10>0){
            setOxygen(getOxygen()-10);
        }
    }

    @Override
    public String toString() {
            return String.format(REPORT_ASTRONAUT_NAME, this.getName())
                    + System.lineSeparator()
                    + String.format(REPORT_ASTRONAUT_OXYGEN, this.getOxygen())
                    + System.lineSeparator()
                    + this.bag.toString();

    }
}
