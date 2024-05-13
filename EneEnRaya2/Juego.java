package EneEnRaya2;

import java.util.Scanner;

public abstract class Juego {
    protected Jugador[] jugadores;

    protected abstract void jugar(); 
    protected abstract void crearJugadores();
    protected abstract void selecionarPrimerJugador();
    protected abstract void inicializarVariables();
    protected abstract boolean getTerminado();
    protected abstract void cambiarTurnoJugador();

}