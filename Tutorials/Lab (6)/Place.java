package Lab06_Rabu;

import java.util.ArrayList;

public class Place {
    private String name;
    private int minPrice;
    private int maxPrice;
    protected ArrayList<Menu> listMenu = new ArrayList<>(); 

    /**
     * Membuat constructor untuk class Place.
     * @param name nama tempat.
     */
    public Place(String name) {
        this.name = name;
    }
    
    /**
     * Mengembalikan nama yang dimiliki oleh suatu tempat.
     * @return nama dari suatu tempat.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Mengembalikan harga minimum dari menu yang dimiliki oleh suatu tempat.
     * @return harga minimum.
     */
    public int getMinPrice() {
        return this.minPrice;
    }

    /**
     * Mengembalikan harga maksimum dari menu yang dimiliki oleh suatu tempat.
     * @return harga maksimum.
     */
    public int getMaxPrice() {
        return this.maxPrice;
    }
    
    /**
     * Menambahkan menu ke dalam suatu tempat.
     * @param menu menu yang akan dimasukkan.
     */
    public void addMenu(Menu menu) {
        if (contains(menu)) {
            System.out.println(String.format("Menu dengan nama %s sudah ada", menu.getName()));
        }
        else {
            this.listMenu.add(menu);
            setMaxMin2();
            System.out.println(String.format("Menu dengan nama %s sudah ditambahkan di %s", menu.getName(), this.getName()));
        }
    }

    /**
     * Menghapus menu dari suatu tempat.
     * @param menu menu yang akan dihapus.
     */
    public void removeMenu(Menu menu) {
        for(Menu tiapMenu: listMenu) {
            if(tiapMenu.getName().equals(menu.getName())) {
                this.listMenu.remove(menu);
                System.out.println(String.format("Menu dengan nama %s sudah dihapus di %s", menu.getName(), this.getName()));
                break;
            }

        }
        System.out.println(String.format("Menu dengan nama %s tidak ada", menu.getName()));
        setMaxMin2();
    }

    /**
     * Mengupdate minPrice dan maxPrice dari suatu tempat.
     * @param price harga yang baru saja masuk ke dalam menu.
     */
    protected void setMinMaxPrice(int price) {
        if (price > this.maxPrice) {
            this.maxPrice = price;
        }
        if (price < this.minPrice) {
            this.minPrice = price;
        }
    }

    /**
     * Mencari apakah suatu menu ada di suatu tempat.
     * @param menu menu yang dicari.
     * @return true jika menu ada di dalam suatu tempat, false jika sebaliknya.
     */
    protected boolean contains(Menu menu) {
        for(Menu eachMenu : listMenu){
            if (eachMenu.getName().equals(menu.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Mendapatkan menu dengan string tertentu.
     * @param menu nama menu yang dicari.
     * @return objek menu yang dicari.
     */
    protected Menu getMenu(String menu) {
        for(Menu eachMenu : listMenu){
            if (eachMenu.getName().equals(menu)) {
                return eachMenu;
            }
        }
        return null;
    }

    public void setMaxMin2() {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (Menu menu : listMenu) {
            if(menu.getPrice() > max) {
                max = menu.getPrice(); 
            }
            if(menu.getPrice() < min){
                min = menu.getPrice();
            }
        }
        minPrice = min;
        maxPrice = max;  
        
    }

    /**
     * Membuat objek dari class Place ke dalam bentuk String.
     * @return format string sesuai dengan format yang ada di soal.
     */
    public String toString() {
        return String.format("%s dengan jangkauan harga Rp %d - Rp %d", this.getName(), this.getMinPrice(), this.getMaxPrice());
    }
}