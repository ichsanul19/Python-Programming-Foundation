/**
 * author: Muhammad Ichsanul Amal
 */

import java.io.*;
import java.util.*;

public class LabTerakhir {
	private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    
	public static void main(String[] args) {
		int X = in.nextInt();
		int Y = in.nextInt();
		String P = in.next();
		
		HashTable table = new HashTable(X, Y, P);
		out.println(table.getResult());
		out.flush();
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


class HashTable {
	LinkedList<String>[] table;
	int x;
	int y;
	String p;
	
	public HashTable(int x, int y, String p) {
		this.x = x;
		this.y = y;
		this.p=p;
		
		table = new LinkedList[y];
	}
	
	// alphabet weight
	public static int gFunction(char alphabet) {
		return (int)alphabet - 96;
	}
	
	// b^n mod m
	public static int mod(int b, int n, int m) {
		double answer = 1;
		for(int i=1; i<= n; i++) {
			answer = (
						( (answer % m) * (b % m)) 
							% m
					);
		}
		return (int)answer;
	}
	
	// hashing
	public static int fFunction(String subString, int x, int y) {
		int result=0;
		for(int i=0; i<subString.length(); i++) {
			result =
					((result % y) + 
						( ( (gFunction(subString.charAt(i)) % y ) * mod(x, i, y)) % y ) 
					) % y ;
		}
		return result; 
	}
	
	// add all substring to hash table
	public void masukin(String P) {
		for (int i = 0; i < P.length(); i++) {
			   for (int j = i+1; j <= P.length(); j++) {
				   String substring = P.substring(i,j);
				   int index = fFunction(substring, x, y);
				   add(index, substring); // add substring to index after hashing
			   }
		}
	} // P.length * P.length (P.length^2)
	
	public void add(int index, String substring) {
		if(table[index] == null) {
			table[index] = new LinkedList<String>();
			table[index].add(substring);
		} else {
			for (String s:table[index]) {
				
				   if(s.equals(substring))
					   return; 
			}
			table[index].addLast(substring);
		}
	}
	
	// finishing
	
	
	public long getResult() {
		masukin(p);
		long result = 0;
		for(int i=0; i<y; i++) {
			if(table[i] == null) continue;
			
			int currentLinkedListLength = table[i].size();
			
			if(currentLinkedListLength <2) 
				continue;
				
			long comb = NcR(currentLinkedListLength, 2);
			result += comb;
		}
		return result;
	}
	
	
	// combination function efficiently from GeeksforGeeks
	// https://www.geeksforgeeks.org/program-to-calculate-the-value-of-ncr-efficiently/
	static long NcR(int n, int r)
    {
 
        // p holds the value of n*(n-1)*(n-2)...,
        // k holds the value of r*(r-1)...
        long p = 1, k = 1;
 
        // C(n, r) == C(n, n-r),
        // choosing the smaller value
        if (n - r < r) {
            r = n - r;
        }
 
        if (r != 0) {
            while (r > 0) {
                p *= n;
                k *= r;
 
                // gcd of p, k
                long m = __gcd(p, k);
 
                // dividing by gcd, to simplify
                // product division by their gcd 
                // saves from the overflow
                p /= m;
                k /= m;
 
                n--;
                r--;
            }
 
            // k should be simplified to 1
            // as C(n, r) is a natural number
            // (denominator should be 1 ) .
        }
        else {
            p = 1;
        }
 
        // if our approach is correct p = ans and k =1
        return p;
    }
 
    static long __gcd(long n1, long n2)
    {
        long gcd = 1;
 
        for (int i = 1; i <= n1 && i <= n2; ++i) {
            // Checks if i is factor of both integers
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}




