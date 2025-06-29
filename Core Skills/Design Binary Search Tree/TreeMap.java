//import java.util.ArrayList;
//import java.util.List;

class TreeMap {
	class Node{
		int key;
		int value;
		Node left;
		Node right;
		
		Node(int key, int value){
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	Node root;
	
    public TreeMap() {
		root = null;
    }

    public void insert(int key, int value) {
		root = insert(root,key,value);
    }
	private Node insert(Node node, int key, int value){
		if(node == null) {
			node = new Node(key,value);
			return node;
		}
		if(key == node.key ){
			node.value = value;
			return node;
		}
		if(key < node.key) node.left = insert(node.left,key,value); 
		if(key > node.key) node.right = insert(node.right,key,value); 
		return node;
	}

    public int get(int key) {
		return get(root,key);
    }
	private int get(Node node, int key){
		if(node == null) return -1;
		if(node.key == key) return node.value;
		if(node.key > key) return get(node.left,key);
		return get(node.right,key);
	}

    public int getMin() {
		if(root == null) return -1;
		Node node = root;
		while(node.left != null) node = node.left;
		return node.value;
    }

	private Node getMinNode(Node node){
		if(node == null) return node;
		while(node.left != null) node = node.left;
		return node;		
	}
	

    public int getMax() {
		if(root == null) return -1;
		Node node = root;
		while(node.right != null) node = node.right;
		return node.value;
    }

    public void remove(int key) {
       root = remove(root,key);
    }
    private Node remove(Node node, int key) {
       if(node == null) return node;
	   if(key < node.key) node.left = remove(node.left,key);
	   else if(key > node.key) node.right = remove(node.right,key);
	   else{
			if(node.left == null) return node.right;
			if(node.right == null) return node.left;

			Node replace = getMinNode(node.right);
			node.key = replace.key;
			node.value = replace.value;
			node.right = remove(node.right,replace.key);
	   }
	   return node;
    }	

    public List<Integer> getInorderKeys() {
		List<Integer> list = new ArrayList<>();
		getInorderKeys( list, root);
		return list;
    }
	private void getInorderKeys(List<Integer> list, Node node){
		if(node == null) return;
		getInorderKeys(list, node.left);
		list.add(node.key);
		getInorderKeys(list, node.right);
	}
}
