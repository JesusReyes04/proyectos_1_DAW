package POO.EneEnRaya2;

public class Jugador {
    private String nombre;
    private char ficha;
    private boolean turno;

    public Jugador(){
        this.turno = false;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public char getFicha() {
        return ficha;
    }
    public void setFicha(char ficha) {
        this.ficha = ficha;
    }
    public boolean getTurno() {
        return turno;
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    
   
}
