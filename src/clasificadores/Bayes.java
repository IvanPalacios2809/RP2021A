/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.Patron;
import data.PatronBayes;
import interfaces.ClasificadorSupervisado;
import java.util.ArrayList;

/**
 *
 * @author LAST_
 */
public class Bayes implements ClasificadorSupervisado {
    ArrayList<PatronBayes> Clases=new ArrayList<>();
    double evidencia;
    ArrayList<Patron> instancias_clonadas;
    public void entrenar(ArrayList<Patron> instancias){
     
        
      //Saca los patrones representativos.
      int i=0;
     
      ArrayList<Patron> aberraciones=new ArrayList<>();
      for(int w=0;w<instancias.size();w++){
      
      aberraciones.add(new Patron(instancias.get(w).vectorC.clone(), instancias.get(w).getClase()));
      }
     
      for(i=1;i<instancias.size();i++){//Recorre el arraylist de Patrones
        if(Clases.isEmpty()){//Si es el primer elemento de la lista 
            Clases.add(new PatronBayes(instancias.get(i-1).vectorC,instancias.get(i-1).getClase()));
            Clases.get(Clases.size()-1).AgregarUnoAlContador();
            
        } 
        if(PatronBayes.comparar(instancias.get(i-1), instancias.get(i))){//Se compara la clase de las instancias para ver si son iguales
            Clases.add(new PatronBayes(instancias.get(i).getVectorC(), instancias.get(i).getClase()));
            Clases.get(Clases.size()-1).AgregarUnoAlContador();
        
         }
        else{//Si no hay una clase nueva.
            Clases.get(Clases.size()-1).AgregarUnoAlContador();
            Clases.get(Clases.size()-1).AcumularValores(instancias.get(i));
          
        }
     }
      PatronBayes.promediar(Clases);
      for(int w=0;w<Clases.size();w++){
        PatronBayes.sacarvarianza(Clases.get(w),aberraciones);
        
        Clases.get(w).Sacar_desviacion();
        
    } 
}

    public void clasificar(ArrayList<Patron> instancias){
        instancias.get(0);
    for(int j=0;j<instancias.size();j++){
           
        instancias.get(j).SacarDistribucionNormal(this.Clases, instancias);//Probabilidad dado x
    }
    
    for(int j=0;j<instancias.size();j++){
    instancias.get(j).CalcularProbabilidad(this.Clases);
    }
    System.out.println(Clases.get(0).promedio[0]);
    System.out.println(Clases.get(0).desviacion[0]);
    System.out.println(Clases.get(0).varianza[0]);
    System.out.println(instancias.get(0).priori[0]);
    System.out.println(instancias.get(0).distribucion_normal[0][0]);
    Eficacia(instancias);
}



    
    public void SacarEvidencia(ArrayList<Patron> instancias){
    double multiplicacion=1;
        for(int j=0;j<this.Clases.size();j++){
            multiplicacion=(double)this.Clases.get(j).contador/instancias.size();
            for(int i=0;i<this.Clases.get(j).vectorC.length;i++){
                multiplicacion*=Clases.get(j).desviacion[i];
            }
            this.evidencia+=multiplicacion;
            multiplicacion=1;
        }
        
    }
    public void Eficacia(ArrayList<Patron> instancias){
        int contador=0;
        double ef;
        for(int i=0;i<instancias.size();i++){
            if(instancias.get(i).getClase().equals(instancias.get(i).getClaseResultante())){
                contador++;
            }
        }
        ef=(double)contador/instancias.size()*100;
        System.out.println("La eficacia de este algoritmo es de: "+ef+"%, Se obtuvo un resultado "+contador+" de "+instancias.size());
    }
}
