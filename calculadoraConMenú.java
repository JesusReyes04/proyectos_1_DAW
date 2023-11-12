
// calculadora con menú
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        double resultado = 0;
        int operador;
        int option;
        boolean encendido = true;
        Scanner leer = new Scanner(System.in);
        while (encendido) {
            System.out.println(" _________________________________________\r\n" + //
                    "|                                         |\r\n" + //
                    "| Introduce 1 para introducir los números |\r\n" + //
                    "| Introduce 2 para introducir el operador |\r\n" + //
                    "| Introduce 3 para ver el resultado       |\r\n" + //
                    "| Introduce 4 para salir                  |\r\n" + //
                    "|                                         |\r\n" + //
                    " -----------------------------------------\r\n" + //
                    "");
            option = leer.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Introduce el primer número");
                    num1 = leer.nextInt();
                    System.out.println("Introduce el segundo número");
                    num2 = leer.nextInt();
                    break;
                case 2:
                    System.out.println("introduce el operador");
                    System.out.println("1 para sumar, 2 para restar, 3 para multiplicar y 4 para dividir");
                    operador = leer.nextInt();
                    while (operador < 1 || operador > 4) {
                        System.out.println("introduce un operador válido");
                        operador = leer.nextInt();
                    }
                    switch (operador) {
                        case 1:
                            resultado = num1 + num2;
                            break;
                        case 2:
                            resultado = num1 - num2;
                            break;
                        case 3:
                            resultado = num1 * num2;
                            break;
                        default:
                            resultado = num1 / num2;
                            break;
                    }
                    break;
                case 3:
                    System.out.println("El resultado de la operacioón es " + resultado);
                    break;
                case 4:
                    encendido = false;
                    System.out.println("hasta la proxima camarada");
                    break;
                default:
                    System.out.println("No estás haciendo nada compa");
                    System.out.println("introduse un número válido");
                    break;
            }
        }

    }
}
