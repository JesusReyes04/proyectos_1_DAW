package EneEnRaya2;

import java.util.Scanner;

public class JuegoMain {
    public static void main(String[] args) {
        Juego[] juegos=null;
        juegos = introducirCantidadDeJuegos(juegos);
        juegos = definirJuegos(juegos);
        jugarJuegos(juegos);
    }

    private static Juego[] introducirCantidadDeJuegos(Juego[] juegos){
        int cantidadJuegos;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("Cuantos juegos quieres jugar");
            cantidadJuegos = leer.nextInt();
        } while (cantidadJuegos<1);
        System.out.println("Ok se van a jugar a " + cantidadJuegos + " juegos");
        juegos = new Juego[cantidadJuegos];
        return juegos;
    }

    private static Juego[] definirJuegos(Juego[] juegos){
        Scanner leer = new Scanner(System.in);
        System.out.println("Ahora decide de que tipo seran los juegos escribiendo");
        System.out.println("1 para el N en Raya\n2 para Adivinar el numero aleatorio");
        for (int i = 0; i < juegos.length; i++) {
            int numero;
            do {
                System.out.println("¿El juego "+ (i+1) + " es de tipo (1) N en Raya o (2) Adivinar el numero?");
                numero = leer.nextInt();
            } while (numero<1||numero>2);
            juegos[i] = (numero==1)? new JuegoNRaya():new JuegoNumAleatorio();
        }
        return juegos;
    }

    private static void jugarJuegos(Juego[] juegos) {
        while (verificarTerminadoTodosTableros(juegos)) {
            for (int i = 0; i < juegos.length; i++) {
                if(!juegos[i].getTerminado()){
                    juegos[i].jugar();
                }
            }
            for(int i = 0; i < juegos.length; i++){
                if(!juegos[i].getTerminado()){
                    juegos[i].cambiarTurnoJugador();
                }
            }
        }
    }

    private static boolean verificarTerminadoTodosTableros(Juego[] juegos){
        boolean seguir=false;
        for (int i = 0; i < juegos.length&&!seguir; i++) {
            if (!juegos[i].getTerminado()) {
                seguir=true;
            }
        }
        return seguir;
    }

    
}
