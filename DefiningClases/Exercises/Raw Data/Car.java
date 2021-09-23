package Advanced.DefiningClasses.Exe.RawData;

import java.util.*;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private List<Tire> tireList;

    public Car(String model, Engine engine, Cargo cargo, List<Tire> tireList) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tireList = new ArrayList<>();
    }

    public String getModel() {
        return model;
    }
}
