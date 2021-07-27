import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

public class TpOne {
    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    public static int O;
    
    public static ArrayList<String> arr = new ArrayList<String>(); //untuk tiap maks
    
    public static int[] ladang;

    public static void main(String[] args) {
        

        // Banyak ladang
        int N = in.nextInt();

        ladang = new int[N];
        for(int i=0; i<N; i++) {
            int jumlahAi = in.nextInt();
            ladang[i] = jumlahAi;
        }

        // Banyak keranjang dan Isinya 
        int M = in.nextInt();        

        for(int i=0; i<M; i++) {
            String S = in.next();
            int C = in.nextInt();
            int F = in.nextInt();
            
            int maxKeranjang = knapsack4(ladang, C, F);
             
            String ker = S + " " + maxKeranjang;
            arr.add(ker);
            insertSortAkhirElemen(arr);
        }
        
        // Banyak hari
        int H = in.nextInt();
        int hari = 1;
        
        Queue<String> antrian = new LinkedList<String>();
        Queue<String> antrianIzuri = new LinkedList<String>();
        
        //boolean change = false;
        String hasilPanen = "";
        
        while(hari != H+1) {
        	boolean change = false;
        	
        	out.println("Hari ke-" + hari + ":"); 
             
            if(hari>1) {	
                out.println("Permintaan yang dilayani");
                
                for(int i=1; i<=O; i++) {    
                    
                    String query = (String)(antrian.poll());
                    String[] perintah = query.split(" ");
                    
                    String Q = perintah[1];
                    
                    out.print(perintah[0] + " ");

                    if(Q.equals("ADD")) {
                    	if(tambah(arr, perintah[2], Integer.parseInt(perintah[3]), Integer.parseInt(perintah[4]))) {
                    		change = true;
                    	}
                    } else if(Q.equals("SELL")) {
                    	if(remove(arr, perintah[2])) {
                    		change = true;
                        }
                    } else if(Q.equals("UPDATE")) {
                    	if(update(arr, perintah[2], Integer.parseInt(perintah[3]), Integer.parseInt(perintah[4]))) {
                    		change = true;
                    	}
                    } else if(Q.equals("RENAME")) {
                    	if(rename(arr, perintah[2], perintah[3])) {
                    		change = true;
                    	}
                    }
                }

                String query = (String)(antrianIzuri.poll());
                String[] perintah = query.split(" ");
                String Q = perintah[0];

                if(Q.equals("ADD")) {
                	if(tambah(arr, perintah[1], Integer.parseInt(perintah[2]), Integer.parseInt(perintah[3]))) {
                		change = true;
                	}
                } else if(Q.equals("SELL")) {
                	if(remove(arr, perintah[1])) {
                		change = true;
                	}
                } else if(Q.equals("UPDATE")) {
                	if(update(arr, perintah[1], Integer.parseInt(perintah[2]), Integer.parseInt(perintah[3]))) {
                		change = true;
                	}
                } else if(Q.equals("RENAME")) {
                	if(rename(arr, perintah[1], perintah[2])) {
                		change = true;
                	}
                }
                out.println("IZURI");
            }   
            
            // Inputan tiap hari
            if(hari != H) {
            	//Query Izuri
            	String Izuri = readQuery();
                antrianIzuri.add(Izuri);
                //Query pendaftar
                int Y = in.nextInt();
                for(int i=0; i<Y; i++) {
                	String namaPendaftar = in.next();
                    namaPendaftar += " " + readQuery();
                    antrian.add(namaPendaftar);
                }
                
                O = in.nextInt();
            }
            
            out.println("Hasil Panen");
            
            
           if(change || hari ==1) {
        	   hasilPanen = "";
        	   //for(String str:arr) {
        		 //  String[] s = str.split(" ");
        		   //hasilPanen += s[0] + " " + s[1] + "\n";  
        	   //}
        	   
        	   
        	   hasilPanen = String.join("\n", arr);
        	   
               
           }
           
           
           
           out.println(hasilPanen);
           out.println();
           hari++;
        }
        out.close();
    }
    
