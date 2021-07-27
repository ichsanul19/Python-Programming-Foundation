import java.io.*;
import java.util.*;

public class Lab3Template { 

    private static InputReader in = new InputReader(System.in);
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        Tree stockTree = new Tree();
        Tree distanceTree = new Tree();
        
        int Q = in.nextInt();
        
        for(int i=0; i<Q; i++) {
        	String query = in.next();
        	
        	if(query.equals("INSERT")) {
        		String T = in.next();
        		int S = in.nextInt();
        		int J = in.nextInt(); 
        		
        		stockTree.insert(T, S);
        		distanceTree.insert(T, J);

        	} else if(query.equals("STOK_MINIMAL")) {
        		int S = in.nextInt(); 
        		out.println(stockTree.countMinimal(S));
        		
        	} else if(query.equals("JARAK_MAKSIMAL")) {
        		int J = in.nextInt();
        		out.println(distanceTree.countMaximal(J));
        		
        	} else if(query.equals("TOKO_STOK")) {
        		int S = in.nextInt();
        		if(stockTree.exists(S)) {
        			out.println(true);
        		} else {
        			out.println(false);
        		}
        	} else if(query.equals("TOKO_JARAK")) {
        		int J = in.nextInt();
        		
        		
        		if(distanceTree.exists(J)) {
        			out.println(true);
        		} else {
        			out.println(false);
        		}
        	}
        	
        }
        
        //BTreePrinter.printNode(stockTree.root);
        //BTreePrinter.printNode(distanceTree.root);
        out.flush();
    }
    
    // taken from https://codeforces.com/submissions/Petr
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

class Tree {
    TreeNode root;   

    public void insert(String storeName, int value) {
        root = insertNode(root, storeName, value);
    }    

    private TreeNode insertNode(TreeNode node, String storeName, int value) {
        if (node == null) {
        	node = new TreeNode(storeName, value, null, null);
        }
        
        if(value < node.value) {
        	node.left = insertNode(node.left, storeName, value);
        } else if(value > node.value) {
        	node.right = insertNode(node.right, storeName, value);
        } else {
        	return node;
        }
        
        node.height = 1 + max(height(node.left), height(node.right));
        
        int balance = getBalance(node);
        
        // Left Left Case
        if (balance > 1 && value < node.left.value) 
            return rightRotate(node); 
  
        // Right Right Case 
        if (balance < -1 && value > node.right.value) 
            return leftRotate(node); 
  
        // Left Right Case 
        if (balance > 1 && value > node.left.value) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && value < node.right.value) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        }
        
        
        if(node.left != null) {
        	node.setLeftCount(node.left.getTotalCount());
        } else {
        	node.setLeftCount(0);
        }
        
        if(node.right != null) {
        	node.setRightCount(node.right.getTotalCount());
        } else {
        	node.setRightCount(0);
        }
        
        //System.out.println("ini " + node.value + " " + node.getLeftCount() + " " + node.getRightCount());

        return node;
    }

    private TreeNode rightRotate(TreeNode y) { 
        TreeNode x = y.left;
        TreeNode T2 = x.right;
        
        x.right = y;
        y.left = T2;
        
        y.setHeight(max(height(y.left), height(y.right)) +1);
        x.setHeight(max(height(x.left), height(x.right)) +1);
        
        if(T2 != null) 
        	y.setLeftCount(T2.getTotalCount());
        else 
        	y.setLeftCount(0);
        x.setRightCount(y.getTotalCount());

        return x;
    } 
  
    private TreeNode leftRotate(TreeNode x) { 
    	TreeNode y = x.right;
    	TreeNode T2 = y.left;
    	
    	y.left = x;
    	x.right = T2;
    	
    	x.setHeight(max(height(x.left), height(x.right)) +1);
    	y.setHeight(max(height(y.left), height(y.right)) +1);
    	
    	if(T2 != null)
    		x.setRightCount(T2.getTotalCount());
    	else 
    		x.setRightCount(0);
    	y.setLeftCount(x.getTotalCount());
    	
    	return y;
    }
    
    public TreeNode search(int value) {
    	return search(root, value);
    }
    
    private TreeNode search(TreeNode node, int value) {
    	if (node == null || node.value == value)
    		return node;
    	
    	if(value > node.value) 
    		return search(node.right, value);
    	else
    		return search(node.left, value);
    	
    }

    public boolean exists(int value) {
        return search(value) != null;
    } 

    public int countMinimal(int min) {
        return this.root.countMinimal(min);
    }

    public int countMaximal(int max) {
        return this.root.countMaximal(max);
    }

    // Utility function to get height of node
    private int height(TreeNode n) { 
        return n == null ? 0 : n.height;
    }
    
    // Utility function to get max between two values
    private int max(int a, int b) { 
        return (a > b) ? a : b; 
    } 

    // Utility function to get balance factor of node
    private int getBalance(TreeNode N) { 
        if (N == null) 
            return 0; 
  
        return height(N.left) - height(N.right); 
    }
}

class TreeNode {
    String storeName;
    int value;
    TreeNode left;
    TreeNode right;
    int leftCount;
    int rightCount;
    int height;
    
    public TreeNode(String storeName, int value, TreeNode left, TreeNode right){
        this.left = left;
        this.right = right;
        this.storeName = storeName;
        this.value = value;
        this.height = 1;
    }
    
    public int countMinimal(int min) {
    	if(this.value == min) {
    		return 1 + this.getRightCount();
    	}
		    	
    	if (this.value > min) {
    		if(this.left != null)
    			return 1 + this.getRightCount() + this.left.countMinimal(min);
    		return 1 + this.getRightCount();
    	} else {
    		if(this.right != null)
    			return this.right.countMinimal(min);
    		return 0;
    	} 
    }

    public int countMaximal(int max) {
    	if(this.value == max) {
    		return 1 + this.getLeftCount();
    	}
    	
    	if(this.value < max) {
    		if(this.right != null)
    			return 1 + this.getLeftCount() + this.right.countMaximal(max);
    		return 1 + this.getLeftCount();
    	} else {
    		if(this.left != null) 
    			return this.left.countMaximal(max);
    		return 0;
    	}
    }

    public int countMinimal2(int min) {
    	if(this.left != null)
    		leftCount = this.left.countMinimal(min);
    	
    	if(this.right != null)
    		rightCount = this.right.countMinimal(min);
    	
    	return (this.value >= min ? getTotalCount():getTotalCount()-1);
    }

    public int countMaximal2(int max) {
    	if(this.left != null)
    		leftCount = this.left.countMaximal(max);
    	
    	if(this.right != null)
    		rightCount = this.right.countMaximal(max);
    	
    	return (this.value <= max ? getTotalCount():getTotalCount()-1);
        
    }

    public int getTotalCount() {
        return this.leftCount + this.rightCount + 1;
    }

    public int getLeftCount() {
        return this.leftCount;
    }

    public int getRightCount() {
        return this.rightCount;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setLeftCount(int count) {
        this.leftCount = count;
    }

    public void setRightCount(int count) {
        this.rightCount = count;
    }
}



