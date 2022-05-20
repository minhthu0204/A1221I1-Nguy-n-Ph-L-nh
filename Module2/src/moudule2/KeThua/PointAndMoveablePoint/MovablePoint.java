package moudule2.KeThua.PointAndMoveablePoint;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(){

    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed ){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        float[] xSpeedYSpeed = {xSpeed, ySpeed};
        return xSpeedYSpeed;
    }

    @Override
    public String toString() {
        return "MovablePoint: x = " + this.x + ", y = " + this.y+", speed = ("+this.xSpeed+","+this.ySpeed+")";
    }

    public float move(){
        this.x += xSpeed;
        this.y += ySpeed;
        return this.x;
    }
}
