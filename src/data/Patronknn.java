/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author LAST_
 */
public class Patronknn extends Patron{
    public double[] distancias;
    public int[] indice_distancias;
    
    public double[] getVectorC() {
        return vectorC;
    }

    public void setVectorC(double[] vectorC) {
        this.vectorC = vectorC;
    }

    public Patronknn(int n) {
        super(n);
    }

    public Patronknn(String clase, String claseResultante, double[] vectorC,int tamano) {
        super(clase, claseResultante, vectorC);
        distancias=new double[tamano];
        indice_distancias=new int[tamano];
    }

    public Patronknn(double[] vectorC, String clase) {
        super(vectorC, clase);
    }
     
    
    public  int[] ordenarDatos(double[] datos) { // peor de los casos  3 + 3n + 16n2  notación "O" grande O(n2)  
      int i, j;
      int aux;// 3
      int[] posiciones=new int[datos.length-1];
        for (i = 0; i < datos.length - 1; i++) { //  3(n)
            // subir la burbuja o elemento a ordenar (ajustamos en la pos que le corresponde)
            for (j = 0; j < datos.length - 1; j++) { // 16(n)(n) = 16n2
                // si entra al if se hace intercambio
                if (datos[j + 1]< datos[j]) { // 4  13
                    aux = j + 1; // 3
                    posiciones[j + 1] = j; // 4
                    posiciones[j] = aux; // 2
                }
            }
        }
        return posiciones;
    }
}
