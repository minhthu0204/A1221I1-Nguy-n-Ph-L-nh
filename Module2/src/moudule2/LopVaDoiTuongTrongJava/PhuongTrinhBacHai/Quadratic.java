package moudule2.LopVaDoiTuongTrongJava.PhuongTrinhBacHai;

public class Quadratic {
    private double a;
    private double b;
    private double c;
    private double delta;

    public Quadratic(double a, double b, double c ){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant(){
            this.delta = (this.b * this.b - 4 * this.a * this.c);
            return this.delta;
        }

        public double getRoot1() {
            return (-this.b + Math.pow(this.delta,0.5)) / (2 * this.a);
        }

        public double getRoot2() {
            return (- this.b - Math.pow(this.delta,0.5)) / (2 * this.a);
        }

}
