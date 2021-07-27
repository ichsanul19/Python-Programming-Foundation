import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.min;
import static java.lang.Math.max;

public class Lab0 {
    private static int n;
    private static List<Integer> array;

    private static InputReader in;
    private static PrintWriter out;

    // this algorithm run in O(N^2)
    // with N up to 500,000 this algorithm will take roughly 500,000^2 = 250,000,000,000 operations
    // it's higher than 10^8, which is roughly how many operations a regular computer can run in one second
    static int getMaximumProfitN2() {
        int maximumProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                maximumProfit = max(maximumProfit, array.get(j) - array.get(i));
            }
        }
        return maximumProfit;
    }

    // this algorithm run in O(N)
    // with N up to 500,000 this algorithm will take 500,000 operations, less than 10^8
    // it should pass the time limit but will get wrong answer
    static int getMaximumProfitWA() {
        int minimumPrice = Integer.MAX_VALUE;
        int maximumPrice = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            maximumPrice = max(maximumPrice, array.get(i));
            minimumPrice = min(minimumPrice, array.get(i));
        }
        int maximumProfit = maximumPrice - minimumPrice;
        return maximumProfit;
    }

    // this algorithm run in O(N)
    // with N up to 500,000 this algorithm will take 500,000 operations, less than 10^8
    // it should pass the time limit but will runtime error due to a small bug
    // can you guess where it is?
    static int getMaximumProfitRTE() {
        int minimumPrice = Integer.MAX_VALUE;
        int maximumProfit = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currentPrice = array.get(i);
            minimumPrice = min(minimumPrice, currentPrice);
            maximumProfit = max(maximumProfit, currentPrice - minimumPrice);
        }
        return maximumProfit;
    }

    static int getMaximumProfitPodoWae() {
        int minimumPrice = Integer.MAX_VALUE;
        int maximumPrice = Integer.MIN_VALUE;
        int maximumProfit = 0;

        for (int i = 0; i < n; i++) {
            int currentPrice = array.get(i);

            maximumPrice = max(currentPrice, maximumPrice);
            if(currentPrice < minimumPrice) {
                minimumPrice = currentPrice;
                maximumPrice = currentPrice;
            }
            maximumProfit = max(maximumProfit, maximumPrice - minimumPrice);
        }
        return maximumProfit;
    }

    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;
        in = new InputReader(inputStream);
        OutputStream outputStream = System.out;
        out = new PrintWriter(outputStream);

        n = in.nextInt();
        array = new ArrayList<>();
        for(int i=0; i < n; i++) {
            int x = in.nextInt();
            array.add(x);
        }

        int ans = getMaximumProfitRTE();
        
        


        //int ans = Integer.MAX_VALUE;
        out.println(ans);

        // don't forget to close/flush the output
        out.close();
    }

    // taken from https://codeforces.com/submissions/Petr
    // together with PrintWriter, these input-output (IO) is much faster than the usual Scanner(System.in) and System.out
    // please use these classes to avoid your fast algorithm gets Time Limit Exceeded caused by slow input-output (IO)
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
		
		public String nextLine() { 
            String str = ""; 
            try { 
                str = reader.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
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