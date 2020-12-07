/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import clasificadores.Bayes;
import clasificadores.Cmeans;
import clasificadores.MinimaDistancia;
import data.LeerDatos;
import data.Patron;
import data.PatronRepresentativo;

import java.util.ArrayList;
/*
import clasificadores.MinimaDistancia;
*/
/**
 *
 * @author working
 */
public class RP2021A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        ArrayList<Patron> instancias = LeerDatos.tokenizarDataSet();
        
        
        double[] distancias = new double[instancias.size()];
        
        Patron j = new Patron("","", new double[]{2.4,3.3,5.6,7.8});
        for(int x = 0 ; x<  instancias.size();x++){
           distancias[x] =    instancias.get(x).calcularDistancia(j);
        }
        PatronRepresentativo p1= new PatronRepresentativo(arreglo, "hola");
        
        */
        ArrayList<Patron> instancias=LeerDatos.tokenizarDataSet();
        //Bayes b=new Bayes();
        //b.entrenar(instancias);
        Cmeans CM=new Cmeans();
        CM.entrenar(instancias);
        CM.clasificar(instancias);        
//        MinimaDistancia md=new MinimaDistancia();
//        md.entrenar(instancias);
//        md.clasificar(identificadas);
//        System.out.println(md.efectividad(identificadas));
        
        
        // TODO: TOKENIZADOR PARA PODER SEPARAR POR COMAS Y GENERAR UN COLECCION DE PATRONES
        
    }
    
}
