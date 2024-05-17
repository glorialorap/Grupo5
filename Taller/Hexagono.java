public class Hexagono extends Figuras {
    private double lado;
    private double apotemaH;
    public Hexagono() {
    }
    public Hexagono(double lado, double apotemaH) {
        this.lado = lado;
        this.apotemaH = apotemaH;
    }
    public double getLado() {
        return lado;
    }
    public void setLado(double lado) {
        this.lado = lado;
    }
    public double getApotemaH() {
        return apotemaH;
    }
    public void setApotemaH(double apotemaH) {
        this.apotemaH = apotemaH;
    }
    @Override
    public String toString() {
        return "Hexagono [lado=" + lado + ", apotemaH=" + apotemaH + "]";
    }


    

}
