/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user10
 */
public class Vehicle implements IVehicle {
    protected int speed = 0;
    private int gear = 1;

    public Vehicle() {
    }
    
    public Vehicle(int velocidad, int cambio){
        speed = velocidad;
        gear = cambio;
    }
        
    @Override
    public void changeGear(int newGear){        
        gear = newGear;
    }
    
    @Override
    public void speedUp(int increment){
        speed = speed + increment;
    }
    
    public void printStates(){
        System.out.println(" Velocidad: " + speed + " ,cambio " + gear);
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getGear() {
        return gear;
    }

    public void setGear(int gear) {
        this.gear = gear;
    }

    @Override
    public void printState() {
        System.out.println("Velocidad: " + speed + ", cambio: " + gear);
    }
    
    
}
