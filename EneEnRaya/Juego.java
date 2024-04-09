package POO.EneEnRaya;

import java.util.Scanner;

public class Juego {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        Jugador jugador1 = new Jugador();
        Jugador jugador2 = new Jugador();

        tablero.introducirTamaño();
        jugador1.introducirNombre();
        do {
            jugador2.introducirNombre();
        } while (jugador2.getNombre().equals(jugador1.getNombre()));
        jugador1.introducirFicha();
        do {
            jugador2.introducirFicha();
        } while (jugador2.getFicha() == jugador1.getFicha());
        tablero.setJugador(Juego.establecerPrimero(jugador1, jugador2));

        while (tablero.verificarTurno() < tablero.getTamañoTotal() && !tablero.getHaTerminado()) {
            tablero.ponerFicha();
            tablero.imprimirTablero();
            tablero.verificarGanador();
            tablero.setJugador(cambiarJugador(tablero.getJugador(), jugador1, jugador2));
        }
    }

    private static Jugador cambiarJugador(Jugador jugador, Jugador jugador1, Jugador jugador2) {
        return (jugador.equals(jugador1)) ? jugador2 : jugador1;
    }

    private static Jugador establecerPrimero(Jugador jugador1, Jugador jugador2) {
        Scanner leer = new Scanner(System.in);
        Jugador auxJugador;
        String actual;
        do {
            System.out.println("¿Quién es el jugador 1? " + jugador1.getNombre() + " o " + jugador2.getNombre());
            actual = leer.nextLine();
        } while (!actual.equals(jugador1.getNombre()) && !actual.equals(jugador2.getNombre()));
        auxJugador = (actual.equals(jugador1.getNombre())) ? jugador1 : jugador2;
        System.out.println("Entonces el primer jugador es " + auxJugador.getNombre());
        System.out.println("Pues..., que comience ¡EL JUEGO!");
        return auxJugador;
    }

}
