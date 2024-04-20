package POO.EneEnRaya2;

import java.util.Scanner;

public class Tablero {
    private char[][] tablero;
    private int fichasColocadas;

    public void crearTablero(){
        Scanner leer = new Scanner(System.in);
        int tamaño;
        do {
            System.out.println("Introduce el tamaño del tablero");
            tamaño = leer.nextInt();
        } while (tamaño<3);
        System.out.println("-- Tablero creado con éxito --");
        System.out.println("Has establecido el tamaño del tablero a "+tamaño);
        tablero = new char[tamaño][tamaño];
        rellenarTablero();
    }

    private void rellenarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j<tablero[i].length; j++){
                tablero[i][j]='*';
            }
        }
    }

    public void colocarFicha(Jugador jugador){
        int coordenadaFila;
        int coordenadaColumna;
        System.out.println("Te toca "+jugador.getNombre());
        do {
            coordenadaFila=introducirCoordenada("fila");
            coordenadaColumna=introducirCoordenada("columna");
        } while (tablero[coordenadaFila][coordenadaColumna]!='*');
        tablero[coordenadaFila][coordenadaColumna]=jugador.getFicha();
        fichasColocadas++;
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
    
    public void mostrarTablero(){
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

    public boolean verificarGanador(Jugador jugador) {
        if (verificarFilas(jugador) || verificarColumnas(jugador) || verificarDiagonal(jugador) || verificarDiagonalInversa(jugador)) {
            System.out.println("Has ganado " + jugador.getNombre() + " SIUUUUUUUUU");
            return true;
        } else {
            if (fichasColocadas == (tablero.length * tablero.length)) {
                System.out.println("No hay ganador chavales, es un empate");
                return true;
            }else{
                return false;
            }
        }
    }

    
    private boolean verificarDiagonal(Jugador jugador) {
        int contadorDiagonal=0;
        
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i]==jugador.getFicha()) {
                contadorDiagonal++;
            }
        }

        return (contadorDiagonal == tablero.length) ? true : false ;
    }

    private boolean verificarDiagonalInversa(Jugador jugador) {
        int contadorDiagonalInversa=0;
        
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][tablero.length-1-i]==jugador.getFicha()) {
                contadorDiagonalInversa++;
            }
        }

        return (contadorDiagonalInversa == tablero.length) ? true : false ;
    }

    private boolean verificarColumnas(Jugador jugador) {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i]==jugador.getFicha()) {
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

    private boolean verificarFilas(Jugador jugador) {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j]==jugador.getFicha()) {
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