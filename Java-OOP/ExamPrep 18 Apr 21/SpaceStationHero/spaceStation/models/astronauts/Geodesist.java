package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut{

    public Geodesist(String name) {
        super(name, 50);
    }

    @Override
    public void breath() {
        super.breath();
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
