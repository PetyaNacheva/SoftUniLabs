package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static double OXYGEN = 70;
    public Biologist(String name) {
        super(name, OXYGEN);
    }

    @Override
    public void breath() {
        OXYGEN -=10;
    }

}
