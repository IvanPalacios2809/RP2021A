/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rp2021a;

import clasificadores.Bayes;
import clasificadores.Cmeans;
import clasificadores.MinimaDistancia;
import clasificadores.knn;
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
        
        ArrayList<Patron> instancias = LeerDatos.tokenizarDataSet();
        //ArrayList<Patron> identificadas=LeerDatos.tokenizarDataSet(); //Uso unicamente para patron bayes.
       MinimaDistancia md=new MinimaDistancia();
       knn kenene=new knn();
       kenene.entrenar(instancias);
       kenene.clasificar(instancias); 
        
    
        
        
        
        
              
    }
    
}
