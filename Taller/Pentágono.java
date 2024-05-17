public class Pentagono {
    private int ladoP;
    private double apotemaP;
    
    public Pentagono() {
    }

    public Pentagono(int ladoP, double apotemaP) {
        this.ladoP = ladoP;
        this.apotemaP = apotemaP;
    }

    public int getLadoP() {
        return ladoP;
    }

    public void setLado(int ladoP) {
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

