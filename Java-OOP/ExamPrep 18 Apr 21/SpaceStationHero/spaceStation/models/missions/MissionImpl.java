package spaceStation.models.mission;

import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.bags.Backpack;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.*;
import java.util.Collection;

public class MissionImpl implements Mission{
    private List<PlanetRepository>planetsToExplore;
    private List<AstronautRepository> astronauts;
    private List<Planet>exploredPlanet;

    public MissionImpl() {
        this.astronauts = new ArrayList<>();
        this.planetsToExplore = new ArrayList<>();
    }

    @Override
    public void explore(Planet planet, Collection<Astronaut> astronauts) {
        for (Astronaut astronaut : astronauts) {
            if(astronaut.canBreath()){
                for (String items: planet.getItems()) {
                    astronaut.breath();
                    astronaut.getBag().addItems(items);
                    planet.getItems().remove(items);
                    if(planet.getItems().size()==0){
                        exploredPlanet.add(planet);
                        break;
                    }
                }
            }
        }
    }
}
