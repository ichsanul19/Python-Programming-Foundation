import java.util.Scanner;

// Membuat class sesuai nama file
public class Tiket {
	
	//main method
	public static void main(String[] args) {
		
	// Menginisiasi class Scanner untuk membaca input dari user
	Scanner input = new Scanner(System.in);
	System.out.print("Masukkan harga dasar tiket: Rp");
	int hargaDasar = input.nextInt();
	
	// Menginisiasi scanner baru untuk menghindari error 
	Scanner input2 = new Scanner(System.in);
	System.out.print("Masukkan nama:");
	String nama = input2.nextLine();
	
	System.out.print("Masukkan usia:");
	int usia = input2.nextInt();
	input2.close();
	
	// Masukkan variabel baru
	int harga;
	
	// If else condition 
	if(usia < 15) harga = hargaDasar;
	else if(usia < 23) harga = 2 * hargaDasar;
	else if(usia < 30) harga = 3 * hargaDasar;
	else harga = 4 * hargaDasar;
	
	// Cetak hasil
	System.out.println(nama + " yang berusia " + usia 
			+ " tahun, harus membayar tiket sebesar Rp"
			+ harga + ".");
	
			
	}
}
