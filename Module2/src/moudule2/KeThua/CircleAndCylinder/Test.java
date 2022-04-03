package moudule2.KeThua.CircleAndCylinder;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle("red",8);
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(16);
        System.out.println(cylinder);

        System.out.println(circle.getArea());

        System.out.println(cylinder.getVolume());
    }
}
