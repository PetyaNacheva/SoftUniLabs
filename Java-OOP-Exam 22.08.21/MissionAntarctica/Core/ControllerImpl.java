package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private Repository<Explorer>explorerRepository;
    private Repository<State>stateRepository;
    private Mission mission;
    private int exploredStates;

    public ControllerImpl() {
        this.explorerRepository = new ExplorerRepository();
        this.stateRepository = new StateRepository();
        this.mission = new MissionImpl();
        this.exploredStates=0;
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        switch (type){
            case "AnimalExplorer":
                this.explorerRepository.add(new AnimalExplorer(explorerName));
                break;
            case "GlacierExplorer":
                this.explorerRepository.add(new GlacierExplorer(explorerName));
                break;
            case "NaturalExplorer":
                this.explorerRepository.add(new NaturalExplorer(explorerName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        return String.format(ConstantMessages.EXPLORER_ADDED,type,explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        Collection<String> stateItems = state.getExhibits();
        Collections.addAll(stateItems,exhibits);
        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED,stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);
        if(explorer==null){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST,explorerName));
        }
        this.explorerRepository.remove(explorer);

        return String.format(ConstantMessages.EXPLORER_RETIRED,explorerName);
    }

    @Override
    public String exploreState(String stateName) {
            Collection<Explorer>explorers = this.explorerRepository.getCollection().stream()
                .filter(e->e.getEnergy()>50)
                .collect(Collectors.toCollection(ArrayList::new));
        if(explorers.size()==0){
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        State state = this.stateRepository.byName(stateName);
        this.mission.explore(state,explorers);
        exploredStates++;
        long died = explorers.stream().filter(e->e.getEnergy()==0).count();

        return String.format(ConstantMessages.STATE_EXPLORER,state.getName(),died);
    }

    @Override
    public String finalResult() {
        StringBuilder result = new StringBuilder(String.format(ConstantMessages.FINAL_STATE_EXPLORED,this.exploredStates));
        result.append(System.lineSeparator()).append(ConstantMessages.FINAL_EXPLORER_INFO);
        for (Explorer model : this.explorerRepository.getCollection()) {
        result.append(System.lineSeparator());
        result.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, model.getName()));
        result.append(System.lineSeparator());
        result.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, model.getEnergy()));
        result.append(System.lineSeparator());
        if (model.getSuitcase().getExhibits().size() == 0) {
        result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
        } else {
        result.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, model.getSuitcase().getExhibits())));
       }
        }
        return result.toString().trim();
    }

}
