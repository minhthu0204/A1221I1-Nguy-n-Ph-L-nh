package moudule2.KeThua.PointAndMoveablePoint;

public class Test {
    public static void main(String[] args) {
        Point point=new Point();
        point.setXY(1,2);
        System.out.println(point);
        MoveablePoint moveablePoint=new MoveablePoint();
        moveablePoint.setSpeed(2,3);
        moveablePoint.setXY(1,2);
        System.out.println(moveablePoint);
    }
}
