package Lab07_Jumat;

public class SmallTruck extends Truck {

    // Constructor SmallTruck
    public SmallTruck(String truckCode, int capacity, int fuel) {
        super(truckCode, capacity, fuel); // memanggil Constructor Truck
    }

    // Override abstract method 
    public void doHorn() {
        System.out.println("Truk " + truckCode + " tin.. tin..");    
    }

    // Override abstract method 
    public void doLaugh() {
        System.out.println("Pengemudi truk " + truckCode + " tertawa HAHAHAHAHA");
    }

    // Override abstract method 
    public int calculateEstimatedDistance() {
        return fuel * 100;
    }

    // Pengemudi memutar musik di SmallTruck
    public void playMusic() {
        System.out.println("Pengemudi truk " + truckCode + " memutar lagu");
    }
}
