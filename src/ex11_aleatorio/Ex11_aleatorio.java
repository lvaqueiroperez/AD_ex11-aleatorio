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
     Este ejercicio nos permite saber como, en registros aleatorios de la misma longitud,
     podemos leer datos sin importar su posición, leemos yendo directamente a la posición,
     no leemos todo lo anterior como antes
     La única condición es que todos los registros/campos cumplan la misma longitud
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        String[] codes = {"p1", "p2", "p3"};
        String[] descricion = {"parafusos", "cravos ", "tachas"};
        int[] prices = {3, 4, 5};

        File fichero = new File("/home/oracle/Desktop/ex11/fichero.txt");
        //probar si podemos aplicar buffered
        RandomAccessFile filerandom = new RandomAccessFile(fichero, "rw");

        String prueba = "cadena prueba";
        //Para formatear la string y llenar espacios (los cambiamos por 0 para que sean más vistosos):
        System.out.println(String.format("%" + 50 + "s", prueba).replace(" ", "0"));

        //los strings tienen la misma longitud ya que a cada elemento le corresponden
        //3 valores (1 en cada string)
        //cada linea un producto
        //posicion 0:   3 caracteres    (6 bytes)
        //posicion 1:   10 caracteres (20 bytes)
        //posicion 2:   un entero (4 bytes)
        //tenemos que usar filerandom chars (strings) y writeint
        int posicion = 0;

        for (posicion = 0; posicion < prices.length; posicion++) {

            String cod = codes[posicion];
            String desc = descricion[posicion];
            int precio = prices[posicion];

            filerandom.writeChars(String.format("%-" + 3 + "s", cod).replace(" ", "0"));
            filerandom.writeChars(String.format("%-" + 10 + "s", desc).replace(" ", "0"));
            filerandom.writeInt(precio);

        }

        /*
         Fórmula:
         (n-1) * 30; n posicion que queramos y 30 un registro completo
        
         */
        //hay que usar readchar y readInt
        filerandom.seek((2 - 1) * 30);

        String codigo = "";
        String desc = "";
        int precio = 0;
        char caracter;
        //Cada vez que llamamos a readCHar avanza 1 posición, y se guarda la posición en la que queda !!!
        for (int j = 0; j < 3; j++) {

            caracter = filerandom.readChar();
            if (caracter != '0') {

                codigo += caracter;

            }

        }

        for (int j = 0; j < 10; j++) {

            caracter = filerandom.readChar();
            if (caracter != '0') {

                desc += caracter;

            }

        }

        precio = filerandom.readInt();

        System.out.print(desc);

        filerandom.close();

        Product prod2 = new Product(codigo, desc, precio);
        System.out.println(prod2.toString());

    }

}

class Product {

    private String codigo;
    private String descripcion;
    private int precio;

    public Product() {

        codigo = "";
        descripcion = "";
        precio = 0;

    }

    public Product(String codigo, String descripcion, int precio) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;

    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Product{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", precio=" + precio + '}';
    }

}
