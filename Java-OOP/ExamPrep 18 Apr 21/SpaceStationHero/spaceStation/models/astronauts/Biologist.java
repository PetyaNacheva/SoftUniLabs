package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut{
    private static double oxygen =70;
    public Biologist(String name) {
        super(name,oxygen);
    }

    @Override
    public boolean canBreath() {
        if(getOxygen()-5>=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void breath() {
        if(oxygen-5>=0) {
            oxygen -= 5;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s",getName()));
        sb.append(System.lineSeparator());
        sb.append(String.format("Oxygen: %.2f",getOxygen()));
        sb.append(System.lineSeparator());
        if(getBag().getItems().size()==0){
            sb.append("none");
        }else {
            sb.append("Bag items: ");
        }
        for (String item : getBag().getItems()) {
           sb.append(item+", ");
        }
        String result = sb.substring(0,sb.length()-2);

        return result.trim();
    }
}
