/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author working
 */
public class Patron {
    
    private String clase;
    private String claseResultante;
    public double[] vectorC;
    public double[][] distribucion_normal;
    public double[] priori;
    public double[] probabilidad;
    public Patron(int n) {
        this.clase = "";
        this.claseResultante = "";
        this.vectorC = new double[n];
        
    }

    public Patron(String clase, String claseResultante, double[] vectorC) {
        this.clase = clase;
        this.claseResultante = claseResultante;
        this.vectorC = vectorC;
       
    }
    public Patron(double[] vectorC, String clase){
        this.clase=clase;
        this.vectorC=vectorC;
    }
    public Patron(String clase){
        this.clase=clase;
    }
    public Patron(double[] vectorC){
        this.vectorC=vectorC;
    }
    // distancia euclidiana
    public double calcularDistancia (Patron aux){
        double sumatoria = 0;
        // recorre el vector característico
        for (int x=0; x<aux.getVectorC().length;x++ ){
         sumatoria+= Math.pow(this.vectorC[x]-aux.getVectorC()[x], 2);
        }
        sumatoria = Math.sqrt(sumatoria);
        
        return sumatoria;
    }

    /**
     * @return the clase
     */
    public String getClase() {
        return clase;
    }

    /**
     * @param clase the clase to set
     */
    public void setClase(String clase) {
        this.clase = clase;
    }

    /**
     * @return the claseResultante
     */
    public String getClaseResultante() {
        return claseResultante;
    }

    /**
     * @param claseResultante the claseResultante to set
     */
    public void setClaseResultante(String claseResultante) {
        this.claseResultante = claseResultante;
    }

    /**
     * @return the vectorC
     */
    public double[] getVectorC() {
        return vectorC;
    }

    /**
     * @param vectorC the vectorC to set
     */
    public void setVectorC(double[] vectorC) {
        this.vectorC = vectorC;
    }
    
    public void SacarDistribucionNormal(ArrayList<PatronBayes> PB, ArrayList<Patron> instancias){
     this.priori=new double[PB.size()];
        this.distribucion_normal=new double[PB.get(0).vectorC.length][PB.size()];  
        for(int j=0;j<PB.size();j++){
        for (int i=0;i<distribucion_normal.length;i++){ 
        this.distribucion_normal[i][j]= (1 / Math.sqrt(2 * Math.PI * PB.get(j).varianza[i])) * Math.pow(Math.E, -((Math.pow(this.getVectorC()[i] - PB.get(j).promedio[i], 2)) / (2 * PB.get(j).varianza[i])));
       
        
        
    }
   
    this.priori[j]=(double)PB.get(j).contador/instancias.size();
    
}
    
}
    
    
public void CalcularProbabilidad(ArrayList<PatronBayes> Clases){
   this.probabilidad=new double[Clases.size()];
    for(int j=0;j<Clases.size();j++){
        this.probabilidad[j]=this.priori[j];
        for(int i=0;i<Clases.get(j).vectorC.length;i++){
            this.probabilidad[j]*=this.distribucion_normal[i][j];
        }
    System.out.println("Clase"+j+"Probabilidad"+this.probabilidad[j]);
    }
    for(int i=1;i<this.probabilidad.length;i++){
        if(i==0){
            this.claseResultante=Clases.get(i).getClase();
        }
        else if(this.probabilidad[i]>this.probabilidad[i-1]){
            this.claseResultante=Clases.get(i).getClase();
        }
    }
}}
