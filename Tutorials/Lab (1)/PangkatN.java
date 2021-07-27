import java.util.Scanner;

//Membuat class sesuai nama file
public class PangkatN {
	
	//main method
	public static void main(String[] args) {
		
		// Menginisiasi class Scanner untuk membaca input dari user
		Scanner input = new Scanner(System.in);
		
		System.out.println("Masukkan angka untuk dipangkatkan n: ");
		int angka = input.nextInt();
		
		System.out.println("Masukkan n: ");
		int N = input.nextInt();
		
		// Masukkan variabel baru
		int i = 1;
		int angkaAwal = angka;
		
		// While condition
		while(i < N) {
			angka *= angkaAwal;
			i++;
		}
		
		// Cetak hasil dari while condition
		System.out.println(angkaAwal + " pangkat " + N + " adalah " + angka);
		
		// Memeriksa genap atau ganjil
		if(angka % 2 == 0) System.out.println("Hasilnya genap");
		else System.out.println("Hasilnya ganjil");
		
}
}
