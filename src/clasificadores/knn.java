/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;
import data.Patron;
import data.Patronknn;
import interfaces.ClasificadorSupervisado;
import java.util.ArrayList;

/**
 *
 * @author LAST_
 */
public class knn implements ClasificadorSupervisado{
    ArrayList<Patron> PatronesEntrenamiento=new ArrayList<>();
    ArrayList<Patronknn> PatronesClasificacion=new ArrayList<>();
    ArrayList<String> NombreClases=new ArrayList<>();
    int k=3;
    public  void entrenar(ArrayList<Patron> instancias){
        for(int i=0;i<instancias.size()-1;i++){
            PatronesEntrenamiento.add(instancias.get(i));
        }
        for(Patron p: instancias){
           if(!this.NombreClases.contains(p.getClase())){
                this.NombreClases.add(p.getClase());
           }
       }
    }
    public void clasificar(ArrayList<Patron> instancias){
        int[] votos=new int[NombreClases.size()];
        ArrayList<Patron> Patrones=new ArrayList<>();
        
    for(int i=0;i<instancias.size()-1;i++){
        PatronesClasificacion.add(new Patronknn(instancias.get(i).getClase(),instancias.get(i).getClaseResultante(), instancias.get(i).getVectorC(),PatronesEntrenamiento.size()));
    }    
    double[][] distancias=new double[PatronesClasificacion.size()][PatronesEntrenamiento.size()];
    for(int j=0;j<PatronesClasificacion.size();j++){
    for(int i=0;i<PatronesEntrenamiento.size();i++){//Calculamos las distancias entre los patrones de entrenamiento y patrones a clasificar
           PatronesClasificacion.get(j).distancias[i]=PatronesClasificacion.get(j).calcularDistancia(PatronesEntrenamiento.get(i));
        }
        
    }
    for(int i=0;i<PatronesClasificacion.size();i++){
        PatronesClasificacion.get(i).indice_distancias=PatronesClasificacion.get(i).ordenarDatos(PatronesClasificacion.get(i).distancias);
    }
    
    for(int j=0;j<PatronesEntrenamiento.size();j++){
    for(int i=0;i<k;i++){
        //PatronesEntrenamiento.get(PatronesClasificacion.get(j).indice_distancias[i])
    }
    }
    }
    
}
