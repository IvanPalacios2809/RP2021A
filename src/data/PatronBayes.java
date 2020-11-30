/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author LAST_
 */
public class PatronBayes extends Patron{
    public int contador;
    public double[] varianza;
    public double[] promedio;
    public ArrayList<Patron> Patrones;
    public PatronBayes( double[] vectorC, String clase) {
        super(vectorC, clase);
        promedio=new double[vectorC.length];
        varianza=new double[vectorC.length];
        Patrones=new ArrayList<>();
    }

    public PatronBayes(String clase) {
        super(clase);
    }
    public static boolean comparar(Patron PatronAnterior,Patron PatronActual){
       if(PatronAnterior.getClase().equals(PatronActual.getClase())){
        return false;
       }

       else{
           return true;
       }
    }
   public void AcumularValores(Patron PatronChido){
        for(int i=0;i<PatronChido.getVectorC().length;i++){
            this.vectorC[i]+=PatronChido.vectorC[i];
            //System.out.print(this.vectorC[i]);
        }
    }
    public void  AgregarUnoAlContador(){
        this.contador++;
     }
        public static void promediar(ArrayList<PatronBayes> PatronesBayes){
        //System.out.println(""+(PatronesRepresentativos.size()));
        
        for(int j=0;j<PatronesBayes.size();j++){
            System.out.println("Patron Bayes:"+PatronesBayes.get(j).getClase());
            for(int i=0;i<PatronesBayes.get(j).getVectorC().length;i++){
                PatronesBayes.get(j).promedio[i]=PatronesBayes.get(j).vectorC[i]/(PatronesBayes.get(j).contador);
                System.out.println(PatronesBayes.get(j).promedio[i]);
                
            }
            
            
        }
    }
        public static void sacarvarianza(ArrayList<PatronBayes> PatronesBayes){
            
            System.out.println("Patrones Bayes"+PatronesBayes.size());
            System.out.println("Patrones en Bayes 1"+PatronesBayes.get(0).Patrones.size());
            System.out.println("Vector del patron en bayes 1"+PatronesBayes.get(0).varianza.length);
            for(int k=0;k<PatronesBayes.size();k++){
                for(int j=0;j<PatronesBayes.get(k).Patrones.size();j++){
                    for(int i=0;i<PatronesBayes.get(k).Patrones.get(j).vectorC.length;i++){
                    PatronesBayes.get(k).varianza[i]=PatronesBayes.get(k).varianza[i]+(Math.pow(PatronesBayes.get(k).Patrones.get(j).vectorC[i]-PatronesBayes.get(k).promedio[i],2))/PatronesBayes.get(k).contador;
                }
                
                }
            }
            System.out.println(PatronesBayes.get(2).varianza[0]);
            }
            
        
}

