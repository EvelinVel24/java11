import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Persona {
    String usuario;
    String contrasena;

    public Persona(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }
}

public class Main {
    static List<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        // Crear usuarios de ejemplo
        personas.add(new Persona("usuario1", "contrasena1"));
        personas.add(new Persona("usuario2", "contrasena2"));
        personas.add(new Persona("usuario3", "contrasena3"));

        Scanner scanner = new Scanner(System.in);

        // Solicitar usuario y contraseña
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        if (verificarAcceso(usuario, contrasena)) {
            mostrarMenu(scanner);
        } else {
            System.out.println("Acceso denegado. Usuario o contraseña incorrectos.");
        }

        scanner.close();
    }

    // Verificar si el usuario y la contraseña coinciden
    public static boolean verificarAcceso(String usuario, String contrasena) {
        for (Persona persona : personas) {
            if (persona.usuario.equals(usuario) && persona.contrasena.equals(contrasena)) {
                return true;
            }
        }
        return false;
    }

    // Mostrar el menú y realizar las operaciones de Math
    public static void mostrarMenu(Scanner scanner) {
        System.out.println("Bienvenido. Que desea realizar?");
        System.out.println("1. Calcular la raíz cuadrada de un número");
        System.out.println("2. Ver el valor de Pi");
        System.out.println("3. Calcular la potencia de un número");

        System.out.print("Selecciona una opción (1/2/3): ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.print("Introduce un número para calcular su raíz cuadrada: ");
                double num = scanner.nextDouble();
                System.out.println("La raíz cuadrada de " + num + " es " + Math.sqrt(num));
                break;
            case 2:
                System.out.println("El valor de Pi es " + Math.PI);
                break;
            case 3:
                System.out.print("Introduce la base: ");
                double base = scanner.nextDouble();
                System.out.print("Introduce el exponente: ");
                double exponente = scanner.nextDouble();
                System.out.println(base + " elevado a la potencia de " + exponente + " es " + Math.pow(base, exponente));
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
}
