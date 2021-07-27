package Lab07_Jumat;

public class BigTruck extends Truck {

    // Constructor BigTruck
    public BigTruck(String truckCode, int capacity, int fuel) {
        super(truckCode, capacity, fuel); // memanggil Constructor Truck
    }

    // Override abstract method 
    public void doHorn() {
        System.out.println("Truk " + truckCode + " tot.. tot..");  
    }

    // Override abstract method 
    public void doLaugh() {
        System.out.println("Pengemudi truk " + truckCode + " tertawa EIKEIKEIEKEIEKIEKEIK");
    }

    // Override abstract method 
    public int calculateEstimatedDistance() {
        return fuel * 50;
    }

    // Pengemudi memutar TV di BigTruck
    public void watchTV() {
        System.out.println("Pengemudi truk " + truckCode + " menonton TV");
    }
}
