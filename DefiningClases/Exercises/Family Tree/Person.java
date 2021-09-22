package Advanced.DefiningClasses.Exe.FamilyTree;

import java.util.*;

public class Person {
    private String name;
    private String birthDate;
    private final List<Person> parents = new ArrayList<>();
    private final List<Person> children = new ArrayList<>();

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void addChild(Person child) {
        children.add(child);
        child.parents.add(this);
    }
    public List<Person> getParents() {
        return Collections.unmodifiableList(parents);
    }
    public List<Person> getChildren() {
        return Collections.unmodifiableList(children);
    }

    @Override
    public String toString() {
        return name + " " + birthDate;
    }
}
