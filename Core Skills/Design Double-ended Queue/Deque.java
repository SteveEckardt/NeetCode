class Deque {
	class Node{
		Node left;
		Node right;
		int value;
		
		public Node(int value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}

	Node leftEnd;
	Node rightEnd;
	int size;


    public Deque() {
		this.leftEnd = null;
		this.rightEnd = null;
		this.size = 0;
    }

    public boolean isEmpty() {
		return this.size==0?true:false;
    }

    public void append(int value) {
		Node current = new Node(value);
		if(this.rightEnd==null){
			this.rightEnd = current;
			this.leftEnd = current;
		}else{
			this.rightEnd.right = current;
			current.left = this.rightEnd;
			this.rightEnd = current;
		}
       this.size++;
    }

    public void appendleft(int value) {
		Node current = new Node(value);
		if(this.leftEnd==null){
			this.rightEnd = current;
			this.leftEnd = current;
		}else{
			this.leftEnd.left = current;
			current.right = this.leftEnd;
			this.leftEnd = current;
		}
       this.size++;        
    }

    public int pop() {
        if(isEmpty()) return -1;
		int result = this.rightEnd.value;
		
		if(this.size==1){
			this.rightEnd = null;
			this.leftEnd = null;
		}else{
			this.rightEnd = this.rightEnd.left;
			this.rightEnd.right = null;
		}
		
		this.size--;
		return result;
    }

    public int popleft() {
        if(isEmpty()) return -1;
		int result = this.leftEnd.value;
		
		if(this.size==1){
			this.rightEnd = null;
			this.leftEnd = null;
		}else{
			this.leftEnd = this.leftEnd.right;
			this.leftEnd.left = null;
		}
		
		this.size--;
		return result;
    }
}
