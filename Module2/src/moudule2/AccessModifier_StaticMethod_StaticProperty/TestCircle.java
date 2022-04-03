package moudule2.AccessModifier_StaticMethod_StaticProperty;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle();

        circle.getRadius();
        circle.getArea();
        System.out.println(circle.radius);
        System.out.println(circle.getArea());

    }
}
