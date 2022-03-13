package src.Java;

import src.Java.core.ControllerImpl;
import src.Java.core.EngineImpl;
import src.Java.core.interfaces.Controller;
import src.Java.core.interfaces.Engine;

public class Main {
    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();
    }
}
