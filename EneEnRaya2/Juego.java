package EneEnRaya2;
import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "juego")
@XmlAccessorType(XmlAccessType.FIELD)
public class Juego {
    private String tipo;
    @XmlElementWrapper(name = "jugadores")
    @XmlElement(name = "jugador")
    private Jugador[] jugadores;
    private Tablero tablero;

    public Juego() {}

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    /*

    protected abstract void jugar();
    protected abstract void mostrarJugadores();
    protected abstract void primerJugador();
    protected abstract boolean getTerminado();
    protected abstract void cambiarTurnoJugador();

    */

    @Override
    public String toString() {
        return (tablero != null) ? "tipo: " + tipo + "\njugadores: " + Arrays.toString(jugadores) + "\ntablero: " + tablero.getTamañoTablero() : "tipo: " + tipo + "\njugadores: " + Arrays.toString(jugadores);
    }
}
