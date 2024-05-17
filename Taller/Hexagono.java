public class Hexagono extends Figuras {
    private int lado;
    private double apotemaH;
    public Hexagono() {
    }
    public Hexagono(int lado, double apotemaH) {
        this.lado = lado;
        this.apotemaH = apotemaH;
    }
    public int getLado() {
        return lado;
    }
    public void setLado(int lado) {
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
