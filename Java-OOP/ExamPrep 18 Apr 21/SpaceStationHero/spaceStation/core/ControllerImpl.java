package spaceStation.core;

import spaceStation.common.Command;
import spaceStation.common.ConstantMessages;
import spaceStation.common.ExceptionMessages;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;
import spaceStation.models.astronauts.Geodesist;
import spaceStation.models.astronauts.Meteorologist;
import spaceStation.models.mission.Mission;
import spaceStation.models.mission.MissionImpl;
import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

import java.util.*;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private AstronautRepository astronautRepository;
    private PlanetRepository planetRepository;
    private MissionImpl mission;
    private List<Planet>exploredPlanets;


    public ControllerImpl() {
        this.astronautRepository = new AstronautRepository();
        this.planetRepository = new PlanetRepository();
        this.mission = new MissionImpl();
    }

    @Override
    public String addAstronaut(String type, String astronautName) {
        if(type.equals("Biologist")){
           Astronaut astronaut = new Biologist(astronautName);
            astronautRepository.add(astronaut);
        }else if(type.equals("Geodesist")){
            Astronaut astronaut = new Geodesist(astronautName);
            astronautRepository.add(astronaut);
        }else if(type.equals("Meteorologist")){
           Astronaut astronaut = new Meteorologist(astronautName);
            astronautRepository.add(astronaut);
        }
        if(!type.equals("Biologist")&&!type.equals("Geodesist")&&!type.equals("Meteorologist")){
            return ExceptionMessages.ASTRONAUT_INVALID_TYPE;
        }else {
            return String.format(ConstantMessages.ASTRONAUT_ADDED,type,astronautName);
        }
    }

    @Override
    public String addPlanet(String planetName, String... items) {

        Planet planet = new PlanetImpl(planetName,items);
        planetRepository.add(planet);
        return String.format(ConstantMessages.PLANET_ADDED,planetName);
    }

    @Override
    public String retireAstronaut(String astronautName) {
        Astronaut astronaut = astronautRepository.findByName(astronautName);
        if(astronautRepository.remove(astronaut)){
            return String.format(ConstantMessages.ASTRONAUT_RETIRED,astronautName);
        }else{
            return String.format(ExceptionMessages.ASTRONAUT_DOES_NOT_EXIST,astronautName);
        }
    }

    @Override
    public String explorePlanet(String planetName) {
        Collection<Astronaut> astronauts = new ArrayList<>();
        for (Astronaut model : astronautRepository.getModels()) {
            if(model.getOxygen()>=60){
                astronauts.add(astronautRepository.findByName(model.getName()));
            }
        }
        Planet planet =planetRepository.findByName(planetName);
        if(astronauts.size()==0){
            return ExceptionMessages.PLANET_ASTRONAUTS_DOES_NOT_EXISTS;
        }else {
            int count =0;
            mission.explore(planet, astronauts);
                for (Astronaut astronaut : astronauts) {
                    if (astronaut.getOxygen() == 0) {
                        count++;
                    }
            }
                exploredPlanets.add(planet);
            return String.format(ConstantMessages.PLANET_EXPLORED,planetName,count);
        }
    }

    @Override
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d planets were explored!",exploredPlanets.size()));
        sb.append(System.lineSeparator());
        sb.append("Astronauts info:");
        sb.append(System.lineSeparator());
        for (Astronaut astronaut : astronautRepository.getModels()) {
            sb.append(astronaut.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
