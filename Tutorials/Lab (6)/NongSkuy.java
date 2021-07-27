package Lab06_Rabu;

import java.util.ArrayList;
//import java.util.Collections;

public class NongSkuy{
  
    private static ArrayList<Place> placeList;

    public static void main(String[] args){

        placeList = new ArrayList<>();
        Place warteg = new Warteg("Bahari Jaya");
        Place warkop = new Warkop("Puma");
        Place cafe = new Cafe("Pinang Coffee");
        Place angkringan = new Angkringan("Angkringan Kutek");

        placeList.add(warteg);
        placeList.add(warkop);
        placeList.add(cafe);
        placeList.add(angkringan);
        System.out.println();

        // MENU DI WARTEG
        Menu telurDadar = new Menu("Telur Dadar", 5000);
        Menu sop = new Menu("Sop", 6000);
        Menu atiAmpela = new Menu("Ati Ampela", 3000);
        Menu ayamGoreng = new Menu("Ayam Goreng", 7000);
        warteg.addMenu(telurDadar);
        warteg.addMenu(sop);
        warteg.addMenu(ayamGoreng);
        warteg.addMenu(atiAmpela);
        warteg.addMenu(sop);
        System.out.println();
        
        // MENU DI WARKOP
        Menu kopiAceh = new Menu("Kopi Aceh", 15000);
        Menu kopiDepok = new Menu("Kopi Depok", 4000);
        Menu kopiLuwak = new Menu("Kopi Luwak", 20000);
        Menu kopiABC = new Menu("Kopi ABC", 3000);
        Menu kopiKopian = new Menu ("Kopi KW", 2000);
        warkop.addMenu(kopiAceh);
        warkop.addMenu(kopiDepok);
        warkop.removeMenu(kopiKopian);
        warkop.addMenu(kopiLuwak);
        warkop.addMenu(kopiLuwak);
        warkop.addMenu(kopiABC);
        System.out.println();

        // MENU DI CAFE
        Menu frenchFries = new Menu("French Fries", 15000);
        Menu bananaNugget = new Menu("Banana Nugget", 23000);
        Menu matchaLatte = new Menu("Matcha Latte", 20000);
        Menu americano = new Menu("Americano", 18000);
        cafe.addMenu(frenchFries);
        cafe.addMenu(bananaNugget);
        cafe.addMenu(matchaLatte);
        cafe.addMenu(americano);
        System.out.println();

        // MENU DI ANGKRINGAN
        Menu sateKulit = new Menu("Sate Kulit Ayam", 3000);
        Menu sateAyam = new Menu("Sate Daging Ayam", 3000);
        Menu sateUsus = new Menu("Sate Usus Ayam", 3000);
        Menu satePuyuh = new Menu("Sate Telur Puyuh", 3000);
        angkringan.addMenu(sateKulit);
        angkringan.addMenu(sateAyam);
        angkringan.addMenu(sateUsus);
        angkringan.addMenu(satePuyuh);

        System.out.println();
        printInfoTiapPlace(placeList);
        System.out.println();
            
        ArrayList<Place> searchedPlaces = searchPlace(3000, 8000);
        System.out.println("*** Tempat yang semua menunya dalam harga 3000-8000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();
        
        searchedPlaces = searchPlace(10000, 15000);
        System.out.println("*** Tempat yang semua menunya dalam harga 10000-15000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();
        
        searchedPlaces = searchPlace(14000);
        System.out.println("*** Kamu bisa makan ditempat ini kalau punya uang 14000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();

        angkringan.removeMenu(sateAyam);
        warkop.removeMenu(kopiKopian);
        warkop.removeMenu(kopiABC);
        System.out.println();

        searchedPlaces = searchPlace(10000);
        System.out.println("*** Kamu bisa makan ditempat ini kalau punya uang 10000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();

        searchedPlaces = searchPlace(4000, 10000);
        System.out.println("*** Tempat yang semua menunya dalam harga 4000-10000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();

        searchedPlaces = searchPlace(3000, 10000);
        System.out.println("*** Tempat yang semua menunya dalam harga 3000-10000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();

        warteg.addMenu(kopiKopian);
        System.out.println();

        searchedPlaces = searchPlace(2000, 7000);
        System.out.println("*** Tempat yang semua menunya dalam harga 2000-7000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();

        searchedPlaces = searchPlace(3000, 7000);
        System.out.println("*** Tempat yang semua menunya dalam harga 3000-7000");
        printInfoTiapPlace(searchedPlaces);
        System.out.println();
    }

    /**
     * Mencari tempat dengan maksimum harga tertentu.
     * @param maxPrice minimum harga yang dicari.
     * @return tempat-tempat hasil dari pencarian.
     */
    public static ArrayList<Place> searchPlace(int maxPrice) {
        ArrayList<Place> listRentang = new ArrayList<>();
        //if(placeList.size() != 0) {
            for(Place place : placeList) {
                if(place.getMinPrice() <= maxPrice) {
                    listRentang.add(place);    
                }
            }
        //}
        return listRentang;
    }

    /**
     * Mencari tempat dengan semua harga menu yang masuk dalam rentang harga tertentu.
     * @param minPrice minimum harga yang dicari.
     * @param maxPrice maksimum dari minimum harga yang dicari.
     * @return tempat-tempat hasil dari pencarian.
     */
    public static ArrayList<Place> searchPlace(int minPrice, int maxPrice) {
        ArrayList<Place> listRentang = new ArrayList<>();
        //if(placeList.size() != 0) {
            for(Place place : placeList) {
                if(place.getMinPrice() >= minPrice && 
                        place.getMaxPrice() <= maxPrice) {
                    listRentang.add(place);    
                }
            }
        //}
        return listRentang;
        
    }

    /**
     * Melakukan print info suatu arraylist of place.
     * @param arr ArrayList yang akan di print.
     */
    public static void printInfoTiapPlace(ArrayList<Place> arr){
        if (arr.size() == 0){
            System.out.println("Tidak ada tempat yang ditemukan."); 
        }	
        else {
            System.out.println("Berikut adalah info tiap-tiap tempat:");
            for (int i = 0 ; i < arr.size() ; i++){
                Place place = arr.get(i);
                System.out.println((i+1) + ") " + place.toString());
            }
        }
    }
}