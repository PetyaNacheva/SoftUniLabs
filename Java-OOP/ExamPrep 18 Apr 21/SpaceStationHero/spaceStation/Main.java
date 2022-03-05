package spaceStation;

import spaceStation.core.Controller;
import spaceStation.core.ControllerImpl;
import spaceStation.core.Engine;
import spaceStation.core.EngineImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
     Controller controller = new ControllerImpl();
     Engine engine = new EngineImpl(controller);
     engine.run();
    }
}
