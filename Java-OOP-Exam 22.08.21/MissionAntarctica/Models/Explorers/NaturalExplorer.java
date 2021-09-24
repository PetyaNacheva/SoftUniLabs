package glacialExpedition.models.explorers;

import glacialExpedition.models.suitcases.Suitcase;

public class NaturalExplorer extends BaseExplorer{
    private static final double INITIAL_ENERGY = 60;
    private static final double DECREASED_ENERGY_VALUE = 7;
    public NaturalExplorer(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void search() {
        if(this.getEnergy()-DECREASED_ENERGY_VALUE>=0){
            this.setEnergy(this.getEnergy()-DECREASED_ENERGY_VALUE);
        }else {
            setEnergy(0);
        }
    }
}
