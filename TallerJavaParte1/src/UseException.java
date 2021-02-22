
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user10
 */
public class UseException {
    public static void main(String[] args) {
        String nullString = null;
        try{
            System.out.println( nullString.substring(1) );
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("No se puede leer la cadena de texto");
        }
        
        List<String> androids = new ArrayList<>();
        androids.add("Cupcake");
        androids.add("Donut");
        androids.add("Eclair");
        androids.add("Froyo");
        
        for(String version : androids){
            System.out.println(version);
        }
    }
}
