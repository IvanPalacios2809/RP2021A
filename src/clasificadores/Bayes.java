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
     
    public void entrenar(ArrayList<Patron> instancias){
     ArrayList<PatronBayes> Clases=new ArrayList<>();   
      //Saca los patrones representativos.
      int i=0;
     
      ArrayList<Patron> aberraciones=new ArrayList<>();
      for(int w=0;w<aberraciones.size();w++){
      
      aberraciones.add(new Patron(instancias.get(w).vectorC, instancias.get(w).getClase()));
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
      PatronBayes.sacarvarianza(Clases.get(1),aberraciones);
      System.out.println(Clases.get(1).varianza[0]);
    }
    public void clasificar(ArrayList<Patron> instancias){
        
    }
    
}
