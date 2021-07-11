package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length,double width,double height){
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    public double getLength() {
        return length;
    }

    private void setLength(double length) {
        if(length<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    private void setWidth(double width) {
        if(width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    private void setHeight(double height) {
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }
    public double calculateSurfaceArea(){
        double surfaceArea = 2*(getLength()*getWidth())+calculateLateralSurfaceArea();
    return surfaceArea;
    }
    public double calculateLateralSurfaceArea(){
        double lateralSurface = 2*(getLength()*getHeight()) + 2*(getWidth()*getHeight());
        return lateralSurface;
    }
    public double calculateVolume(){
        double volume = getLength()*getWidth()*getHeight();
        return volume;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                "Lateral Surface Area - %.2f%n" +
                "Volume – %.2f",calculateSurfaceArea(),calculateLateralSurfaceArea(),calculateVolume());
    }
}
