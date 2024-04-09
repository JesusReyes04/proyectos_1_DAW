package POO.EneEnRaya;

import java.util.Scanner;

public class Jugador {
    private String nombre;
    private Ficha ficha;

    public void introducirNombre() {
        Scanner leer = new Scanner(System.in);
        String nombreJugador;
        System.out.println("¿Cómo te llamas?");
        nombreJugador = leer.nextLine();
        nombre=nombreJugador;   
    }

    public String getNombre() {
        return nombre;
    }

    public void introducirFicha() {
        Scanner leer = new Scanner(System.in);
        char fichita;
        do {
            System.out.println("Introduce el caracter con el que quieres jugar " + nombre);
            fichita = leer.nextLine().charAt(0);
        } while (fichita == ' ');
        ficha = new Ficha(fichita);
    }

    public Ficha getFicha() {
        return ficha;
    }


}
