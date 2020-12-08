/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasificadores;

import data.Patron;
import data.PatronCmeans;
import interfaces.ClasificadorSupervisado;
import static java.lang.Math.round;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author LAST_
 */
public class Cmeans implements ClasificadorSupervisado{
    ArrayList<PatronCmeans> PC;
    int c;
    public void entrenar(ArrayList<Patron> instancias){
        PC=new ArrayList<>();
        
        this.c=3;
        Random aleatorio=new Random();

         for(int i=0;i<c;i++){
            int seleccion=aleatorio.nextInt(instancias.size());
             this.PC.add(new PatronCmeans(0,instancias.get(seleccion).vectorC.clone(),instancias.size()));
         }
         
    }
    public void clasificar(ArrayList<Patron> instancias){
      
    int mitades=round(instancias.size()/c);
    Random ran=new Random(); 
    for(int i=0;i<PC.size();i++){
        
        while(PC.get(i).media!=PC.get(i).media_parcial){//Se busca romper el ciclo en dado caso de que la media no cambie     
            PC.get(i).media_parcial=PC.get(i).media;//Se asigna la media actual a la anterior para hacer la asignacion a la actual
            //Sacamos las distancias y las alojamos en un vector de el patron cmeans en cuestion
           
            PC.get(i).media=0;
            PC.get(i).sacarMedia(mitades);
            PC.get(i).ordenar(instancias);//Ordenamos las distancias
           
            PC.get(i).posicionar(mitades);//Posicionamos el nuevo punto del Patron Cmeans en cuestion
            for(int j=0;j<i;j++){
            if(i>0 && PC.get(i).media==PC.get(j).media){
               int valor_aleatorio=ran.nextInt(instancias.size());
                PC.get(i).media=0;
                PC.get(i).media_parcial=1;
                PC.get(i).vaciarvector();
                PC.get(i).vectorC=instancias.get(valor_aleatorio).vectorC.clone();
                
            }}
        }
        System.out.println("Asigne el"+i+"Cmean, posiciones:"+PC.get(i).vectorC[0]+","+PC.get(i).vectorC[1]+","+PC.get(i).vectorC[2]);
    }
}
}
