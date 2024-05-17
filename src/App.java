import java.util.Scanner;
public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        GestorCuentas gestor = new GestorCuentas("Cuentas_cheques.txt");
        int opcion;
        do {
            System.out.println("----- MENÚ -----");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Buscar cuenta");
            System.out.println("3. Editar cuenta");
            System.out.println("4. Eliminar cuenta");
            System.out.println("5. Salir");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    gestor.crearCuenta();
                    break;
                case 2:
                    gestor.buscarCuenta();  
                    break;
                case 3:
                    gestor.editarCuenta();
                    break;
                case 4: 
                    gestor.eliminarCuenta();
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 5);
    }
}
