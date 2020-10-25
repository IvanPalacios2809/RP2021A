 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.Patron;
import interfaces.ClasificadorSupervisado;
import java.util.ArrayList;

/**
 *
 * @author working
 */
public class MinimaDistancia implements ClasificadorSupervisado{

    ArrayList<Patron> representativos;
    
    public MinimaDistancia() {
        this.representativos = new ArrayList<>();
    }
           
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
     int numeroclases=0;
      double promedio;
      ArrayList<Integer> numeroinstancias=new ArrayList<>();
     int numero=0;
      // calcular los representativos
     for(int i=0;i<instancias.size();i++){
        
      if(instancias.get(i).getClase()!=instancias.get(i-1).getClase()){
        numeroclases++;
        numero=0;
      }
      else{
        numero++;
        numeroinstancias.set(numeroclases,numero);
      }
    }
     for(int x=0;x<numeroinstancias.size();x++){
       for(int y=0;y<numeroinstancias.get(x);y++){
      promedio=promedio+             
       }
     } 
    }

    @Override
    public void clasificar(ArrayList<Patron> instancias) {
       // clasificar las instancias
    }
    
}
