public class Rombo extends Figuras  {
    private int ladoo;
    private double DMay;
    private double dmen;
    public Rombo() {
    }
    public Rombo(int ladoo, double dMay, double dmen) {
        this.ladoo = ladoo;
        DMay = dMay;
        this.dmen = dmen;
    }
    public int getLadoo() {
        return ladoo;
    }
    public void setLadoo(int ladoo) {
        this.ladoo = ladoo;
    }
    public double getDMay() {
        return DMay;
    }
    public void setDMay(double dMay) {
        DMay = dMay;
    }
    public double getDmen() {
        return dmen;
    }
    public void setDmen(double dmen) {
        this.dmen = dmen;
    }
    @Override
    public String toString() {
        return "Rombo [ladoo=" + ladoo + ", DMay=" + DMay + ", dmen=" + dmen + "]";
    }

    
    
}
