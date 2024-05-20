package EneEnRaya2;
import java.util.Arrays;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "juegos")
@XmlAccessorType(XmlAccessType.FIELD)
public class Juegos {
    @XmlElement(name = "juego") Juego[] juegos;

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
}