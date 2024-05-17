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
        
        
        // Paraelograma
        System.out.println("Ingrese la base del paralelograma:");
        double base = inputPositivo(scanner);
        System.out.println("Ingrese la altura del paralelograma:");
        double altura = inputPositivo(scanner);

        paralelograma.setBase(base);
        paralelograma.setAltura(altura);

        Function<Double, Double> perimetroParalelograma = (lado2) -> 2 * (base + altura);
        System.out.println("Perímetro del Paralelograma: " + perimetroParalelograma.apply(base));

        BiFunction<Double, Double, Double> areaParalelograma = (bas, altur) -> base * altura;
        System.out.println("Área del Paralelograma: " + areaParalelograma.apply(base, altura));

        // Rombo
        System.out.println("Ingrese el lado del rombo:");
        double lado1 = inputPositivo(scanner);
        System.out.println("Ingrese la diagonal menor del rombo:");
        double dm = inputPositivo(scanner);
        System.out.println("Ingrese la diagonal mayor del rombo:");
        double dM = inputPositivo(scanner);

        rombo.setLadoo(lado1);
        rombo.setDmen(dm);
        rombo.setDMay(dM);

        Function<Double, Double> perimetroRombo = (lado3) -> 4 * lado;
        System.out.println("Perímetro del Rombo: " + perimetroRombo.apply(lado));

        BiFunction<Double, Double, Double> areaRombo = (diagonalMenor, diagonalMayor) -> (diagonalMenor * diagonalMayor) / 2;
        System.out.println("Área del Rombo: " + areaRombo.apply(dm, dM));

        
        
        double areaF = 10.2;
            Stream.of(areaPentagono, areaHexagono, areaParalelograma, areaRombo)
                .filter(area -> area > areaF )
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
