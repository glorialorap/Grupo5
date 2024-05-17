import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
public class GestorCuentas extends Cuentas {

    Scanner teclado = new Scanner(System.in); 

    private File archivo;

    public GestorCuentas(String nombreArchivo) { // Este constructor nos ayuda a ejecutar el programa principal haciendo uso de esta clase. 
        this.archivo = new File(nombreArchivo);
    }

    public void crearCuenta() {
        try { //Aquí empieza un bloque TRY CATCH que es para manejar excepciones
            //La clase FILEWRITER se utiliza para escribir datos en un archivo de texto, se encraga de abrir y escribir en el.
            FileWriter fileWriter = new FileWriter("cuentas_cheques.txt", true);  
            //se utiliza para escribir texto formateado en el archivo(PRINTWRITER es una clase que se usa para escribir cualquier forma de datos.)
            PrintWriter printWriter = new PrintWriter(fileWriter); 
            // Estamos pidiendo datos por teclado.
            System.out.println("Ingrese los siguientes datos");
            System.out.println("Ingrese su número de cuenta: ");
            String numeroCuenta = teclado.next();
            System.out.println("Ingrese su nombre: ");
            String nombreCliente = teclado.next();
            System.out.println("Ingrese su número de cédula: ");
            String ced = teclado.next();
            System.out.println("Ingrese su saldo: ");
            String saldo = teclado.next();
            System.out.println("Ingrese su dirección: ");
            String direccion = teclado.next();
            System.out.println("Ingrese su profesión: ");
            String Profesion = teclado.next();
            System.out.println("Ingrese su estado civil: ");
            String eCivil = teclado.next();

            //Esta línea esta creando el nuevo objeto en el archivo.
            printWriter.println(numeroCuenta + "," + nombreCliente + "," + ced +","+ saldo + "," + direccion+"," + Profesion + "," + eCivil + "," );
            printWriter.close(); //Esta línea cierra el objeto; Es importante cerrar los recursos de entrada y salida.
            //para liberar los recursos del sistema.

            // Las siguientes 4 líneas son las excepciones del bloque Try Catch
            System.out.println("Cuenta creada correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
//La anterior linea  mostrará en la consola el orden de métodos que se han llamado hasta el punto
// donde ocurrió la excepción, esto es útil para identificar la causa del error y corregirlo más fácilmente.
        }
    }


    public void buscarCuenta() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("cuentas_cheques.txt"));
            //El FileReader se encarga de convertir los bytes del archivo en caracteres.
            //El BufferedReader envuelve al FileReader en un objeto 
            //El BufferedReader tiene almacenamiento temporal y la capacidad de leer por bloque de caracteres y no solo uno a la vez.
            System.out.print("Ingrese el número de cuenta a buscar: ");
            int numCBuscar = teclado.nextInt();

