package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.*;

public class StateRepository implements Repository<State>{
    private Set<State> states;

    public StateRepository() {
        this.states = new LinkedHashSet<>();
    }

    @Override
    public Collection<State> getCollection() {
        return Collections.unmodifiableCollection(this.states);
    }

    @Override
    public void add(State entity) {
    this.states.add(entity);
    }

    @Override
    public boolean remove(State entity) {
        return this.states.remove(entity);
    }

    @Override
    public State byName(String name) {
        return this.states.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
    }
}
