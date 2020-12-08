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
    public Patron[] distancias;
    public int[] referencia;
    public PatronCmeans(double media, double[] vectorC, int tamano) {
        super(vectorC);
        this.media = media;
        this.media_parcial=1;
        distancias=new Patron[tamano];
        referencia=new int[tamano];
    }

    public void ordenar(ArrayList<Patron> instancias){
             // peor de los casos  3 + 3n + 16n2  notación "O" grande O(n2)  
      int i, j;
      for(i=0;i<instancias.size();i++){
          distancias[i]=new Patron(instancias.get(i).vectorC.clone(),"");
      }
      Patron aux;// 3
        for (i = 0; i < this.distancias.length - 1; i++) { //  3(n)
            // subir la burbuja o elemento a ordenar (ajustamos en la pos que le corresponde)
            for (j = 0; j < this.distancias.length - 1; j++) { // 16(n)(n) = 16n2
                // si entra al if se hace intercambio
                if (this.distancias[j + 1].calcularDistancia(this) < this.distancias[j].calcularDistancia(this)) { // 4  13
                    aux = this.distancias[j + 1]; // 3
                    this.distancias[j + 1] = this.distancias[j]; // 4
                    this.distancias[j] = aux; // 2
                }
            }
        }
    }
    public void posicionar(int mitades){
    double[] vector_parcial=vectorC.clone();    
        for(int j=0;j<mitades;j++){
        for(int i=0;i<vectorC.length;i++){
            this.vectorC[i]+=this.distancias[j].vectorC[i];
            
        }
    }
    for(int i=0;i<this.vectorC.length;i++){
            this.vectorC[i]/=mitades+1;   
        }
    }
    public void sacarMedia(int mitades) {
        for(int i=0;i<this.vectorC.length;i++){
            this.media+=this.vectorC[i];
        }
        
            this.media/=this.vectorC.length;
            
    }
    public void vaciarvector(){
        for(int i=0;i<this.vectorC.length;i++){
            vectorC[i]=0;
        }
    }
    public void imprimir_desordenado(ArrayList<Patron> instancias){
        for(int i=0;i<this.distancias.length;i++){
            System.out.println(instancias.get(i).calcularDistancia(this));
        }
    }
    public void imprimir_orden(int mitades){
        System.out.println("Distancias ordenadas");
        for(int i=0;i<this.distancias.length;i++){
        System.out.println(this.distancias[i].calcularDistancia(this));
    }}
}

