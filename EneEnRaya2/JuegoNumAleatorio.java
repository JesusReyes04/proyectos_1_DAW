package POO.EneEnRaya2;

import java.util.Scanner;

import POO.EneEnRaya2.Jugador;

import java.util.Random;

public class JuegoNumAleatorio {
    private Jugador[] jugadores;
    private boolean terminado;
    private int numParaAdivinar;

    public JuegoNumAleatorio() {
        inicializarVariables();
    }

    private void inicializarVariables() {
        this.jugadores = new Jugador[2];
        this.terminado = false;
        establecerNumero();
        crearJugadores();
        selecionarPrimerJugador();
    }

    public void jugar(){
        if (!terminado) {
            introducirIntento(jugadorActual());
            verificarNumero();
            mostrarResultado();
        }
    }

    private void introducirIntento(Jugador jugador){
        Scanner leer = new Scanner(System.in);
        int intento;
        System.out.println(jugador.getNombre()+" introduce tu intento (entre 1 y 100)");
        intento = leer.nextInt();
    }

    private void verificarNumero(){
        
    }

    private void establecerNumero(){
        Random random = new Random();
        this.numParaAdivinar = random.nextInt(100) + 1;
    }

    private void crearJugadores() {
        Scanner leer = new Scanner(System.in);
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Introduce tu nombre");
            String nombre = leer.nextLine();
            jugadores[i] = new Jugador(nombre);
        }
    }

    public void selecionarPrimerJugador() {
        Scanner leer = new Scanner(System.in);
        String nombreDelJugador1;
        do {
            System.out.println("¿Quién va a ser el jugador 1?");
            System.out.print(jugadores[0].getNombre() + " o " + jugadores[1].getNombre() + " ");
            nombreDelJugador1 = leer.nextLine();
        } while (!nombreDelJugador1.equals(jugadores[0].getNombre()) && !nombreDelJugador1.equals(jugadores[1].getNombre()));
        if (nombreDelJugador1.equals(jugadores[0].getNombre())) {
            jugadores[0].setTurno(true);
        } else {
            jugadores[1].setTurno(true);
        }
        System.out.println("\nEntonces el primero es " + jugadorActual().getNombre());
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
}