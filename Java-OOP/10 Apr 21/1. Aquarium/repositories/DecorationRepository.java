package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository{
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
    decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        Decoration decorationToRemove = null;
        for (Decoration decoration1 : decorations) {
            if(decoration1.getClass().getSimpleName().equals(decoration.getClass().getName())){
                decorationToRemove = decoration1;
            }
        }
        if(decorationToRemove!=null){
            decorations.remove(decorationToRemove);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Decoration findByType(String type) {
       return decorations.stream().filter(e->e.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
