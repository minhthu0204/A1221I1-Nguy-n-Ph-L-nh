package moudule2.KeThua.PointAndMoveablePoint;

public class MoveablePoint extends Point {
    public float xSpeed=0;
    public float ySpeed=0;

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }
    public float[]getSpeed(){
        float[]temp=new float[2];
        temp[0]=this.xSpeed;
        temp[1]=this.ySpeed;
        return temp;
    }
    @Override
    public String toString() {
        return "MoveablePoint: x = " + this.x + ", y = " + this.y+", speed = ("+this.xSpeed+","+this.ySpeed+")";
    }

    public MoveablePoint move(){
        this.x += this.xSpeed;
        this.y += this.ySpeed;
        return this;
    }

}
