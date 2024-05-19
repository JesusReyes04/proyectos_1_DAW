package EneEnRaya2;
import java.io.FileReader;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "juegos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Juegos {
    @XmlElement(name = "juego")
    private Juego[] juegos;

    public Juego[] getJuegos() {
        return juegos;
    }

    public void setJuegos(Juego[] juegos) {
        this.juegos = juegos;
    }

    @Override
    public String toString() {
        return "juegos=" + Arrays.toString(juegos);
    }
    

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Juegos.class);
            Unmarshaller um = context.createUnmarshaller();
            Juegos juegosMain = (Juegos) um.unmarshal(new FileReader("EneEnRaya2\\Juegos.xml"));            
            JuegoAbstacto[] juegosAbstactos = new JuegoAbstacto[juegosMain.juegos.length];
            crearJuegos(juegosMain.getJuegos(), juegosAbstactos);
            while (!verificarTodosTerminado(juegosAbstactos)) {
                for (int i = 0; i < juegosAbstactos.length; i++) {
                    juegosAbstactos[i].jugar();    
                }
                cambiarTurnos(juegosAbstactos);
            }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void cambiarTurnos(JuegoAbstacto[] juegosAbstactos) {
        for (int i = 0; i < juegosAbstactos.length; i++) {
            if (!juegosAbstactos[i].getTerminado()) {
                juegosAbstactos[i].cambiarTurnoJugador();
            }
        }
    }

    public static void crearJuegos(Juego[] juegos,JuegoAbstacto[] juegoAbstactos){
        for (int i = 0; i < juegoAbstactos.length; i++) {
            System.out.println("Juego "+ (i+1) + " de tipo: "+juegos[i].getTipo());
            if(juegos[i].getTipo().equals("NRaya")){
                juegos[i].getTablero().crearTablero();
                juegoAbstactos[i] = new JuegoNRaya(juegos[i].getTablero(), juegos[i].getJugadores());    
            }else{
                juegoAbstactos[i] = new JuegoNumAleatorio(juegos[i].getJugadores());
            }
            System.out.println("\n");
        }
    }

    public static boolean verificarTodosTerminado(JuegoAbstacto[] juegoAbstactos){
        for (int i = 0; i < juegoAbstactos.length; i++) {
            if (!juegoAbstactos[i].getTerminado()) {
                return false;
            }
        }
        return true;
    }
    
}