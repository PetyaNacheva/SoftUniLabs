package aquarium.core;


import aquarium.common.ConstantMessages;
import aquarium.common.ExceptionMessages;
import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.*;
import java.util.zip.CheckedOutputStream;

public class ControllerImpl implements Controller {
    private Collection<Aquarium>aquariums;
    private DecorationRepository decorations;
    private Map<String,DecorationRepository> decorationForAquariumMap;

    public ControllerImpl() {
        this.decorations =new DecorationRepository();
        this.aquariums = new ArrayList<>();
        this.decorationForAquariumMap = new LinkedHashMap<>();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        if(!aquariumType.equals("FreshwaterAquarium")&&!aquariumType.equals("SaltwaterAquarium")){
            throw new NullPointerException(ExceptionMessages.INVALID_AQUARIUM_TYPE);
        }else if(aquariumType.equals("FreshwaterAquarium")){
            Aquarium aquarium = new FreshwaterAquarium(aquariumName);
            aquariums.add(aquarium);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE,"FreshwaterAquarium");
        }else {
            Aquarium aquarium = new SaltwaterAquarium(aquariumName);
            aquariums.add(aquarium);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AQUARIUM_TYPE,"SaltwaterAquarium");
        }
    }

    @Override
    public String addDecoration(String type) {
        if(!type.equals("Ornament")&&!type.equals("Plant")){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_DECORATION_TYPE);
        }else if(type.equals("Ornament")){
            Decoration decoration = new Ornament();
            decorations.add(decoration);

            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE,"Ornament");
        }else {
            Decoration decoration = new Plant();
            decorations.add(decoration);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_TYPE,"Plant");
        }

    }

    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Decoration decoration = decorations.findByType(decorationType);
        if(decoration==null){
            throw new IllegalArgumentException(ExceptionMessages.NO_DECORATION_FOUND);
        }else {
            for (Aquarium aquarium : aquariums) {
                if(aquarium.getName().equals(aquariumName)){
                    aquarium.addDecoration(decoration);
                }
            }
            decorations.remove(decoration);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM,decorationType,aquariumName);
        }
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish = null;
        if(!fishType.equals("FreshwaterFish")&&!fishType.equals("SaltwaterFish")){
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FISH_TYPE);
        }else{
            for (Aquarium aquarium : aquariums) {
                if(aquarium.getName().equals(aquariumName)){
                    if(fishType.equals("FreshwaterFish")&&aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")){
                        fish = new FreshwaterFish(fishName,fishSpecies,price);
                        aquarium.addFish(fish);
                    }else if(fishType.equals("SaltwaterFish")&&aquarium.getClass().getSimpleName().equals("SaltwaterAquarium")){
                        fish = new SaltwaterFish(fishName,fishSpecies,price);
                       aquarium.addFish(fish);
                    }else {
                        throw new IllegalArgumentException(ConstantMessages.WATER_NOT_SUITABLE);
                    }
                }
            }
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM,fishType,aquariumName);
        }
    }

    @Override
    public String feedFish(String aquariumName) {
        int count = 0;
        for (Aquarium aquarium : aquariums) {
            if(aquarium.getName().equals(aquariumName)){
                aquarium.feed();
                count =aquarium.getFish().size();
            }
        }
        return String.format(ConstantMessages.FISH_FED,count);
    }

    @Override
    public String calculateValue(String aquariumName) {
        double sum =0;
        for (Aquarium aquarium : aquariums) {
            if(aquarium.getName().equals(aquariumName)){
                sum += aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
                sum +=aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
            }
        }
        return String.format(ConstantMessages.VALUE_AQUARIUM,aquariumName,sum);
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        for (Aquarium aquarium : aquariums) {
            sb.append(aquarium.getInfo());
            sb.append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
