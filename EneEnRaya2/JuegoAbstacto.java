package EneEnRaya2;
public abstract class JuegoAbstacto {
    protected Jugador[] jugadores;

    protected abstract void jugar();
    protected abstract void mostrarJugadores();
    protected abstract void primerJugador();
    protected abstract boolean getTerminado();
    protected abstract void cambiarTurnoJugador();
    
}
