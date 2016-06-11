
public class BSTDepth {
	Node head;
	int lh,rh;
	public static void main(String[] args) {
		
		BSTDepth bSTDepth = new BSTDepth();
		Node root = new Node(12);
	
		root.ln = new Node(9);
		root.rn = new Node(13);
		root.ln.ln = new Node(8);
		root.ln.rn=new Node(10);
		root.rn.ln=new Node(11);
		root.rn.rn = new Node(14);
		System.out.println(bSTDepth.getHeight(root));
		
		
	}
	
	public int getHeight(Node node){
		if(node==null){
			return -1;
		}else{
			lh = getHeight(node.ln);
			rh = getHeight(node.rn);
		}
		return Math.max(lh, rh)+1;
	}
	
	public int getMinHeight(Node node){
		if(node==null){
			return 0;
		}
		
		if(node.ln==null && node.rn==null){
			return 1;
		}
		
		int ld = node.ln!=null?getMinHeight(node.ln):Integer.MAX_VALUE;
		int rd = node.rn!=null?getMinHeight(node.rn):Integer.MAX_VALUE;
		
		return 1+ Math.min(ld, rd);
	}
	

}

/*class Node{
	int data;
	Node ln;
	Node rn;
	Node(int data){
		this.data = data;
	}
}*/
