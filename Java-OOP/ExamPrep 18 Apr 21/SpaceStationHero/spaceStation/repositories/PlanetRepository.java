package spaceStation.repositories;

import spaceStation.models.planets.Planet;
import spaceStation.models.planets.PlanetImpl;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PlanetRepository implements Repository<Planet> {
    private Map<String, Planet> planets;

    public PlanetRepository() {
        this.planets = new LinkedHashMap<>();
    }

    @Override
    public Collection<Planet> getModels() {
        return Collections.unmodifiableCollection(this.planets.values());
    }

    @Override
    public void add(Planet model) {
        if(!this.planets.containsKey(model.getName())){
            this.planets.put(model.getName(),model);
        }
    }

    @Override
    public boolean remove(Planet model) {
        return planets.entrySet().removeIf(g->g.getKey().equals(model.getName())&&g.getValue().equals(model));
    }

    @Override
    public Planet findByName(String name) {
        Planet model = this.planets.get(name);
        return model;
    }
}
