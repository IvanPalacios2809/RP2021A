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
      
      for(i=1;i<instancias.size();i++){//Recorre el arraylist de Patrones
        if(Clases.isEmpty()){
            Clases.add(new PatronBayes(instancias.get(i-1).vectorC,instancias.get(i-1).getClase()));
             Clases.get(Clases.size()-1).AgregarUnoAlContador();
             Clases.get(Clases.size()-1).Patrones.add(instancias.get(i-1));
        } 
        if(PatronBayes.comparar(instancias.get(i-1), instancias.get(i))){//Se compara la clase de las instancias para ver si son iguales
            Clases.add(new PatronBayes(instancias.get(i).getVectorC(), instancias.get(i).getClase()));
            Clases.get(Clases.size()-1).AgregarUnoAlContador();
             Clases.get(Clases.size()-1).Patrones.add(instancias.get(i));
         }
        else{
            Clases.get(Clases.size()-1).AgregarUnoAlContador();//Se le agrega al  contador del ultimo
                                                                                                //Patron Representativo una unidad ya que hay una clase repetida
          Clases.get(Clases.size()-1).AcumularValores(instancias.get(i));//Se agrega el valor de cada uno de las cantidades del vector
                                                                                                            //al ultimo patron representativo
            Clases.get(Clases.size()-1).Patrones.add(instancias.get(i));
        }
     }
      System.out.println(Clases.get(0).vectorC.length);
      PatronBayes.promediar(Clases);
      PatronBayes.sacarvarianza(Clases);
      System.out.println(Clases.get(0).varianza[0]);
    }
    public void clasificar(ArrayList<Patron> instancias){
        
    }
    
}
