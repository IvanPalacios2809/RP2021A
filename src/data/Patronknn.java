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
public class Patronknn extends Patron{
    public double[] distancias;
    public int[] indice_distancias;
    public Patron[] patrones;
    public double[] getVectorC() {
        return vectorC;
    }

    public void setVectorC(double[] vectorC) {
        this.vectorC = vectorC;
    }

    public Patronknn(int n) {
        super(n);
    }

    public Patronknn(String clase_resultante, String clase,double[] vectorC) {
        super(clase,clase_resultante,vectorC);
    }

    public Patronknn(double[] vectorC, String clase) {
        super(vectorC, clase);
    }
     
    
    public  void ordenarDatos(ArrayList<Patron> PatronesEntrenamiento) { // peor de los casos  3 + 3n + 16n2  notación "O" grande O(n2)  
      int i, j;
      patrones=new Patron[PatronesEntrenamiento.size()];
      for(i=0;i<patrones.length;i++){
          patrones[i]=PatronesEntrenamiento.get(i);
      }
      Patron aux;// 3
      
        for (i = 0; i < patrones.length - 1; i++) { //  3(n)
            // subir la burbuja o elemento a ordenar (ajustamos en la pos que le corresponde)
            for (j = 0; j < patrones.length - 1; j++) { // 16(n)(n) = 16n2
                // si entra al if se hace intercambio
                if (patrones[j + 1].calcularDistancia(this)< patrones[j].calcularDistancia(this)) { // 4  13
                    aux = patrones[j + 1]; // 3
                    patrones[j + 1] =patrones[j]; // 4
                    patrones[j] = aux; // 2
                }
            }
        }
        
    }
    public void clasificar(int k, ArrayList<String> NombreClases){
        int[] contadores=new int[NombreClases.size()];
        int indice=0;
        for(int i=0;i<k;i++){
            while(!this.patrones[i].getClase().equals(NombreClases.get(indice).toString())){
                    indice++;
            }
            contadores[indice]+=1;
            indice=0;
        }
        for(int i=0;i<contadores.length;i++){
            if(i==0){
                this.setClaseResultante(NombreClases.get(i));
            }
            else if(contadores[i]>contadores[i-1]){
                this.setClaseResultante(NombreClases.get(i));
                
            }
            System.out.println(this.getClaseResultante());
        }
        
    }
}
