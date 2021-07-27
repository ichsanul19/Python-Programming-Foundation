/**
 * author: Muhammad Ichsanul Amal
 * Code source	:
 *	* Slide SDA, SDA-15.Graph-v2
 * inspirator	: 
 *	* M. Alif Saddid
 */
 
import java.io.*;
import java.util.*;

public class TP2 {
	private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);
    
    public static Graph graph = new Graph();

	public static void main(String[] args) {
		int N = in.nextInt();
		int M = in.nextInt();
		int E = in.nextInt();
		int Q = in.nextInt();
		
		for(int i=0; i<N; i++) {
			String namaToko = in.next();
		} // N
		
		for(int i=0; i<M; i++) {
			String A = in.next();
			String B = in.next();
			
			int C = in.nextInt();
			int K = in.nextInt();
			int T = in.nextInt();
			
			graph.findBasis(K); // akar(K)
			graph.addEdge(A, B, C, K, T, false);
		} // M * akar(K)
		// 
		
		for(int i=0; i<E; i++) {
			String F = in.next();
			String G = in.next();
			
			int C = 1;
			int L = in.nextInt();
			int U = in.nextInt();
			
			graph.findBasis(L); // akar(L)
			graph.addEdge(F, G, C, L, U, true);
		} // E * akar(L)
		
		for(int i=0; i<Q; i++) {
			String q = in.next();
			
			if(q.equals("TANYA_JALAN")) {
				int X = in.nextInt();
				
				int banyakJalan = graph.tanyaJalan(X); // (N + M + E)
				out.println(banyakJalan);
				
			} else if(q.equals("TANYA_HUBUNG")) {
				String S1 = in.next();
				String S2 = in.next();
				out.println(graph.dijkstraTanyaHubung(S1, S2)?"YA":"TIDAK"); 
				// N + (M + E)logN 
				
			} else if(q.equals("TANYA_KUPON")) {
				String S1 = in.next();
				String S2 = in.next();
				
				int minimalKupon = (int)graph.dijkstraTanyaKupon(S2, S1);
				out.println(minimalKupon);
				
				// (N + (M + E)logN) + (akar(K) + akar(L))log(K + N) 
			} else if(q.equals("TANYA_EX")) {
				String S1 = in.next();
				String S2 = in.next();
				
				int maximalWaktu = graph.dijkstra4(true, S2, S1);
				out.println(maximalWaktu);
				// log(100.000) * (N + (M + E)logN)
				// N + (M + E)logN
				
			} else if(q.equals("TANYA_BIASA")) {
				String S1 = in.next();
				String S2 = in.next();
				
				int maximalWaktu = graph.dijkstra4(false, S2, S1);
				out.println(maximalWaktu);
				// N + (M + E)logN
			} // Q * ( N + (M * akar(K)) + (E * akar(L)) +
			// (N + M + E) +(N + (M + E)logN) + (akar(K) + akar(L))log(K + N)
			
			
			// Q * (N + (M * akar(K)) + (E * akar(L)) + (M + E)logN + (akar(K) + akar(L))log(K + N))
		}
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

class Graph {
	public static final double INFINITY = Integer.MAX_VALUE;
	
	private Map<String,Vertex> vertexMap = new HashMap<String,Vertex>(); //List Vertex
	private int basis=-1; //init basis
	
	
	public void addVertex(String name) {
		vertexMap.put(name, new Vertex(name));
	}
	
	// Find basis after edge is added to the graph
	public void findBasis(int K) {
		
		if(this.basis == -1 || this.basis==1) {
			this.basis=K; 
			return;
		}
		if(this.basis == K) return;
		
		if(K == 1) return;
		
		
		int temp; // temp is the smallest between K and the current basis
		if(K < this.basis) {
			temp = K;
			K = this.basis;
		} else {
			temp = this.basis;
		}
		
		// Set basis if (temp)log(K) is integer 
		double tempHasil = Math.log10(K) / Math.log10(temp);
		if(Math.floor(tempHasil) == tempHasil) {
			this.basis = temp;
			return;
		}
		
		// Find the right basis between two number
		for(int i=(int)Math.sqrt(temp)+1; i>1; i--) {
			double tempHasilTemp = Math.log10(temp) / Math.log10(i);
			double tempHasilK = Math.log10(K) / Math.log10(i);
			
			if(Math.floor(tempHasilTemp) == tempHasilTemp)
				if(Math.floor(tempHasilK) == tempHasilK)
					this.basis = i;
		}
	}

	public void addEdge(String source, String dest, int C, int K, int T, boolean eksklusif) {
		Vertex v = getVertex(source);
		Vertex w = getVertex(dest);
		
		if(eksklusif) {
			Edge vw = new Edge(w, 1, K, T, true);
			v.adj.add(vw);
			
			Edge wv = new Edge(v, 1, K, T, true);
			w.adj.add(wv);
		} else {
			Edge vw = new Edge(w, C, K, T, false);
			v.adj.add(vw);
			
			Edge wv = new Edge(v, C, K, T, false);
			w.adj.add(wv);
		}
	}
	
	public int tanyaJalan(int maxTime) {
		int counter = 0;		
		
		for(Vertex v:vertexMap.values()) {
			for(Edge w:v.adj) {
				if(w.T > maxTime) {
					counter++;
				}
			}
		}
		return counter/2;
	}
	
	// Helper for tanyaEx and tanyaBiasa
	public double helperDjikstra(boolean eksklusif, String startName, String destName, int jawaban) {
		PriorityQueue<Path> pq = new PriorityQueue<Path>();
		
		Vertex start = vertexMap.get(startName);
		Vertex end = vertexMap.get(destName);
		
		clearAll();
		pq.add(new Path(start, jawaban)); 
		start.dist = jawaban;
		
		int nodesSeen = 0;
		while(!pq.isEmpty() && nodesSeen < vertexMap.size()) {
			Path vrec = pq.remove();
			Vertex v = vrec.dest;
			if(v.scratch != 0) // already processed v
				continue;
		
			v.scratch = 1;
			nodesSeen++;
		
			for(Edge e : v.adj) {
				if(!e.eksklusif == eksklusif) {
					continue;
				}
				
				Vertex w = e.dest;
				int cvw = e.C;
				
				if(w.dist > v.dist + cvw && v.dist + cvw <= e.T) {
					w.dist = v.dist + cvw;
					pq.add(new Path(w, w.dist));
				}
			}
		}
		return end.dist;
	}
	
	public int dijkstra4(boolean eksklusif, String startName, String destName) {
		Vertex start = vertexMap.get(startName);
		Vertex end = vertexMap.get(destName);
		
		if(start == null || end == null) {
			return -1;
		}
		
		// searching answer in the number between 0-100.000, idea from Alif
		int startAnswer = 0;
		int endAnswer = 100000;
		
		while(endAnswer != 0 ) {
			double tempAnswer = helperDjikstra(eksklusif, startName, destName, (startAnswer+endAnswer) /2);
			
			if(tempAnswer == INFINITY) {
				endAnswer = (startAnswer+endAnswer)/2;
			} else {
				tempAnswer = helperDjikstra(eksklusif, startName, destName, (startAnswer+endAnswer) /2 +1);
				if(tempAnswer == INFINITY) {
					return (startAnswer+endAnswer)/2;
				}
				else {
					startAnswer = (startAnswer+endAnswer)/2+1;
				}				
			}
		}
		return -1;
	}
	
	
	public boolean dijkstraTanyaHubung(String startName, String destName) {
		PriorityQueue<Path> pq = new PriorityQueue<Path>( );
		
		Vertex start = vertexMap.get(startName);
		Vertex end = vertexMap.get(destName);
		
		if(start == null || end ==null) return false;
		
		clearAll();
		pq.add(new Path(start, 0)); 
		start.dist = 0;
		
		int nodesSeen = 0;
		while(!pq.isEmpty() && nodesSeen < vertexMap.size()) {
			Path vrec = pq.remove();
			Vertex v = vrec.dest;
			if(v.scratch != 0) // already processed v
				continue;
		
			v.scratch = 1;
			nodesSeen++;
		
			for(Edge e : v.adj) {
				Vertex w = e.dest;
				if(w.name.equalsIgnoreCase(destName)) {
					return true;
				}
				// Random weight
				int cvw = e.K;
				
				if( w.dist > v.dist + cvw) {
					w.dist = v.dist + cvw;
					pq.add( new Path( w, w.dist ) );
				}
			}
		}
		
		return false; // when the graph is not connected
	}
	
	public double dijkstraTanyaKupon(String startName, String destName) {
		PriorityQueue<Path> pq = new PriorityQueue<Path>( );
		
		Vertex start = vertexMap.get(startName);
		Vertex end = vertexMap.get(destName);
		
		if(start == null || end ==null) return -1;
		
		clearAll();
		pq.add(new Path(start, 0)); 
		start.dist = 0;
		
		int nodesSeen = 0;
		while(!pq.isEmpty() && nodesSeen < vertexMap.size()) {
			Path vrec = pq.remove();
			Vertex v = vrec.dest;
			if(v.scratch != 0) // already processed v
				continue;
		
			v.scratch = 1;
			nodesSeen++;
		
			for(Edge e : v.adj) {
				Vertex w = e.dest;
				
				int cvw = e.K;
				cvw = (int) (Math.log10(cvw) / Math.log10(basis));
				
				if( w.dist > v.dist + cvw) {
					w.dist = v.dist + cvw;
					pq.add(new Path( w, w.dist));
				}
			}
		}
		
		if(end.dist == INFINITY) return -1;
		
		double answer = 1;
		for(int i=1; i<= end.dist; i++) {
			answer = ( (answer % (Math.pow(10, 9) +7) ) * basis % (Math.pow(10, 9) +7) ) % (Math.pow(10, 9) +7);
		}
		
		
		return answer; 
	}
	
	private Vertex getVertex(String vertexName) {
		Vertex v = vertexMap.get(vertexName);
		if(v == null) {
			v = new Vertex(vertexName);
			vertexMap.put(vertexName, v);
		}
		return v;
	}

	private void clearAll() {
		for(Vertex v:vertexMap.values()) {
			v.reset();
		}
	}
}

class Vertex {
	String name;
	
	double dist;
	int scratch;
	
	List<Edge> adj;
	
	public Vertex(String name) {
		this.name=name;
		adj = new LinkedList<Edge>();
		reset();
	}
	
	public void reset() {
		dist = Integer.MAX_VALUE;
		scratch = 0;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
}

class Path implements Comparable<Path> {
	public Vertex dest; 
	public double cost; 
	
	public Path( Vertex d, double c ) { 
		dest = d;
		cost = c;
	}

	public int compareTo( Path rhs ) {
		double otherCost = rhs.cost;		
		return cost < otherCost ? -1 : cost > otherCost ? 1 : 0;
	}
}

class Edge {
	Vertex dest;
	
	int C;
	int K;
	int T;
	boolean eksklusif;
	
	public Edge(Vertex dest, int C, int K, int T, boolean eksklusif) {
		this.dest = dest;
		
		this.C = C;
		this.K = K;
		this.T = T;
		
		this.eksklusif = eksklusif;
	}
}