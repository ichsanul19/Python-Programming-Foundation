import java.io.*;
import java.util.*;

class Lab1 {
    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    public static int[] wallHeight;
    public static int L, N, Q;
    public static int a, b, K;
    public static int x;

    // PrefixSum Dari GeeksforGeeks
    public static void fillPrefixSum(int arr[], int n, int prefixSum[]) 
    { 
        prefixSum[0] = arr[0]; 
  
        // Adding present element 
        // with previous element 
        for (int i = 1; i < n; ++i) 
            prefixSum[i] = prefixSum[i - 1] + arr[i]; 
    } 
    public static void main(String[] args) {
        L = in.nextInt();
        N = in.nextInt();
        Q = in.nextInt();

/*
Ide ini saya dapatkan dari M. Kenta, dia memberi saya clue bahwa idenya adalah
membuat array temp untuk diberi tanda yang nantinya akan dilakukan operasi prefix sum
**/
        // temp yang akan diisi tanda
        int[] tempPrefixSum = new int[L];
        for(int i=0; i < N; i++) {
            a = in.nextInt() - 1; 
            b = in.nextInt();
            K = in.nextInt();

            // menambahkan K di index a
            // menambahkan -K di index b+1
            // agar setelah diproses dengan prefix sum, index a sampai b berisi K 
            
            // Saat nilai pada index b dijumlah dengan nilai pada index b+1, 
            // index b+1 akan bernilai 0 dan seterusnya
            tempPrefixSum[a] += K;
            if(b != L ) {
                tempPrefixSum[b] -= K;
            }
        }      
        wallHeight = new int[L];
        fillPrefixSum(tempPrefixSum, L, wallHeight); // memproses temp untuk mendapatkan tinggi setiap index
  
/*
Ide ini saya dapatkan dari Alif Saddid, dia memberi saya clue bahwa 
buatlah 2 buah array dan hitung masing-masing batas kiri dan kanannya terlebih dahulu
**/
        int[] batasKiri = new int[L];
        batasKiri[0] = 0; 

        int[] batasKanan = new int[L];
        batasKanan[L-1] = L-1;

        for(int i=1; i<L; i++) {
            if(wallHeight[i] < wallHeight[i-1]) {
                batasKiri[i] = i;
            } else {
                batasKiri[i] = batasKiri[i-1];
            }
        }

        for(int i=L-2; i>=0; i--) {
            if(wallHeight[i] < wallHeight[i+1]) {
                batasKanan[i] = i;
            } else {
                batasKanan[i] = batasKanan[i+1];
            }
        }

        // Setelah didapatkan batas kiri dan kanan semua index,
        // selanjutnya adalah menerima input dari user index mana yang akan dicari
        for(int i=0; i<Q; i++) {
            int x = in.nextInt() - 1;
            out.println((batasKiri[x]+1) + " " + (batasKanan[x]+1));
        }
        out.close();
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

// Berkolaborasi dan berdiskusi juga dengan M Fauzi