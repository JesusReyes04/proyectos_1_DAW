package javaapplication41;
import java.util.Random;
import java.util.Scanner;
public class JavaApplication41 {

    public static void main(String[] args) {
        int numIntentos=1;
        int intento;
        Random r = new Random();
        int numero = r.nextInt(10)+0;
        System.out.println(numero);
        System.out.println("Introduce un intento");
        Scanner leer = new Scanner(System.in);
        intento = leer.nextInt();
        while(numero!=intento){
            if(numero>intento){
                System.out.println("Pon un número más grande");
            }
            else{
                System.out.println("Pon un numero más pequeño");
            }
            intento = leer.nextInt();
            numIntentos++;
        }
        System.out.println("Lo has adivinado, el numero es "  + numero + " y  lo has intentado " + numIntentos +" veces");
        
    }
    
}
