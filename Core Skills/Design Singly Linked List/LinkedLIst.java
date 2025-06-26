class LinkedList {
	private Node head;
	private Node tail;
	private int size;

	class Node{
		Node next;
		int val;
		
		public Node(int val){
			this.val = val;
			this.next = null;
		}
	}
	
    public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
		
    }

    public int get(int index) {
		if(index >= size || index < 0) 
			return -1;

		Node current = head;
		for(int i = 0; i < index; i++) 
			current = current.next;
		if(current == null) return -2;
		return current.val;
    }

    public void insertHead(int val) {
        Node current = new Node(val);
		current.next = this.head;
		this.head = current;
		if(this.size == 0) this.tail = current;
		size++;
    }

    public void insertTail(int val) {
        Node current = new Node(val);

		if(this.size == 0){
			this.tail = current;
			this.head = current;
		}else{
			this.tail.next = current;
			this.tail = current;
		}
		size++;
    }

    public boolean remove(int index) {
        if(index >= this.size || index < 0 ) return false;
		if(index == 0){
			this.size--;
			if(this.size == 0){
				this.tail = null;
				this.head = null;
			}else{
				this.head = this.head.next;
			}
			return true;
		}
		
		Node previous = head;
		for(int i = 0; i < index-1; i++) previous = previous.next;
		previous.next = previous.next.next;
		if(index == this.size-1) this.tail = previous;
		this.size--;
		return true;
    }

    public ArrayList<Integer> getValues() {
		ArrayList<Integer> list = new ArrayList<>();
		Node current = this.head;
		while(current != null){
			list.add(current.val);
			current = current.next;
		}
		return list;
    }
}
