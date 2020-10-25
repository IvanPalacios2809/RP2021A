package data;

public class PatronRepresentativo extends Patron {
    int contador; //Contador sirve para indicar las instancias que se ven involucradas en el promedio de el patron representativo 



    //Constructor
    public PatronRepresentativo(double[] vectorC, String clase) {
        super(vectorC, clase);
        // TODO Auto-generated constructor stub
        contador=0;
    }

    

}
