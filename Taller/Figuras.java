public class Figuras {
    private double Area;
    private double Perimetro;
    private double Promedio;
    public Figuras() {
    }
    public Figuras(double area, double perimetro, double promedio) {
        Area = area;
        Perimetro = perimetro;
        Promedio = promedio;
    }
    public double getArea() {
        return Area;
    }
    public void setArea(double area) {
        Area = area;
    }
    public double getPerimetro() {
        return Perimetro;
    }
    public void setPerimetro(double perimetro) {
        Perimetro = perimetro;
    }
    public double getPromedio() {
        return Promedio;
    }
    public void setPromedio(double promedio) {
        Promedio = promedio;
    }
    @Override
    public String toString() {
        return "Figuras [Area=" + Area + ", Perimetro=" + Perimetro + ", Promedio=" + Promedio + "]";
    } 

}
   









  
  

