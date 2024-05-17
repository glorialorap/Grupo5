import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Figuras figuras = new Figuras(0,0,0);
        Hexagono hexagono = new Hexagono(0,0);
        Pentagono pentagono = new Pentagono(0, 0);
        
        // Pentágono
        System.out.println("Ingrese el lado del pentágono:");
        double ladoP = inputPositivo(scanner);
        System.out.println("Ingrese la apotema del pentágono:");
        double apotemaP = inputPositivo(scanner);

        pentagono.setLadoP(ladoP);
        pentagono.setApotemaP(apotemaP);
    
        Function<Double, Double> perimetroPentagono = (lado) -> 5 * ladoP;
        System.out.println("Perímetro del Pentágono: " + perimetroPentagono.apply(ladoP));
        
        BiFunction<Double, Double, Double> areaPentagono = (perimetro, apotema) -> (perimetro * apotema) / 2;
        System.out.println("Área del Pentágono: " + areaPentagono.apply(perimetroPentagono.apply(ladoP), apotemaP));

        // Hexagono
        System.out.println("Ingrese el lado del Hexágono:");
        double lado = inputPositivo(scanner);
        System.out.println("Ingrese la apotema del Hexágono:");
        double apotemaH = inputPositivo(scanner);

        hexagono.setLado(lado);
        hexagono.setApotemaH(apotemaH);

        Function<Double, Double> perimetroHexagono = (lad) -> 6 * lado;
        System.out.println("Perímetro del Hexágono: " + perimetroHexagono.apply(lado));

        BiFunction<Double, Double, Double> areaHexagono = (perimetro, apotema) -> (perimetro * apotema) / 2;
        System.out.println("Área del Hexágono: " + areaHexagono.apply(perimetroHexagono.apply(lado), apotemaH));

        
        double umbralArea = 10.2;
            Stream.of(areaPentagono, areaHexagono, areaParalelograma, areaRombo)
                .filter(area -> area > )
                .forEach(area -> System.out.println("Figura con área mayor a " + umbralArea + ": " + area));
   
    }

    public static double inputPositivo(Scanner scanner) {
        double valor;
        while (true) {
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor > 0) {
                    return valor;
                } else {
                    System.out.println("El valor debe ser positivo. Inténtelo de nuevo:");
                }
            } else {
                System.out.println("Por favor, ingrese un número válido:");
                scanner.next(); // Limpiar la entrada no válida
            }
        }
    }
}

// Interfaz funcional para una función con tres argumentos
@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
