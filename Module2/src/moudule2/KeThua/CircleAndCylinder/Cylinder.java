package moudule2.KeThua.CircleAndCylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){

    }

    public Cylinder(double height){
        this.height = height;
    }

    public Cylinder(String color, double radius, double height) {
        super(color, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume(){
        return this.height*getArea();
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "height=" + height +
                '}';
    }
}
