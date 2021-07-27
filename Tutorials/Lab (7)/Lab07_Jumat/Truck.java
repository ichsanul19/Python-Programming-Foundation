package Lab07_Jumat;

public abstract class Truck {
    protected String truckCode;
    protected int capacity;
    protected String status;
    protected int numDonut;
    protected int fuel;

    public static final String C_STATUS_READY = "READY";
    public static final String C_STATUS_DEPARTED = "DEPARTED";
    public static final String C_STATUS_ARRIVED = "ARRIVED";

    // Constructor Abstract class Truck
    public Truck(String truckCode, int capacity, int fuel) {
        this.truckCode = truckCode;
        this.capacity = capacity;
        this.fuel = fuel;
        status = C_STATUS_READY;
        numDonut = 0;
        // pada awalnya status READY dan numDonut = 0
    }

    /* Abstract Method untuk dioverride di subclassnya */
    
    // Mengestimasi jarak yang bisa ditempuh tergantung tiap subclass
    public abstract int calculateEstimatedDistance();

    // Membunyikan Horn tergantung tiap subclass
    public abstract void doHorn();

    // Pengemudi tertawa tergantung tiap subclass
    public abstract void doLaugh();

    
    /* Concrete Method */

    // cek status dan kapasitas donat, kemudian load donat
    public void loadDonut(int newDonut) {
        if(this.status == C_STATUS_READY) {
            // Cek numDonut kurang dari capacity
            if (this.numDonut + newDonut <= capacity) {
                this.numDonut += newDonut;
                System.out.println(newDonut + " donat berhasil ditambah ke truk " + truckCode);
            } else {
                System.out.println("Donat tidak dapat ditambah ke truk " + truckCode);
            }
        } else {
            System.out.println("Donat tidak dapat ditambah ke truk " + truckCode);
        }
    }

    // cek status dan unload donat
    public void unloadDonut() {
        if (this.status == C_STATUS_ARRIVED) {
            System.out.println(this.numDonut+ " donat berhasil dikeluarkan dari truk " + this.truckCode);
            this.numDonut -= this.numDonut; // numDonut kembali menjadi 0
        } else {
            System.out.println("Truk " + this.truckCode + " tidak dapat mengeluarkan donat");
        }
    }

    // cek status dan jarak, kemudian berangkat
    public void depart(int distance) {
        // Cek status ready dan distance kurang dari int calculateEstimatedDistance()
        if (this.status == C_STATUS_READY && calculateEstimatedDistance() >= distance) {
            System.out.println("Truk " + this.truckCode + " telah berangkat membawa " + this.numDonut + " donat");
            // Apabila Iya status berganti menjadi departed
            this.status = C_STATUS_DEPARTED;
        } else {
            System.out.println("Truk " + this.truckCode + " yang membawa " + this.numDonut + " donat tidak dapat berangkat");
        }
    }

    // cek status, kemudian truck sampai
    public void arrive() {
        if (this.status == C_STATUS_DEPARTED) {
            this.status =  C_STATUS_ARRIVED;
            System.out.println("Truck " + this.truckCode + " telah sampai");
        } else {
            System.out.println("Truck " + this.truckCode + " sepertinya belum berangkat");
        }

        
    }
}
