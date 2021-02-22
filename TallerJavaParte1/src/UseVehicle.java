
/**
 *
 * @author user10
 */
public class UseVehicle {
        
    public static void main(String[] args) {
        Vehicle auto1 = new Vehicle();                
       
        auto1.printStates();
        auto1.speedUp(5);
        auto1.printStates();
        auto1.changeGear(2);
        auto1.printStates();
        
        auto1.setSpeed(500);
        int velocidad = auto1.getSpeed();
        
        Truck troca = new Truck(20, 0, 1);
        troca.changeGear(3);
        troca.speedUp(80);
        troca.printStates();
        //int peso = troca.getLoadWeight();
        //System.out.println("El Peso de la troca es : " + peso);
        //System.out.println("El Peso de la troca es : " + troca.getLoadWeight() );
        
        Car carro = new Car(0, 1, 2);
        carro.speedUp(80);
        carro.printStates();
        
        IVehicle v1, v2, v3;
        v1 = new Vehicle(10,4);
        v2 = new Car(20, 2, 4);
        v3 = new Truck(50, 40, 3);
        
        v1.printState();
        v2.printState();
        v3.printState();
        
    }
    
}
