class DynamicArray {
	private int[] data;
	private int size;
	private int capacity;

    public DynamicArray(int capacity) {
		this.data = new int[capacity];
		this.size = 0;
		this.capacity = capacity;
    }

    public int get(int i) {
		return this.data[i];
    }

    public void set(int i, int n) {
		this.data[i] = n;
    }

    public void pushback(int n) {
        if(size == capacity) resize();
		this.data[size++] = n;
    }

    public int popback() {
		return this.data[--size];
    }

    private void resize() {
        int[] newArray = new int[this.capacity*2];
        for(int i = 0; i < this.capacity; i++) newArray[i] = this.data[i];
		this.data = newArray;
		capacity *= 2;
    }

    public int getSize() {
		return this.size;
    }

    public int getCapacity() {
		return this.capacity;
    }
}
