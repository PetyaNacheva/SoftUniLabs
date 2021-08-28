package glacialExpedition.models.mission;

import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.states.State;

import java.util.*;
import java.util.Collection;

public class MissionImpl implements Mission{

    @Override
    public void explore(State state, Collection<Explorer> explorers) {
        for (Explorer explorer : explorers) {
            if(explorer.canSearch()){
                List<String>collected = new ArrayList<>(state.getExhibits());
                for (String items : collected) {
                    explorer.getSuitcase().getExhibits().add(items);
                    state.getExhibits().remove(items);
                    explorer.search();

                    if(!explorer.canSearch()){
                        break;
                    }
                }
            }
        }
    }
}
