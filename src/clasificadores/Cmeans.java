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
        int contador_vector=instancias.get(0).vectorC.length; 
        this.c=2;
        Random aleatorio=new Random();
        double[] vector_parcial=new double[instancias.get(0).vectorC.length];
         for(int i=0;i<c;i++){
         for(int j=0;j<contador_vector;j++){
             vector_parcial[j]=aleatorio.nextDouble();
         }
             this.PC.add(new PatronCmeans(0,vector_parcial,instancias.size()));
         }
     
    }
    public void clasificar(ArrayList<Patron> instancias){
    for(int i=0;i<PC.size();i++){
        while(PC.get(i).media!=PC.get(i).media_parcial){    
            PC.get(i).media_parcial=PC.get(i).media;
            PC.get(i).sacarDistancia(instancias);
            PC.get(i).ordenar();
            PC.get(i).posicionar();
            PC.get(i).sacarMedia();
        }
    }
}
}
