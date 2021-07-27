package Lab07_Jumat;

public class MediumTruck extends Truck {

    // Constructor MediumTruck
    public MediumTruck(String truckCode, int capacity, int fuel) {
        super(truckCode, capacity, fuel); // memanggil Constructor Truck
    }

    // Override abstract method 
    public void doHorn() {
        System.out.println("Truk " + truckCode + " tet.. tet..");
    }

    // Override abstract method 
    public void doLaugh() {
        System.out.println("Pengemudi truk " + truckCode + " tertawa HEKHEKHEK");
    }

    // Override abstract method 
    public int calculateEstimatedDistance() {
        return fuel*75;
    }

    // Pengemudi membunyikan telolet di MediumTruck
    public void doTelolet() {
        System.out.println("Pengemudi truk " + truckCode + " membunyikan telolet.. telolet..");
    }
}
