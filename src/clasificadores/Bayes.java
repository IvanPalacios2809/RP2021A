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
    public void entrenar(ArrayList<Patron> instancias){
     
        
      //Saca los patrones representativos.
      int i=0;
     System.out.println(instancias.size());
      ArrayList<Patron> aberraciones=new ArrayList<>();
      for(int w=0;w<instancias.size();w++){
      
      aberraciones.add(new Patron(instancias.get(w).vectorC.clone(), instancias.get(w).getClase()));
      }
      System.out.println("Tamano de las aberraciones"+aberraciones.size());
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
        System.out.println(Clases.get(w).varianza[0]);
        Clases.get(w).Sacar_desviacion();
        System.out.println(Clases.get(w).desviacion[0]);  
    } 
}

    public void clasificar(ArrayList<Patron> instancias){
    for(int j=0;j<instancias.size();j++){
           
        instancias.get(j).SacarDistribucionNormal(this.Clases, instancias);//Probabilidad dado x
        System.out.println("j:"+j+""+instancias.get(j).distribucion_normal[0][0]);
        
    }
    SacarEvidencia(instancias);
    for(int j=0;j<instancias.size();j++){
    instancias.get(j).CalcularProbabilidad(this.Clases);
    }
    Eficacia(instancias);
}



    
    public void SacarEvidencia(ArrayList<Patron> instancias){
    double multiplicacion=1;
        for(int j=0;j<this.Clases.size();j++){
            multiplicacion=(double)this.Clases.get(j).contador/instancias.size();
            System.out.println(multiplicacion);
            for(int i=0;i<this.Clases.get(j).vectorC.length;i++){
                multiplicacion*=Clases.get(j).desviacion[i];
            }
            System.out.println(multiplicacion);
            this.evidencia+=multiplicacion;
            multiplicacion=1;
        }
        System.out.println("Evidencia:"+evidencia);
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
        System.out.println("La eficacia de este algoritmo es de: "+ef+"%, Se obtuvo un resultado "+contador+" de "+);
    }
}
