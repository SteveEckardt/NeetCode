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
		if(key > node.key) node.left = insert(node.right,key,value); 
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
		return -1;
    }

    public int getMax() {
		return -1;
    }

    public void remove(int key) {
       
    }

    public List<Integer> getInorderKeys() {
		return new ArrayList<>();
    }
}
