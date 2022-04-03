package moudule2.KeThua.Point2DAndPoint3D;

public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        point2D = new Point2D(1,2);
        System.out.println(point2D);

        Point3D point3D = new Point3D();
        point3D.setX(1);
        point3D.setY(2);
        point3D.setZ(3);
        System.out.println(point3D);

        point3D = new Point3D(4,5,6);
        System.out.println(point3D);
    }
}
