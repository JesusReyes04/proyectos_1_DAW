package EneEnRaya2;
import java.util.Scanner;
public abstract class Juego {
    private Juego[] juegos;

    private void introducirCantidadDeJuegos(){
        int cantidadJuegos;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("Cuantos juegos quieres jugar");
            cantidadJuegos = leer.nextInt();
        } while (cantidadJuegos<1);
        System.out.println("Ok se van a jugar a "+cantidadJuegos+" juegos");
        juegos = new Juego[cantidadJuegos];
    }

    private void determinarTipoJuego(){
        Scanner leer = new Scanner (System.in);
        System.out.println("Hay 2 opciones,\n1. Jugar al 'N en Raya'(opción 1)\n2. Adivinar un número que irá del 1 al 100(opción 2)");
        System.out.println("Elige '1' para jugar al 'N en Raya' o '2' para adivinar un número");
        for (int i = 0; i < juegos.length; i++) {
            int eleccion;
            do {
                System.out.println("El juego "+(i+1)+": "+ "¿Quieres que sea 'N en Raya' o Adivinar el número?");
                eleccion = leer.nextInt();
            } while (eleccion<1||eleccion>2);
            if (eleccion == 1) {
                juegos[i] = new JuegoNRaya();
            } else {
                juegos[i] = new JuegoNumAleatorio();
            }
        }
    }
}
