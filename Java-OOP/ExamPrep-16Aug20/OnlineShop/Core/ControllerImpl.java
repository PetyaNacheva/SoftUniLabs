package onlineShop.core;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.common.constants.OutputMessages;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component>components;
    private Map<Integer,Peripheral>peripherals;

    public ControllerImpl() {
        this.computers = new HashMap<>();
        this.peripherals = new HashMap<>();
        this.components = new HashMap<>();
    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Computer computer;
        if(computers.containsKey(id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_COMPUTER_ID);
        }
       if(computerType.equals("Laptop")){
       computer = new Laptop(id,manufacturer,model,price);
       }else if(computerType.equals("DesktopComputer")){
       computer = new DesktopComputer(id,manufacturer,model,price);
       }else{
           throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPUTER_TYPE);
       }
        computers.put(id,computer);

        return String.format(OutputMessages.ADDED_COMPUTER,id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        Peripheral peripheral;

        switch (peripheralType){
            case "Headset":
                peripheral= new Headset(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Keyboard":
                peripheral = new Keyboard(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id,manufacturer,model,price,overallPerformance,connectionType);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_PERIPHERAL_TYPE);
        }
        if(peripherals.containsKey(id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }
            peripherals.put(peripheral.getId(),peripheral);
            computers.get(computerId).addPeripheral(peripheral);
        return String.format(OutputMessages.ADDED_PERIPHERAL,peripheralType,id,computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Peripheral peripheral = computers.get(computerId).removePeripheral(peripheralType);
        peripherals.remove(peripheral.getId());
        return String.format(OutputMessages.REMOVED_PERIPHERAL,peripheralType,peripheral.getId());
    }

    @Override
    public String addComponent(int computerId, int id, String componentType, String manufacturer, String model, double price, double overallPerformance, int generation) {
        Component component;
        switch (componentType){
            case "CentralProcessingUnit":
                component= new CentralProcessingUnit(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "Motherboard":
                component =new Motherboard(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id,manufacturer,model,price,overallPerformance,generation);
                break;
            case "VideoCard":
                component = new VideoCard(id,manufacturer,model,price,overallPerformance,generation);
                break;
            default: throw new IllegalArgumentException(ExceptionMessages.INVALID_COMPONENT_TYPE);

        }
        if(components.containsKey(id)){
            throw new IllegalArgumentException(ExceptionMessages.EXISTING_PERIPHERAL_ID);
        }

        components.put(component.getId(),component);
        computers.get(computerId).addComponent(component);
        return String.format(OutputMessages.ADDED_COMPONENT,componentType,id,computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Component component = computers.get(computerId).removeComponent(componentType);
        components.remove(component.getId());
        return String.format(OutputMessages.REMOVED_COMPONENT,componentType,component.getId());
    }

    @Override
    public String buyComputer(int id) {
        Computer computer=null;
        if(!computers.containsKey(id)){
         throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        computer = computers.remove(id);
        return computer.toString();
    }

    @Override
    public String BuyBestComputer(double budget) {
        List<Computer> filtered =computers.values().stream().filter(c->c.getPrice()<=budget)
                .sorted(Comparator.comparing(Computer::getPrice).reversed()).collect(Collectors.toList());
        if(filtered.isEmpty()){
            throw new IllegalArgumentException(String.format(ExceptionMessages.CAN_NOT_BUY_COMPUTER,budget));
        }
        Computer computer =filtered.get(0);
        computers.remove(computer.getId());
        return computer.toString();
    }

    @Override
    public String getComputerData(int id) {
        if(!computers.containsKey(id)){
            throw new IllegalArgumentException(ExceptionMessages.NOT_EXISTING_COMPUTER_ID);
        }
        return computers.get(id).toString();
    }
}
