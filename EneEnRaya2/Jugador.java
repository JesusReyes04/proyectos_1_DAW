package EneEnRaya2;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "jugador")
public class Jugador {
    private String nombre;
    private String ficha;
    private boolean turno;

    public Jugador() {}

    public String getNombre() {
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFicha() {
        return ficha;
    }

    @XmlElement
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public boolean getTurno() {
        return turno;
    }

    @XmlElement
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return (ficha!=null)?"nombre: " + nombre + "\nficha: " + ficha + "\nturno: " + turno : "Nombre: " + nombre + "\nTurno: " + turno;
    }

}
