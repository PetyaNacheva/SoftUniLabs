package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.*;

public class ExplorerRepository implements Repository<Explorer>{
    private Set<Explorer> explorers;

    public ExplorerRepository() {
        this.explorers =new LinkedHashSet<>();
    }

    @Override
    public Collection<Explorer> getCollection() {
        return Collections.unmodifiableCollection(this.explorers);
    }

    @Override
    public void add(Explorer entity) {
    this.explorers.add(entity);
    }

    @Override
    public boolean remove(Explorer entity) {
        return this.explorers.remove(entity);
    }

    @Override
    public Explorer byName(String name) {
        return this.explorers.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
    }
}
