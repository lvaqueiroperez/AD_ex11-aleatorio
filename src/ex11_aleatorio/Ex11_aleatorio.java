/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex11_aleatorio;
import java.io.*;
/**
 *
 * @author oracle
 */
public class Ex11_aleatorio {

    /**
     * @param args the command line arguments
     */
    //USAR LA API !!!
    /*
    Este ejercicio nos permite saber como, en registros de la misma longitud,
    podemos leer datos sin importar su posición, leemos yendo directamente a la posición,
    no leemos todo lo anterior como antes
    La única condición es que todos los registros/campos cumplan la misma longitud
    */
    public static void main(String[] args) throws FileNotFoundException {

        String[] codes = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};
        
        File fichero = new File("/home/oracle/Desktop/ex11/fichero.txt");
        //probar si podemos aplicar buffered
        RandomAccessFile write = new RandomAccessFile(fichero,"rw");
        
        
        
        
        
        

    }

}