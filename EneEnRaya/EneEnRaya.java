package POO.EneEnRaya;

import java.util.Scanner;

public class EneEnRaya {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String jugador1;
        String jugador2;
        String caracter1;
        String caracter2;
        String jugadorAtual;
        String fichaActual;
        String[][] tablero;
        int turno=0;
        boolean haTerminado = false;

        tablero = crearTablero(leer);
        jugador1=introducirNombre(leer);
        caracter1=introducirCaracter(jugador1,leer);
        do {
            jugador2=introducirNombre(leer);
        } while (jugador2.equals(jugador1));
        do {
            caracter2=introducirCaracter(jugador2,leer);
        } while (caracter2.equals(caracter1));
        jugadorAtual=establecerPrimero(jugador1,jugador2,leer);
        fichaActual = (jugadorAtual.equals(jugador1))?caracter1:caracter2;
        mostarTablero(tablero);
        
        while(turno<(tablero.length*tablero.length) && !haTerminado){
            introducirFicha(tablero,jugadorAtual,fichaActual,leer);
            mostarTablero(tablero);
            if (verificarGanador(tablero, turno, jugadorAtual, fichaActual)) {
                haTerminado=true;
            }
            turno++;
            fichaActual=cambiarFicha(fichaActual,caracter1,caracter2);
            jugadorAtual=cambiarJugador(jugadorAtual,jugador1,jugador2);
        }
        
    }

    private static String cambiarJugador(String jugadorAtual, String jugador1, String jugador2) {
        return (jugadorAtual.equals(jugador1))?jugador2:jugador1;
    }

    private static boolean verificarGanador(String[][] tablero, int turno, String jugadorAtual, String fichaActual) {
        if (verificarFilas(tablero,fichaActual)) {
            System.out.println("Has ganado "+jugadorAtual+" SIUUUUUUUUU");
            return true;
        }else if (verificarColumnas(tablero,fichaActual)) {
            System.out.println("Has ganado "+jugadorAtual+" SIUUUUUUUUU");
            return true;
        }else if (verificarDiagonales(tablero,fichaActual)) {
            System.out.println("Has ganado "+jugadorAtual+" SIUUUUUUUUU");
            return true;
        }else{
            if (turno==(tablero.length*tablero.length)-1) {
                System.out.println("No hay ganador chavales");
            }
        }
        return false;
    }

    
    private static boolean verificarDiagonales(String[][] tablero, String fichaActual) {
        int contadorDiagonal1=0, contadorDiagonal2=0;
        
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][i].equals(fichaActual)) {
                contadorDiagonal1++;
            }
        }

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][tablero.length-1-i].equals(fichaActual)) {
                contadorDiagonal2++;
            }
        }

        if (contadorDiagonal1 == tablero.length || contadorDiagonal2 == tablero.length) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean verificarColumnas(String[][] tablero, String fichaActual) {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[j][i].equals(fichaActual)) {
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

    private static boolean verificarFilas(String[][] tablero, String fichaActual) {
        for (int i = 0; i < tablero.length; i++) {
            int contador=0;
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].equals(fichaActual)) {
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

    private static String cambiarFicha(String fichaActual, String caracter1, String caracter2) {
        return (fichaActual.equals(caracter1))?caracter2:caracter1;
    }

    private static void introducirFicha(String[][] tablero, String jugadorAtual, String fichaActual, Scanner leer) {
        int coordenadaFila;
        int coordenadaColumna;
        System.out.println("Te toca "+jugadorAtual);
        do {
            coordenadaFila=introducirCoordenada(leer,"fila",tablero.length);
            coordenadaColumna=introducirCoordenada(leer, "columna",tablero.length);
        } while (!tablero[coordenadaFila][coordenadaColumna].equals("*"));
        tablero[coordenadaFila][coordenadaColumna]=fichaActual;
    }

    private static int introducirCoordenada(Scanner leer, String string, int tamaño) {
        int coordenada;
        do{
            System.out.println("Introduce la coordenada de la "+string+" (entre 1 y "+tamaño+")");
            coordenada=leer.nextInt();
        }while(coordenada<1||coordenada>tamaño);
        return coordenada-1;
    }

    private static String introducirCaracter(String jugador, Scanner leer) {
        String ficha;
        do {
            System.out.println("Intoduce la ficha con la que quieres jugar "+jugador);
            ficha=leer.nextLine();
        } while (ficha.charAt(0)==' ');
        ficha=ficha.substring(0,1);
        System.out.println("Vale "+jugador+" usarás "+ficha);
        return ficha;
    }

    private static String establecerPrimero(String jugador1, String jugador2, Scanner leer) {
        String actual;
        do {
            System.out.println("¿Quién es el jugador 1? " + jugador1 + " o " + jugador2);
            actual=leer.nextLine();
        } while (!actual.equals(jugador1) && !actual.equals(jugador2));
        System.out.println("Entonces el primer jugador es "+actual);
        System.out.println("Pues..., que comience ¡EL JUEGO!");
        return actual;
    }

    private static String introducirNombre(Scanner leer) {
        String nombre;
        System.out.println("¿Cómo te llamás?");
        nombre=leer.nextLine();
        return nombre;
    }

    private static String[][] crearTablero(Scanner leer) {
        int tamaño;
        String [][] tablero;
        do{
            System.out.println("Introduce el tamaño de tu juego");
            tamaño=leer.nextInt();
        }while(tamaño<3);
        leer.nextLine();//para consumir el salto de línea generado por la lectura de número entero
        System.out.println("Tablero creado\nTamaño del tablero establedido a: "+tamaño);
        tablero=new String[tamaño][tamaño];
        tablero=rellenarTablero(tablero);
        mostarTablero(tablero);
        return tablero;
    }

    private static void mostarTablero(String[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (j<tablero[i].length-1) {
                    System.out.print("|"+tablero[i][j]);
                }else{
                    System.out.print("|"+tablero[i][j]+"|");
                }
            }
            System.out.println("");
        }
    }

    private static String[][] rellenarTablero(String[][]tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j]="*";
            }
        }
        return tablero;
    }
    
}
