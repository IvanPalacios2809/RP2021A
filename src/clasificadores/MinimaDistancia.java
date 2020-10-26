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

    ArrayList<Patron> representativos;

    public MinimaDistancia(ArrayList<Patron> representativos) {
        this.representativos=representativos;
    }
           
    @Override
    public void entrenar(ArrayList<Patron> instancias) {
      //Saca los patrones representativos.
      int i=0;
      ArrayList<PatronRepresentativo> PatronesRepresentativos=new ArrayList<>();
      for(i=0;i<instancias.size();i++){//Recorre el arraylist de Patrones
         
        if(PatronRepresentativo.comparar(instancias.get(i-1), instancias.get(i))){//Se compara la clase de las instancias para ver si son iguales
            PatronesRepresentativos.add(new PatronRepresentativo(instancias.get(i).getVectorC(), instancias.get(i).getClase()));
         }

         else{
          PatronesRepresentativos.get(PatronesRepresentativos.size()-1).AgregarUnoAlContador();//Se le agrega al  contador del ultimo
                                                                                                //Patron Representativo una unidad ya que hay una clase repetida
          PatronesRepresentativos.get(PatronesRepresentativos.size()-1).AcumularValores(instancias.get(i));//Se agrega el valor de cada uno de las cantidades del vector
                                                                                                            //al ultimo patron representativo
         }
      }

      PatronRepresentativo.promediar(PatronesRepresentativos);
    }





    @Override
    public void clasificar(ArrayList<Patron> instancias) {
       // clasificar las instancias
      Patron[][] distancias=new double[instancias.size()][representativos.size()];
       for(int j=0;j<representativos.size()-1;j++){
         for(int i=0;i<instancias.size()-1;i++){
            distancias.[i][j] 
            distancias[i][j]=instancias.get(j).calcularDistancia(this.representativos.get(i));
       }
      }
      for(int j=0;j<instancias.size()-1;j++){
         for(int i=0;i<representativos.size()-1;i++){
             if(distancias[i][j]<distancias[i-1][j]){

             }
       }
      }
      
    }
    
}
