/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package clasificadores;

import data.Patron;
import data.PatronRepresentativo;
import interfaces.ClasificadorSupervisado;
import java.util.ArrayList;

/**
 *
 * @author working
 */

public class MinimaDistancia implements ClasificadorSupervisado{

    ArrayList<PatronRepresentativo> representativos;

    public MinimaDistancia() {
        
    }
           
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
      //Saca los patrones representativos.
      int i=0;
      representativos=new ArrayList<>();
      for(i=1;i<instancias.size();i++){//Recorre el arraylist de Patrones
        if(representativos.isEmpty()){
            representativos.add(new PatronRepresentativo(instancias.get(i-1).vectorC,instancias.get(i-1).getClase()));
            System.out.println(instancias.get(i-1).getClase());
            representativos.get(representativos.size()-1).AgregarUnoAlContador();
        } 
        if(PatronRepresentativo.comparar(instancias.get(i-1), instancias.get(i))){//Se compara la clase de las instancias para ver si son iguales
            representativos.add(new PatronRepresentativo(instancias.get(i).getVectorC(), instancias.get(i).getClase()));
            representativos.get(representativos.size()-1).AgregarUnoAlContador();
         }

         else{
          representativos.get(representativos.size()-1).AgregarUnoAlContador();//Se le agrega al  contador del ultimo
                                                                                                //Patron Representativo una unidad ya que hay una clase repetida
          representativos.get(representativos.size()-1).AcumularValores(instancias.get(i));//Se agrega el valor de cada uno de las cantidades del vector
                                                                                                            //al ultimo patron representativo
         }
      }
      PatronRepresentativo.promediar(representativos);
    }





    @Override
    public void clasificar(ArrayList<Patron> instancias) {
       // clasificar las instancias
      double[][] distancias=new double[instancias.size()][representativos.size()];
      
       for(int j=0;j<instancias.size();j++){
         for(int i=0;i<representativos.size();i++){
            
            distancias[j][i]=instancias.get(j).calcularDistancia(this.representativos.get(i));
            
       }
      }

             
       for(int j=0;j<instancias.size();j++){
          instancias.get(j).setClaseResultante(representativos.get(0).getClase());
         for(int i=1;i<representativos.size();i++){
             if(distancias[j][i]<distancias[j][i-1]){
                 instancias.get(j).setClaseResultante(representativos.get(i).getClase());
             }
       }
         
      }
      
    }
    public String efectividad(ArrayList<Patron> instancias){
        double efectividad=0;
        int cantidad=0;
        for(int i=0;i<instancias.size();i++){
            if(instancias.get(i).getClaseResultante().equals(instancias.get(i).getClase())){
                cantidad++;

            }
            System.out.println(""+i+"Clase original:"+instancias.get(i).getClase());
            System.out.println("Clase resultante:"+instancias.get(i).getClaseResultante());
                
        }
        efectividad=(cantidad*100)/instancias.size();
        return "La efectividad es de"+efectividad+"%";
    }
}
