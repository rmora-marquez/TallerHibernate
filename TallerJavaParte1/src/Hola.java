
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author http://rmora.marquez@gmail.com
 * 
 */
public class Hola {
    
    public static void main(String[] args) {
        System.out.println("Hola mundo...");
        
        int[] unArreglo;
        unArreglo = new int[5];
        unArreglo[0] = 10;
        unArreglo[1] = 20;
        unArreglo[2] = 30;
        unArreglo[3] = 40;
        unArreglo[4] = 50;

        System.out.println("Valor en la posicion 0 es " + unArreglo[0]);
        System.out.println("Valor en la posicion 1 es " + unArreglo[1]);
        System.out.println("Valor en la posicion 2 es " + unArreglo[2]);
        System.out.println("Valor en la posicion 3 es " + unArreglo[3]);
        System.out.println("Valor en la posicion 4 es " + unArreglo[4]);          
        
        /* control de flujo */
        int a = 20;
        int b = 20;
        int c = 30;
        if( a + b == c){
            System.out.println(a + " + " + b + " == " + c);
        }else{
            System.out.println(a + " + " + b + " =/= " + c);
        }
        
        //switch
        Scanner lector = new Scanner(System.in);
        String valor = lector.nextLine();
        int dayOfWeek = Integer.parseInt(valor);
        String dayString = "";
        switch( dayOfWeek ){
            case 1: dayString = "Monday";
            break;
            case 2: dayString = "Tuesday";
            break;
            case 3: dayString = "Wednesday";
            break;
            case 4: dayString = "Thursday";
            break;
            case 5: dayString = "Friday";
            break;
            case 6: dayString = "Saturday";
            break;
            case 7: dayString = "Sunday";
            break;
        }
        System.out.println(dayString);        
        
        int contador = 1;
        while (contador < 11){
            System.out.println("Valor es " + contador);
            contador++;
        }
        
        for(int i = 0; i <= 10; i++){
            System.out.println("Valor es " + i);
        }
        
    }
    
    
    
}
