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
	private Node insert(Node current, int key, int value){
		if(current == null) {
			current = new Node(key,value);
			return current;
		}
		if(key == current.key ){
			current.value = value;
			return current;
		}
		if(key < current.key) current.left = insert(current.left,key,value); 
		if(key > current.key) current.left = insert(current.right,key,value); 
		return current;
	}

    public int get(int key) {
		return -1;
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
