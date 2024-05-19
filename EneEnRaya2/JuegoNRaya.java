package EneEnRaya2;
public class JuegoNRaya extends JuegoAbstacto{

    private boolean terminado;
    private Tablero tablero;
    
    public JuegoNRaya(Tablero tablero,Jugador[] jugadores) {
        this.tablero = tablero;
        this.terminado = false;
        this.jugadores = jugadores;
        tablero.crearTablero();
        mostrarJugadores();
        primerJugador();
    }
    
    @Override
    protected void jugar(){
        if(!terminado){
            tablero.mostrarTablero();
            tablero.colocarFicha(jugadorActual());
            System.out.println("Así ha quedado el tablero:");
            tablero.mostrarTablero();
            if(tablero.verificarGanador(jugadorActual())){
                this.terminado=true;
            }
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


    @Override
    protected boolean getTerminado() {
        return terminado;
    }


    @Override
    protected void primerJugador() {
        System.out.println((jugadores[0].getTurno())?"primer jugador: "+jugadores[0].getNombre():"primer jugador: "+jugadores[1].getNombre());
    }

}