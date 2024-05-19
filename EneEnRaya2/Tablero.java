package EneEnRaya2;
import javax.xml.bind.annotation.*;
import java.util.Scanner;

@XmlRootElement(name = "tablero")
@XmlAccessorType(XmlAccessType.FIELD)
public class Tablero {
    @XmlElement(name = "size")
    private int tamañoTablero;

    @XmlTransient
    private int fichasColocadas;

    @XmlTransient
    private String[][] arrayTablero;
    
    public Tablero(){
        crearTablero();
    }


    public void setTamañoTablero(int tamañoTablero) {
        this.tamañoTablero = tamañoTablero;
    }

    public void crearTablero() {
        arrayTablero = new String[tamañoTablero][tamañoTablero];
        rellenarTablero();
    }

    private void rellenarTablero() {
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero[i].length; j++) {
                arrayTablero[i][j] = "*";
            }
        }
    }

    public void colocarFicha(Jugador jugador) {
        int coordenadaFila;
        int coordenadaColumna;
        Scanner leer = new Scanner(System.in);
        System.out.println("Te toca " + jugador.getNombre());
        do {
            coordenadaFila = introducirCoordenada("fila", leer);
            coordenadaColumna = introducirCoordenada("columna", leer);
        } while (!arrayTablero[coordenadaFila][coordenadaColumna].equals("*"));
        arrayTablero[coordenadaFila][coordenadaColumna] = jugador.getFicha();
        fichasColocadas++;
    }

    private int introducirCoordenada(String string, Scanner leer) {
        int coordenada;
        do {
            System.out.println("Introduce la coordenada de la " + string + " (entre 1 y " + arrayTablero.length + ")");
            coordenada = leer.nextInt();
        } while (coordenada < 1 || coordenada > arrayTablero.length);
        return coordenada - 1;
    }

    public void mostrarTablero() {
        for (int i = 0; i < arrayTablero.length; i++) {
            for (int j = 0; j < arrayTablero[i].length; j++) {
                if (j < arrayTablero.length - 1) {
                    System.out.print("|" + arrayTablero[i][j]);
                } else {
                    System.out.print("|" + arrayTablero[i][j] + "|");
                }
            }
            System.out.println("");
        }
        System.out.println("\n");
    }

    public boolean verificarGanador(Jugador jugador) {
        if (verificarFilas(jugador) || verificarColumnas(jugador) || verificarDiagonal(jugador)
                || verificarDiagonalInversa(jugador)) {
            System.out.println("Has ganado " + jugador.getNombre() + " SIUUUUUUUUU");
            return true;
        } else {
            if (fichasColocadas == (arrayTablero.length * arrayTablero.length)) {
                System.out.println("No hay ganador chavales, es un empate");
                return true;
            } else {
                return false;
            }
        }
    }

    private boolean verificarDiagonal(Jugador jugador) {
        int contadorDiagonal = 0;
        for (int i = 0; i < arrayTablero.length; i++) {
            if (arrayTablero[i][i].equals(jugador.getFicha())) {
                contadorDiagonal++;
            }
        }
        return contadorDiagonal == arrayTablero.length;
    }

    private boolean verificarDiagonalInversa(Jugador jugador) {
        int contadorDiagonalInversa = 0;
        for (int i = 0; i < arrayTablero.length; i++) {
            if (arrayTablero[i][arrayTablero.length - 1 - i].equals(jugador.getFicha())) {
                contadorDiagonalInversa++;
            }
        }
        return contadorDiagonalInversa == arrayTablero.length;
    }

    private boolean verificarColumnas(Jugador jugador) {
        for (int i = 0; i < arrayTablero.length; i++) {
            int contador = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[j][i].equals(jugador.getFicha())) {
                    contador++;
                }
            }
            if (contador == arrayTablero.length) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarFilas(Jugador jugador) {
        for (int i = 0; i < arrayTablero.length; i++) {
            int contador = 0;
            for (int j = 0; j < arrayTablero.length; j++) {
                if (arrayTablero[i][j].equals(jugador.getFicha())) {
                    contador++;
                }
            }
            if (contador == arrayTablero.length) {
                return true;
            }
        }
        return false;
    }

    public int getTamañoTablero() {
        return arrayTablero.length;
    }
}
