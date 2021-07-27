import java.util.Scanner;

class Kasir{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //Membuat objek Keranjang dengan panjang inputan user
        System.out.println("Masukkan jumlah produk: ");
        int jumlahBarang = input.nextInt();
        Keranjang keranjang = new Keranjang(jumlahBarang);
        
        //Meminta inputan user sebanyak jumlahBarang
        Scanner input2 = new Scanner(System.in);
        for (int i = 0; i < jumlahBarang; i++ ) {
        	String item = input2.nextLine();
        	String[] itemDanHarga = item.split(" "); //membagi item menjadi 2 bagian
        	//membuat objek barang dan memasukannya ke keranjang.listBarang
        	Barang x = new Barang(itemDanHarga[0], Integer.parseInt(itemDanHarga[1])); 
        	keranjang.listBarang[i] = x;    	       	
        }
        
        //Cetak hasil
        System.out.println("Banyaknya barang yang didiskon adalah " + keranjang.banyakBarangDiskon()
        + " dengan total harga " + keranjang.totalHarga());
    }
}

class Keranjang{
	//Atribut untuk keranjang
    Barang[] listBarang;
    int jumlahItem;

    public Keranjang(int jumlah) {
        jumlahItem = jumlah;
    	listBarang = new Barang[jumlah];
    }
    
    //method mencari tahu banyak barang diskon
    public int banyakBarangDiskon() {
    	int barangDiskon = 0;
    	for (int i = 0; i < jumlahItem; i++) {
    		//Cek setiap huruf pertama barang di listBarang apakah '*' atau bukan
        	if (listBarang[i].barang.substring(0,1).equals("*")) {
        		barangDiskon ++;
        		//Apabila iya, listBarang[i] menjadi barang baru dengan harga diskon  
        		listBarang[i] = new Barang(listBarang[i].barang, listBarang[i].harga - 1000 );      		
        	}
        }
        return barangDiskon;
    }
    
    //method mencari tahu total harga
    public int totalHarga(){
    	int total = 0;
    	//Iterasi tiap item di ListBarang
    	for (Barang item:listBarang) {
    		// total dijumlahkan dengan item.harga
    		total += item.harga;
    	}
    	return total;
    }
}

class Barang{
	//Atribut Barang
	String barang;
	int harga;
	
	Barang(String barang, int harga){
		this.barang = barang;
		this.harga = harga;
	}
}