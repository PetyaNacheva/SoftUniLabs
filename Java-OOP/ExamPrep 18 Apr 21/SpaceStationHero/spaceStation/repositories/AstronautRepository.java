package spaceStation.repositories;

import spaceStation.core.Controller;
import spaceStation.models.astronauts.Astronaut;
import spaceStation.models.astronauts.Biologist;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class AstronautRepository implements Repository<Astronaut>{
    private Map<String, Astronaut>astronauts;

    public AstronautRepository() {
        this.astronauts = new LinkedHashMap<>();
    }

    @Override
    public Collection<Astronaut> getModels() {
        return Collections.unmodifiableCollection(this.astronauts.values());
    }

    @Override
    public void add(Astronaut model) {
        if(!this.astronauts.containsKey(model.getName())){
            this.astronauts.put(model.getName(),model);
        }
    }

    @Override
    public boolean remove(Astronaut model) {
        return  astronauts.entrySet().removeIf(g->g.getKey().equals(model.getName())&&g.getValue().equals(model));
    }

    @Override
    public Astronaut findByName(String name) {
       Astronaut model = this.astronauts.get(name);
        return model;
    }
}
