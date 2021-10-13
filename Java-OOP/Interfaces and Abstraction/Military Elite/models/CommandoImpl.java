package MilitaryElite2.models;

import MilitaryElite2.enumerations.Corp;
import MilitaryElite2.interfaces.Commando;
import MilitaryElite2.interfaces.Mission;

import java.util.*;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corp corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(System.lineSeparator()).append(this.getCorps())
                .append(System.lineSeparator()).append("Missions:");
        for (Mission mission: this.missions) {
            sb.append(System.lineSeparator());
            sb.append("  ").append(mission.toString());
        }
        return sb.toString();
    }
}
