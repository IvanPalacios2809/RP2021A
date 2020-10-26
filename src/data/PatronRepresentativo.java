package data;

import java.util.ArrayList;

public class PatronRepresentativo extends Patron {
    int contador; //Contador sirve para indicar las instancias que se ven involucradas en el promedio de el patron representativo 



    //Constructor
    public PatronRepresentativo(double[] vectorC, String clase) {
        super(vectorC, clase);
        // TODO Auto-generated constructor stub
        this.contador=0;
    }
    public void  AgregarUnoAlContador(){
        this.contador++;
     }
     public int getContador(){
         return this.contador;
     }
     public void setContador(int contador){
         this.contador=contador;
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

    public static void promediar(ArrayList<PatronRepresentativo> PatronesRepresentativos){
        //System.out.println(""+(PatronesRepresentativos.size()));
        
        for(int j=0;j<PatronesRepresentativos.size();j++){
            for(int i=0;i<PatronesRepresentativos.get(j).getVectorC().length-1;i++){
                double CantidadPromediada=PatronesRepresentativos.get(j).vectorC[i]/PatronesRepresentativos.get(j).contador;
                PatronesRepresentativos.get(j).vectorC[i]=CantidadPromediada;
            }
        }
    }

}
