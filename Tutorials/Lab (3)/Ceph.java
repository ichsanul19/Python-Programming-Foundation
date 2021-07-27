import java.util.Scanner;

public class Ceph {
	/*
	 * Method untuk mencetak array 2 dimensi berisi integer
	 */
	public static void print2D(int[][] arr) {
		for(int i = 0; i < arr.length; i++) { 
			int[] insideArr = arr[i]; 
			for(int j = 0; j < insideArr.length; j++) {
				System.out.print(insideArr[j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		System.out.println("Masukkan ukuran board\n" + 
				"(kolom<spasi>baris) :");
		Scanner input = new Scanner(System.in);
		int kolom = input.nextInt();
		int baris = input.nextInt();
		
		// Inisiasi varibel board_1, board_2, dan jumlah
		int[][] board_1 = new int[baris][kolom];
		int[][] board_2 = new int[baris][kolom];
		int[][] jumlah = new int[baris][kolom];
		
		System.out.println("Masukkan board ke 1:"); //Looping sebanyak baris dan kolom
		for (int i = 0; i<baris; i++) {
			for (int j = 0; j<kolom; j++) {
				int x = input.nextInt();
				board_1[i][j] = x; //Memasukkan angka dari inputan ke index i,j
			}
		}
		
		System.out.println("Masukkan board ke 2:"); //Looping sebanyak baris dan kolom
		for (int i = 0; i<baris; i++) {
			for (int j = 0; j<kolom; j++) {
				int x = input.nextInt();
				board_2[i][j] = x; //Memasukkan angka dari inputan ke index i,j
			}
		}
		
		for (int i = 0; i<baris; i++) { //Looping sebanyak baris dan kolom
			for (int j = 0; j<kolom; j++) {
				// Menjumlahkan tiap elemen yang bersesuaian dengan index
				int y = board_1[i][j] + board_2[i][j];  
				jumlah[i][j] = y;
			}
		}
		
		// Output
		System.out.println("Hasil proses dari 2 board tersebut adalah");
		print2D(jumlah);
	}
}
// Sebenarnya tidak perlu membuat variabel baru bernama jumlah
// Tinggal menambahkan semuanya di 'Masukkan board ke 2' dan print setiap elemennya
// Namun saya sudah terlanjur 