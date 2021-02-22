/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user10
 */
public class Car extends Vehicle{
    private int numberOfSeats;
    
    public Car() {       
    }
    
    public Car(int velocidad, int cambio, int asientos){
        super(velocidad, cambio);
        this.numberOfSeats = asientos;        
    }

    @Override
    public void speedUp(int increment) {
        this.speed = speed + (increment * 2);
    }

    @Override
    public void printState() {
        super.printState();
        System.out.println("numero de asientos: " + numberOfSeats);
    }
    
}
