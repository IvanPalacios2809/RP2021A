/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author LAST_
 */
public class PatronCmeans extends Patron{
    public double media;
    public double media_parcial;
    public double[] distancias;
    public int[] referencia;
    public PatronCmeans(double media, double[] vectorC, int tamano) {
        super(vectorC);
        this.media = media;
        this.media_parcial=1;
        distancias=new double[tamano];
        referencia=new int[tamano];
    }

    public void sacarDistancia(ArrayList<Patron> instancias){
        for(int j=0;j<instancias.size();j++){
            
            this.distancias[j]=this.calcularDistancia(instancias.get(j));
            this.referencia[j]=j;    
                
                
                
        }
    }
    public void ordenar(){
             // peor de los casos  3 + 3n + 16n2  notación "O" grande O(n2)  
      int i, j;
      int aux;// 3
        for (i = 0; i < this.distancias.length - 1; i++) { //  3(n)
            // subir la burbuja o elemento a ordenar (ajustamos en la pos que le corresponde)
            for (j = 0; j < this.distancias.length - 1; j++) { // 16(n)(n) = 16n2
                // si entra al if se hace intercambio
                if (distancias[j + 1] < distancias[j]) { // 4  13
                    aux = referencia[j + 1]; // 3
                    referencia[j + 1] = referencia[j]; // 4
                    referencia[j] = aux; // 2
                }
            }
        }
    }
    public void posicionar(){
        for(int i=0;i<)
    }
}
