package EneEnRaya2;
import java.util.Random;
import java.util.Scanner;

public class JuegoNumAleatorio extends JuegoAbstacto{
    private boolean terminado;
    private int numParaAdivinar;

    public JuegoNumAleatorio(Jugador[] jugadores){
        this.jugadores = jugadores;
        this.terminado = false;
        establecerNumero();
        mostrarJugadores();
        primerJugador();
    }

    @Override
    protected void jugar(){
        if (!terminado) {
            introducirIntento(jugadorActual());
            mostrarResultado(jugadorActual());
        }
    }

    private void introducirIntento(Jugador jugador){
        Scanner leer = new Scanner(System.in);
        int intento;
        System.out.println(jugador.getNombre()+" introduce tu intento (entre 1 y 100)");
        intento = leer.nextInt();
        verificarNumero(intento);
    }

    private void verificarNumero(int intento){
        if (intento == this.numParaAdivinar) {
            this.terminado=true;
        }else{
            if (intento<this.numParaAdivinar) {
                System.out.println("pon uno más grande");
            } else {
                System.out.println("pon uno más pequeño");
            }
        }
    }

    private void mostrarResultado(Jugador jugador){
        if (this.terminado) {
            System.out.println(jugador.getNombre()+" ha ganado, el número era "+this.numParaAdivinar);
        }else{
            System.out.println("sigue intentándolo");
        }
    }

    private void establecerNumero(){
        Random random = new Random();
        this.numParaAdivinar = random.nextInt(100) + 1;
    }

    @Override
    protected void mostrarJugadores(){
        System.out.println("Jugadores");
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println(jugadores[i].getNombre());
        }
    }

    private Jugador jugadorActual(){
        if (jugadores[0].getTurno()) {
            return jugadores[0];
        }else{
            return jugadores[1];
        }
    }
    
    public void cambiarTurnoJugador(){
        if(jugadores[0].getTurno()){
            jugadores[0].setTurno(false);
            jugadores[1].setTurno(true);
        } else {
            jugadores[0].setTurno(true);
            jugadores[1].setTurno(false);
        }
    }

    @Override
    protected void primerJugador() {
        System.out.println((jugadores[0].getTurno())?"primer jugador: "+jugadores[0].getNombre():"primer jugador: "+jugadores[1].getNombre());
    }

    @Override
    protected boolean getTerminado() {
        return terminado;
    }
}