            String Actual; //va a tener una línea de texto del archivo de cuentas bancarias.
            boolean busc = false;
            while ((Actual = reader.readLine()) != null) { // Se ejecuta mientras haya líneas de texto que leer del archivo. 
                //Cada línea de texto se lee y se almacena en la variable Actual.
                String[] cuentass = Actual.split(","); // Split se lo utiliza para dividir una cadena, en este caso con una coma " , ".
                int numeroCuenta = Integer.parseInt(cuentass[0]);//Esta línea de código convierte una cadena de
                // texto en un número entero utilizando el método "parseInt"
                if (numeroCuenta == numCBuscar) { //Si la condicion es verdadera va a mostrar lo siguiente
                    busc = true;
                    System.out.println("--- Cuenta encontrada ---");
                    System.out.println("Número de cuenta: " + cuentass[0]);
                    System.out.println("Nombre del cliente: " + cuentass[1]);
                    System.out.println("Saldo: " + cuentass[2]);
                    System.out.println("Dirección: " + cuentass[3]);
                    System.out.println("Número de cédula: " + cuentass[4]);
                    System.out.println("Profesión: " + cuentass[5]);
                    System.out.println("Estado civil: " + cuentass[6]);
                    break;
                }
            } 
            reader.close();//cierre del archivo "cuentas_cheques.txt".(Pasa algo similar como en la línea 43) 
             //Si es falsa o no encuentra nada, va a lanzar cualquiera de estas excepciones según sea el caso.
            if (!busc) {
                System.out.println("No se encontró ninguna cuenta con ese número.");
            }
        } catch (IOException e) {
            System.out.println("Error al buscar la cuenta.");
            e.printStackTrace();
        }
    }

    public void eliminarCuenta() {
        try {
            File CUENTAS = new File("cuentas_cheques.txt");//"CUENTAS" representa el archivo llamado "cuentas_cheques.txt" en un objeto File.
            File TEMPOR = new File("temp_cuentas_cheques.txt"); //"TEMPOR" se utilizará temporalmente para algun manejo de operaciones de archivos.

            BufferedReader leer = new BufferedReader(new FileReader(CUENTAS));//Lee el contenido del archivo de entrada y 
            //Se utiliza FILEREADER para abrir un flujo de lectura desde el archivo "CUENTAS".
            PrintWriter escribir = new PrintWriter(new FileWriter(TEMPOR)); // Se crea el objeto para poder escribir en el archivo.
            //Se utiliza FILEWRITER para abrir un flujo de escritura desde el archivo "TEMPOR".
            System.out.print("Ingrese el número de cuenta a eliminar: ");
            int numeroCuentaEliminar = teclado.nextInt();

            String Actuall;
            while ((Actuall = leer.readLine()) != null) { //ReadLine se utiliza para leer una línea de texto de una secuencia de entrada.
                //ReadLine va a devolver NULL cuando llegue al final del archivo
                String[] cuentaDato = Actuall.split(",");
                int numeroCuenta = Integer.parseInt(cuentaDato[0]);
                if (numeroCuenta != numeroCuentaEliminar) { //Se verifica si el número de cuenta obtenido en la línea
                    // actual no es igual al número de cuenta que se desea eliminar.
                    escribir.println(Actuall);
                }
            }
            //Las siguientes dos líneas están cerrando los recursos. (Es una buena práctica que se debe manejar siempre)
            escribir.close();
            leer.close();
            boolean exitoso = TEMPOR.renameTo(CUENTAS); // La función renameTo  permite cambiar de nombre a un archivo o en este caso mover todo
            //A una variable TEMPOR, esto hace la funcion de eliminar  
            if (!exitoso) {
                System.out.println("No se pudo eliminar la cuenta.");
            } else {
                System.out.println("Cuenta eliminada correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al eliminar la cuenta.");
            e.printStackTrace();
        }
        //Las últimas 7 líneas de código se encargan del Try Catch que son las excepciones que lanzan en caso de errores
    }

    public void editarCuenta() {
        try {
            File cuentas = new File("cuentas_cheques.txt"); //"cuentas" representa el archivo llamado "cuentas_cheques.txt" en un objeto File.
            File temporal = new File("temp_cuentas_cheques.txt");//"temporal" se utilizará temporalmente para algun manejo de operaciones de archivos.


            BufferedReader leyendo = new BufferedReader(new FileReader(cuentas));//Lee el contenido del archivo de entrada y 
            //Se utiliza FILEREADER para abrir un flujo de lectura desde el archivo "cuentas".
            PrintWriter escribiendo = new PrintWriter(new FileWriter(temporal));// Se crea el objeto para poder escribir en el archivo.
            //Se utiliza FILEWRITER para abrir un flujo de escritura desde el archivo "temporal".
            //En las siguientes 13 líneas de codigo estamos pidiendo los nuevos datos para editarlos(solo los que lo permiten[Cédula NO])
            System.out.print("Ingrese el número de cuenta a editar: ");
            int numeroCuentaEditar = teclado.nextInt();
            System.out.println("Ingrese los nuevos datos de la cuenta:");
            System.out.print("Nombre del cliente: ");
            String NNom = teclado.next();
            System.out.print("Saldo: ");
            double NSald = teclado.nextDouble();
            System.out.println("Profesión: ");
            String Nprofes = teclado.next();
            System.out.print("Dirección: ");
            String NDirec = teclado.next();
            System.out.println("Estado civil: ");
            String Nec = teclado.next();

            String actual;
            while ((actual = leyendo.readLine()) != null) { //ReadLine se utiliza para leer una línea de texto de una secuencia de entrada.
                String[] cuentaDat = actual.split(",");
                int numeroCuenta = Integer.parseInt(cuentaDat[0]);
                if (numeroCuenta == numeroCuentaEditar) {  // La condición es que si son iguales (dato ingresado y dato guardado) podrán editarse.
                    escribiendo.println(numeroCuenta + "," + NNom + "," + NSald + "," + Nprofes + "," + NDirec +"," + Nec); // Y se los publicará en la consola
                } else {
                    escribiendo.println(actual);
                }
            }
            //Las siguientes dos líneas están cerrando los recursos. (Es una buena práctica que se debe manejar siempre)
            escribiendo.close();
            leyendo.close();
            boolean exit = temporal.renameTo(cuentas); // La función renameTo  permite cambiar de nombre a un archivo o en este caso mover todo
            //A una variable #temporal", esto hace la funcion de eliminar
            if (!exit) {
                System.out.println("No se pudo editar la cuenta.");
            } else {
                System.out.println("Cuenta editada correctamente.");
            }
        } catch (IOException e) {
            System.out.println("Error al editar la cuenta.");
            e.printStackTrace();
        }//Las últimas 7 líneas de código se encargan del Try Catch que son las excepciones que lanzan en caso de errores
    }
}
