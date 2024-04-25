package EneEnRaya2;

import java.util.Scanner;

public class JuegoNRaya extends Juego{

    private Jugador[] jugadores;
    private boolean terminado;
    private Tablero tablero;
    
    public JuegoNRaya(){
        inicializarJuego();
    }

    public void inicializarJuego(){
        this.jugadores = new Jugador[2];
        this.terminado = false;
        crearJugadores();
        selecionarPrimerJugador();
        tablero = new Tablero();
        tablero.crearTablero();
        tablero.mostrarTablero();
    }
    
    public void jugar(){
        while(!terminado){
            tablero.colocarFicha(jugadorActual());
            tablero.mostrarTablero();
            tablero.verificarGanador(jugadorActual());
            cambiarTurnoJugador();
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

    public void selecionarPrimerJugador(){
        Scanner leer = new Scanner(System.in);
        String nombreDelJugador1;
        do{
            System.out.println("¿Quién va a ser el jugador 1?");
            System.out.print(jugadores[0].getNombre()+" o "+jugadores[1].getNombre() + " ");
            nombreDelJugador1 = leer.nextLine();
        }while(!nombreDelJugador1.equals(jugadores[0].getNombre())&&!nombreDelJugador1.equals(jugadores[1].getNombre()));
        if (nombreDelJugador1.equals(jugadores[0].getNombre())) {
            jugadores[0].setTurno(true);
        } else {
            jugadores[1].setTurno(true);
        }
        System.out.println("\nEntonces el primero es " + jugadorActual().getNombre());
    }

    public void crearJugadores(){
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Introduce tu nombre: ");
            String nombre = leer.nextLine();
            System.out.println("Introduce la ficha con la que vas a jugar");
            char ficha = leer.nextLine().charAt(0);
            jugadores[i] = new Jugador(nombre);
            jugadores[i].setFicha(ficha);
            System.out.println("Ok " + jugadores[i].getNombre()+" vas a jugar con "+jugadores[i].getFicha());
            if (i<jugadores.length-1) {
                System.out.println("Que pase el siguiente jugador a introducir sus datos");
            }
        }
    }

    private Jugador jugadorActual(){
        if (jugadores[0].getTurno()) {
            return jugadores[0];
        }else{
            return jugadores[1];
        }
    }
}