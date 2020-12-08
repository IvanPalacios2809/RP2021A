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
    public double[] desviacion;
    public ArrayList<Patron> Patrones;
    public PatronBayes( double[] vectorC, String clase) {
        super(vectorC, clase);
        promedio=new double[vectorC.length];
        varianza=new double[vectorC.length];
        Patrones=new ArrayList<>();
        desviacion=new double[vectorC.length];
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
            
            for(int i=0;i<PatronesBayes.get(j).getVectorC().length;i++){
                PatronesBayes.get(j).promedio[i]=PatronesBayes.get(j).vectorC[i]/(PatronesBayes.get(j).contador);
                
                
            }
            
            
        }
    }
        public static void sacarvarianza(PatronBayes PB, ArrayList<Patron> instancias){
            int punto_partida=0;    
            System.out.println(PB.contador);
            while(PB.getClase()!=instancias.get(punto_partida).getClase()){
                punto_partida++;
                
                }
               
            int punto_final=PB.contador+punto_partida;
                while(punto_partida<punto_final){//recorre el arraylist
                   
                    for(int i=0;i<PB.varianza.length;i++){//recorre el vector
                      
                    PB.varianza[i]+=Math.pow(instancias.get(punto_partida).vectorC[i]-PB.promedio[i],2);
                }
            punto_partida++;     
            }
            for(int i=0;i<PB.varianza.length;i++){
                PB.varianza[i]/=(PB.contador-1);
            }
                }
    public void Sacar_desviacion(){
        for(int i=0;i<desviacion.length;i++){    
        this.desviacion[i]=Math.sqrt(this.varianza[i]);
        }
    }                
            }
            

        
                
        
        
        
        
                
                
            
            
            
            
        


