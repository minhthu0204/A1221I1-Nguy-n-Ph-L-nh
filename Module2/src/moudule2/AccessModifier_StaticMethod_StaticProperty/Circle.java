package moudule2.AccessModifier_StaticMethod_StaticProperty;

public class Circle {
    public double radius = 1.0;
    private String color = "red";


    public Circle(){

    }

    public void Circle(double r) {
        this.radius = r;
    }

    public double getRadius(){
        return this.radius;
    }

    public double getArea(){
        return this.radius*this.radius*Math.PI;
    }


}
