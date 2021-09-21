package Advanced.DefiningClasses.Exe.CatLady;

public class StreetExtraordinaire extends Cats{
    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    public double getDecibelsOfMeows() {
        return decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f",getClass().getSimpleName(),getName(),getDecibelsOfMeows());
    }
}
