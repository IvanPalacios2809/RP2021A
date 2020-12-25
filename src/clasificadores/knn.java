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
        for(int i=0;i<instancias.size();i++){
        PatronesClasificacion.add(new Patronknn("", instancias.get(i).getClase(), instancias.get(i).vectorC.clone()));
        }
        for(Patronknn p: PatronesClasificacion){
        p.ordenarDatos(PatronesEntrenamiento);
        p.clasificar(k,NombreClases);
        }
        efectividad(PatronesClasificacion);
    }
    public void efectividad(ArrayList<Patronknn> instancias){
      int contador=0;  
      double efec=0;
        for(int i=0;i<instancias.size();i++){
            System.out.println("Clase resultante: "+instancias.get(i).getClaseResultante());
            if(instancias.get(i).getClase().equals(instancias.get(i).getClaseResultante())){
               
                contador++;
            }

        }
        efec=(double)contador/instancias.size()*100;
        System.out.println("La efectividad es de: "+efec+" Con una cantidad de: "+contador+" acertados");
    }
}
