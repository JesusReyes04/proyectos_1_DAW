package POO.EneEnRaya;

import java.util.Scanner;

public class Tablero {
    private char[][] tablero;
    private int contador = 0;
    private boolean haTerminado = false;
    Jugador jugador;

    public void setHaTerminado(boolean haTerminado) {
        this.haTerminado = haTerminado;
    }

    public int getTamañoTotal(){
        return (tablero.length*tablero.length);
    }

    public int verificarTurno(){
        return contador;
    }

    public boolean getHaTerminado() {
        return haTerminado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public void introducirTamaño(){
        Scanner leer = new Scanner(System.in);
        int tamaño;
        do {
            System.out.println("Introduce el tamaño del tablero");
            tamaño = leer.nextInt();
        } while (tamaño<3);
        System.out.println(".:.:. Tablero creado con éxito .:.:.");
        System.out.println("Has establecido el tamaño del tablero a "+tamaño);
        tablero = new char[tamaño][tamaño];
        rellenarTablero(tablero);
        imprimirTablero();
    }

    private void rellenarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j<tablero[i].length; j++){
                tablero[i][j]='*';
            }
        }
    }

    public void imprimirTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (j<tablero.length-1) {
                    System.out.print("|"+(char)tablero[i][j]);
                }else{
                    System.out.print("|"+(char)tablero[i][j]+"|");
                }
            }
            System.out.println("");
        }
    }

    public void ponerFicha(){
        int coordenadaFila;
        int coordenadaColumna;
        System.out.println("Te toca "+jugador.getNombre());
        do {
            coordenadaFila=introducirCoordenada("fila");
            coordenadaColumna=introducirCoordenada("columna");
        } while (tablero[coordenadaFila][coordenadaColumna]!='*');
        tablero[coordenadaFila][coordenadaColumna]=jugador.getFicha().getFicha();
        contador++;
    }

    private int introducirCoordenada(String string){
        Scanner leer = new Scanner(System.in);
        int coordenada;
        do{
            System.out.println("Introduce la coordenada de la "+string+" (entre 1 y "+tablero.length+")");
            coordenada=leer.nextInt();
        }while(coordenada<1||coordenada>tablero.length);
        return coordenada-1;
    }

    public void verificarGanador() {
        if (verificarFilas() || verificarColumnas() || verificarDiagonales()) {
            System.out.println("Has ganado " + jugador.getNombre() + " SIUUUUUUUUU");
            haTerminado = true;
        } else {
            if (contador == (tablero.length * tablero.length) && !haTerminado) {
                System.out.println("No hay ganador chavales, es un empate");
                haTerminado = true;
            }
        }
    }

    
    private boolean verificarDiagonales() {
        int contadorDiagonal1=0, contadorDiagonal2=0;
        
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i]==jugador.getFicha().getFicha()) {
                contadorDiagonal1++;
            }
        }

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][tablero.length-1-i]==jugador.getFicha().getFicha()) {
                contadorDiagonal2++;
            }
        }

        if (contadorDiagonal1 == tablero.length || contadorDiagonal2 == tablero.length) {
            return true;
        } else {
            return false;
        }
    }

    private boolean verificarColumnas() {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i]==jugador.getFicha().getFicha()) {
                    contador++;
                }
            }
            if (contador==tablero.length) {
                return true;
            }else{
                contador=0;
            }
        }
        return false;
    }

    private boolean verificarFilas() {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j]==jugador.getFicha().getFicha()) {
                    contador++;
                }
            }
            if (contador==tablero.length) {
                return true;
            }else{
                contador=0;
            }
        }
        return false;
    }

}
