package Advanced.DefiningClasses.Exe.Google;

import java.util.*;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents>parentsList;
    private List<Children>childrenList;
    private List<Pokemon>pokemonList;


    public Person(String name, Company company,Car car){
        this.name = name;
        this.company = company;
        this.car = car;
        this.parentsList = new ArrayList<>();
        this.childrenList =new ArrayList<>();
        this.pokemonList =new ArrayList<>();
    }

    public List<Parents> getParentsList() {
        return parentsList;
    }

    public List<Children> getChildrenList() {
        return childrenList;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public Company getCompany() {
        return company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
