package POO.EneEnRaya2;

import java.util.Scanner;

public class Juego {
    private Jugador[] jugadores;
    private boolean terminado;
    public Juego(){
        this.jugadores = new Jugador[2];
        this.terminado = false;
    }

    public void cambiarJugador(){
        if(jugadores[0].getTurno()){
            jugadores[0].setTurno(false);
            jugadores[1].setTurno(true);
        } else {
            jugadores[0].setTurno(true);
            jugadores[1].setTurno(false);
        }
    }

    public void selecionarJugador(){
        Scanner leer = new Scanner(System.in);
        String nombreDelJugador1;
        do{
            System.out.println("¿Quién va a ser el jugador 1?");
            System.out.print(jugadores[0].getNombre()+" o "+jugadores[1] + " ");
            nombreDelJugador1 = leer.nextLine();
        }while(nombreDelJugador1!=jugadores[0].getNombre()&&nombreDelJugador1!=jugadores[1].getNombre());
        if (nombreDelJugador1.equals(jugadores[0].getNombre())) {
            jugadores[0].setTurno(true);
        } else {
            jugadores[1].setTurno(true);
        }
        System.out.println("\nEntonces el primero es " + jugadorActual().getNombre());
    }

    public void crearJugadores(){
        Scanner leer = new Scanner(System.in);
        String nombre;
        char ficha;
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println("Introduce tu nombre: ");
            nombre = leer.nextLine();
            System.out.println("Introduce la ficha con la que vas a jugar");
            ficha = leer.next().charAt(0);
            jugadores[i].setNombre(nombre);
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