    public static String readQuery() {
    	String perintahIzuri = in.next();
    	String aa = perintahIzuri + " ";
    	
        if(perintahIzuri.equals("ADD")) {
        	String S = in.next();  
        	int C = in.nextInt();
        	int F = in.nextInt();
        	aa += S + " " + C + " " + F;
        } else if(perintahIzuri.equals("SELL")) {
        	String S = in.next();
        	aa += S;
        } else if(perintahIzuri.equals("UPDATE")) {
        	String S = in.next();  
        	int C = in.nextInt();
        	int F = in.nextInt();
        	aa += S + " " + C + " " + F;
        } else if(perintahIzuri.equals("RENAME")) {
        	String S = in.next();
        	String SNew = in.next();
        	aa += S + " " + SNew;
        }
        return aa;
    }
    
    public static void insertSortAkhirElemen(ArrayList<String> keranjang) {
    	if(keranjang.size() <= 1) {
    		return;
    	}
    	for(int i= keranjang.size()-1; i>0; i--) {
    		String[] a = keranjang.get(i).split(" ");
    		String namaKeranjang = a[0];
    		int maxKeranjang = Integer.parseInt(a[1]);
    		
    		String[] aBefore = keranjang.get(i-1).split(" ");
    		String namaKeranjangBefore = aBefore[0];
    		int maxKeranjangBefore = Integer.parseInt(aBefore[1]);
    		
    		if(maxKeranjang > maxKeranjangBefore) {
    			keranjang.set(i-1, namaKeranjang + " " + maxKeranjang);
    			keranjang.set(i, namaKeranjangBefore + " " + maxKeranjangBefore);
    		} else if(maxKeranjang == maxKeranjangBefore && namaKeranjang.compareTo(namaKeranjangBefore) < 0) {
    			keranjang.set(i-1, namaKeranjang + " " + maxKeranjang);
    			keranjang.set(i, namaKeranjangBefore + " " + maxKeranjangBefore);
    		} else {
    			break;
    		}
    	}
    }
    
    public static boolean tambah(ArrayList<String> keranjang, String n, int c, int f) {
    	for(String obj: keranjang) {
    		String[] tempKer = obj.split(" ");
    		String nama = tempKer[0];
    		
    		if(nama.equals(n)) {
    			return false;
    		}
    	}
        int maxKeranjang = knapsack4(ladang, c, f);

        keranjang.add(n + " " + maxKeranjang);
        insertSortAkhirElemen(keranjang);
        return true;    	 
    }
    
    public static boolean remove(ArrayList<String> keranjang, String n) {
    	boolean removeIf = keranjang.removeIf(ob -> (ob.split(" ")[0]).equals(n));
    	if(removeIf) {
    		return true;
    	}
    	return false;
    }
    
    public static boolean update(ArrayList<String> keranjang, String n, int c, int f) {
    	boolean removeIf = keranjang.removeIf(ob -> (ob.split(" ")[0]).equals(n));
    	if(removeIf) {
    		int maxKeranjang = knapsack4(ladang, c, f);
	        keranjang.add(n + " " +maxKeranjang);
	        insertSortAkhirElemen(keranjang);
	        return true;
    	}    	
    	return false;
    }
    
    public static boolean rename(ArrayList<String> keranjang, String n, String nNew) {
    	int index = -1;
    	for(int i=0; i<keranjang.size(); i++) {
    		String[] ker = keranjang.get(i).split(" ");
    		String nama = ker[0];
    		
    		if(nama.equals(nNew)) return false;
    		if(nama.equals(n)) index=i;
    	}
    	
    	if(index == -1) {
    		return false;
    	}
    	
    	String[] objekn = keranjang.remove(index).split(" ");
		keranjang.add(nNew + " " + objekn[1]);
		insertSortAkhirElemen(keranjang);
		return true;
    }
    
    public static int knapsack4(int[] ladang, int C, int F) {
    	int[][] value = new int[ladang.length+1][ladang.length+1];
    	int max = 0;
    	
    	for(int i=0; i< value.length; i++) {
    		for(int j=0; j<= i; j++) {
    			int nowCapacity = C+(j-1)*F;
    			
    			if(i == 0 || j == 0) {
    				value[i][j] = 0;
    			} else {
    				// Baris temp ini terinspirasi dari Alif Saddid
    				int temp =  Math.max(value[i-1][j] + Math.min(ladang[i-1], nowCapacity-value[i-1][j]), 
    						value[i-1][j-1]);
    				value[i][j] = temp > nowCapacity? nowCapacity:temp;  
    			}    		    		
    			max = Math.max(max, value[i][j]);
    		}
    	}    	
    	return max;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
    
}