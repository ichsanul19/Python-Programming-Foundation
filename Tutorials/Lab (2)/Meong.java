import java.util.Scanner;

public class Meong {
	
	public static void gestur(String huruf, int jumlah) {
    	if(jumlah == 0)
    		System.out.print("");
    	else {
    		System.out.print(huruf);
    		gestur(huruf, jumlah-1);
    	}
	}
	
	public static String meongTranslate2(String kata, String nada) {
		if(kata.length() == 1) {
			char huruf = kata.charAt(0);
			int nadaSingle = Character.getNumericValue(nada.charAt(0));
			
			if( ((int)(huruf + nadaSingle) <= (int)'z')) {
				return Character.toString((char) ((int)(huruf + nadaSingle)));
			}
			else { 
				return Character.toString((char) ((int)(huruf - (26 -nadaSingle))));
			}
		}
		else {
			char huruf = kata.charAt(0);
			int nadaSingle = Character.getNumericValue(nada.charAt(0));
			return Character.toString(huruf+nadaSingle) + meongTranslate2(kata.substring(1), nada.substring(1));
		}
	}
		
	public static void meongTranslate(String kata, String nada, int n) {
		String s = "";
		for(int i=0 ; i<kata.length(); i++) {
			Character c;
			c = (char) ((int)kata.charAt(i) + Character.getNumericValue(nada.charAt(i)));
			if ((int)c > (int)'z'){
	            c =  (char) ((int)kata.charAt(i) - (26 - Character.getNumericValue(nada.charAt(i))));
			}
	        s += c;
			}
		gestur(s, n);
	}

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Masukkan kata:");
		String kata = input.nextLine();
		
		System.out.print("Masukkan nada: ");
		String nada = input.nextLine();
		
		System.out.print("Masukkan tepukan: ");
		int tepukan = input.nextInt();
		
		gestur(meongTranslate2(kata, nada), tepukan);
		
		//meongTranslate adalah versi loop
		//meongTranslate2 adalah rekursif
	}

}
