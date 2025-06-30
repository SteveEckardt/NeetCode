class MinHeap {
	List<Integer> heap;

    public MinHeap() {
		heap = new ArrayList<>();
		heap.add(0);
    }

    public void push(int val) {
		heap.add(val);
		int index = heap.size()-1;
		while(index > 1 && heap.get(index)<heap.get(index/2)){
			Integer temp = heap.get(index);
			heap.set(index,heap.get(index/2));
			index /= 2;
			heap.set(index,temp);
		}
    }

    public Integer pop() {
		int size = heap.size();
        if (size<2) return -1;
		if (size==2) return heap.remove(1);
		
		Integer result = heap.get(1);
		heap.set(1,heap.remove(--size));
		int value = heap.get(1);
		int index = 1;
		size--;
		
		while(true){
			int left = Integer.MAX_VALUE;
			int right = Integer.MAX_VALUE;
			if(index*2<=size && heap.get(index*2) < value) 
				left = heap.get(index*2);
			if(index*2+1<=size && heap.get(index*2+1) < value) 
				right = heap.get(index*2+1);
			
			if(left < right && left < value){
				heap.set(index,left);
				heap.set(index*2,value);
				index *=2;
			}else if(right < value){
				heap.set(index,right);
				heap.set(index*2+1,value);
				index = index*2+1;				
			}else break;
		}
		return result;
    }

    public Integer top() {
		if(heap.size()>1) return heap.get(1);
		return -1;
    }

    public void heapify(List<Integer> nums) {
		heap = new ArrayList<>();
		heap.add(0);
		for(Integer i: nums) push(i);
    }
}
