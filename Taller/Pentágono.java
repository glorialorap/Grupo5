public class Pentagono extends Figuras  {
    private double ladoP;
    private double apotemaP;
    
    public Pentagono() {
    }

    public Pentagono(double ladoP, double apotemaP) {
        this.ladoP = ladoP;
        this.apotemaP = apotemaP;
    }

    public double getLadoP() {
        return ladoP;
    }

    public void setLado(double ladoP) {
        this.ladoP = ladoP;
    }

    public double getApotemaP() {
        return apotemaP;
    }

    public void setApotema(doble apotemaP) {
        this.apotemaP = apotemaP;
    }

    @Override
    public String toString() {
        return "Pentagono [lado=" + ladoP + ", apotema=" + apotemaP + "]";
    }    
}

