import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.Scanner;
import java.lang.Math;

public class App {
    public static void main(String[] args) {
        // Inicializar scanner para ingreso de datos
        Scanner scanner = new Scanner(System.in);
        

        // Pentágono
        System.out.println("Ingrese el lado del pentágono:");
        double ladoPentagono = inputPositivo(scanner);

        Function<Double, Double> areaPentagono = (a) -> (5.0 / 4.0) * Math.pow(a, 2) * (1 / Math.tan(Math.PI / 5));
        Function<Double, Double> perimetroPentagono = (a) -> 5 * a;
        Function<Double, Double> promedioPentagono = (a) -> (areaPentagono.apply(a) + perimetroPentagono.apply(a)) / 2;

        System.out.println("Área del Pentágono: " + areaPentagono.apply(ladoPentagono));
        System.out.println("Perímetro del Pentágono: " + perimetroPentagono.apply(ladoPentagono));
        System.out.println("Promedio Área-Perímetro del Pentágono: " + promedioPentagono.apply(ladoPentagono));

        // Hexágono
        System.out.println("Ingrese el lado del hexágono:");
        double ladoHexagono = inputPositivo(scanner);

        Function<Double, Double> areaHexagono = (a) -> (3 * Math.sqrt(3) / 2) * Math.pow(a, 2);
        Function<Double, Double> perimetroHexagono = (a) -> 6 * a;
        Function<Double, Double> promedioHexagono = (a) -> (areaHexagono.apply(a) + perimetroHexagono.apply(a)) / 2;

        System.out.println("Área del Hexágono: " + areaHexagono.apply(ladoHexagono));
        System.out.println("Perímetro del Hexágono: " + perimetroHexagono.apply(ladoHexagono));
        System.out.println("Promedio Área-Perímetro del Hexágono: " + promedioHexagono.apply(ladoHexagono));

        // Paralelogramo
        System.out.println("Ingrese la base del paralelogramo:");
        double baseParalelogramo = inputPositivo(scanner);
        System.out.println("Ingrese la altura del paralelogramo:");
        double alturaParalelogramo = inputPositivo(scanner);
        System.out.println("Ingrese el lado del paralelogramo:");
        double ladoParalelogramo = inputPositivo(scanner);

        BiFunction<Double, Double, Double> areaParalelogramo = (b, h) -> b * h;
        BiFunction<Double, Double, Double> perimetroParalelogramo = (a, b) -> 2 * (a + b);
        TriFunction<Double, Double, Double, Double> promedioParalelogramo = (a, b,
                h) -> (areaParalelogramo.apply(b, h) + perimetroParalelogramo.apply(a, b)) / 2;

        System.out
                .println("Área del Paralelogramo: " + areaParalelogramo.apply(baseParalelogramo, alturaParalelogramo));
        System.out.println(
                "Perímetro del Paralelogramo: " + perimetroParalelogramo.apply(ladoParalelogramo, baseParalelogramo));
        System.out.println("Promedio Área-Perímetro del Paralelogramo: "
                + promedioParalelogramo.apply(ladoParalelogramo, baseParalelogramo, alturaParalelogramo));

        // Rombo
        System.out.println("Ingrese la diagonal mayor del rombo:");
        double diagonalMayorRombo = inputPositivo(scanner);
        System.out.println("Ingrese la diagonal menor del rombo:");
        double diagonalMenorRombo = inputPositivo(scanner);
        System.out.println("Ingrese el lado del rombo:");
        double ladoRombo = inputPositivo(scanner);

        BiFunction<Double, Double, Double> areaRombo = (D, d) -> (D * d) / 2;
        Function<Double, Double> perimetroRombo = (a) -> 4 * a;
        TriFunction<Double, Double, Double, Double> promedioRombo = (a, D,
                d) -> (areaRombo.apply(D, d) + perimetroRombo.apply(a)) / 2;

        System.out.println("Área del Rombo: " + areaRombo.apply(diagonalMayorRombo, diagonalMenorRombo));
        System.out.println("Perímetro del Rombo: " + perimetroRombo.apply(ladoRombo));
        System.out.println("Promedio Área-Perímetro del Rombo: "
                + promedioRombo.apply(ladoRombo, diagonalMayorRombo, diagonalMenorRombo));
    }

    // Método para validar ingreso positivo
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
