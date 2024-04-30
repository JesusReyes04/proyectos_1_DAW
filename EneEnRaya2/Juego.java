package EneEnRaya2;
import java.util.Scanner;
public class Juego {
    private JuegoNRaya[] juegos;

    public Juego(){
        inicializarJuegos();
    }

    private void inicializarJuegos() {
        introducirCantidadDeJuegos();
        jugarJuegos();
    }

    private boolean verificarTerminadoTodosTableros(){
        boolean seguir=false;
        for (int i = 0; i < juegos.length&&!seguir; i++) {
            if (!juegos[i].getTerminado()) {
                seguir=true;
            }
        }
        return seguir;
    }

    private void jugarJuegos() {
        while (verificarTerminadoTodosTableros()) {
            for (int i = 0; i < juegos.length; i++) {
                if(!juegos[i].getTerminado()){
                    juegos[i].jugar();
                }
            }
            for(int i = 0; i < juegos.length; i++){
                if(!juegos[i].getTerminado()){
                    juegos[i].cambiarTurnoJugador();
                }
            }
        }
    }

    private void introducirCantidadDeJuegos(){
        int cantidadJuegos;
        Scanner leer = new Scanner(System.in);
        do {
            System.out.println("Cuantos juegos quieres jugar");
            cantidadJuegos = leer.nextInt();
        } while (cantidadJuegos<1);
        System.out.println("Ok se van a jugar a "+cantidadJuegos+" juegos");
        juegos = new JuegoNRaya[cantidadJuegos];
        for (int i = 0; i < juegos.length; i++) {
            juegos[i] = new JuegoNRaya();
        }
    }
}
