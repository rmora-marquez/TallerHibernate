/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user10
 */
public class Truck extends Vehicle {
    private int loadWeight;

    public Truck() {
    }

    public Truck(int peso, int velocidad, int cambio) {
        super(velocidad, cambio);
        this.loadWeight = peso;
    }
    
    public void printStates(){
        super.printStates();
        System.out.println("Peso: " + this.loadWeight );
    }

    public int getLoadWeight() {
        return loadWeight;
    }

    public void setLoadWeight(int loadWeight) {
        this.loadWeight = loadWeight;
    }

    @Override
    public void printState() {
        super.printState();
        System.out.println("peso de la carga: " + loadWeight);
    }
       
    
}
