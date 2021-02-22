
/**
 *
 * @author user10
 */
public interface IVehicle {
    //final static int speed  = 5;
    void speedUp(int increment);
    
    void changeGear(int newValue);
    
    void printState();
}
