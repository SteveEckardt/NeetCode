import java.util.*;

class SortRaces{
	
	public List<Pair> bubbleSort(List<Pair> list){
		for(int i = 0; i < list.size(); i++)
			for(int j = 1; j < list.size(); j++){
			
			if(list.get(j).compareTo(list.get(j-1)) < 0){
				Pair temp = list.get(j);
				list.set(j,list.get(j-1));
				list.set(j-1,temp);
			}
		}
		return list;
	}// end bubbleSort


	public List<Pair> selectionSort(List<Pair> list){
		for(int i = 0; i < list.size()-1; i++){
			int minIndex = i;
			for(int j = i; j < list.size(); j++){
				if(list.get(j).compareTo(list.get(minIndex)) < 0)
					minIndex = j;
			}
			if(minIndex != i){
				Pair temp = list.get(i);
				list.set(i,list.get(minIndex));
				list.set(minIndex,temp);				
			}
		}
		return list;
	}// end selectionSort


	public List<Pair> mergeSort(List<Pair> list){
		return mergeSort( list, 0, list.size()-1);
	}
	private List<Pair> mergeSort(List<Pair> list, int start, int end){
		if(end-start <= 0) return list;
		int middle = (end + start) / 2;
		
		mergeSort(list, start, middle);
		mergeSort(list, middle+1, end);
		mergeSort( list, start, middle, end);
		
		return list;
	}
	private List<Pair> mergeSort(List<Pair> list, int start, int middle, int end){
		final List<Pair> LEFT = new ArrayList<>(list.subList(start,middle+1));
		final List<Pair> RIGHT = new ArrayList<>(list.subList(middle+1,end+1));
		int rIndex = 0;
		int lIndex = 0;
		int listIndex = start;
		
		while( lIndex < LEFT.size() && rIndex < RIGHT.size()){
			if(LEFT.get(lIndex).compareTo(RIGHT.get(rIndex))< 0)
				list.set(listIndex++,LEFT.get(lIndex++));
			else
				list.set(listIndex++,RIGHT.get(rIndex++));				
		}
		while( lIndex < LEFT.size())
			list.set(listIndex++,LEFT.get(lIndex++));
		while( rIndex < RIGHT.size())
			list.set(listIndex++,RIGHT.get(rIndex++));
		return list;
	}// end mergeSort


    public List<Pair> quickSort(List<Pair> list) {
        return quickSort(list, 0, list.size() - 1);
    }
    private List<Pair> quickSort(List<Pair> list, int start, int end) {
		if(start >= end) return list;
		Pair pivot = list.get(end);
		int left = start;
		int right = end;
		
		while(left < right){
			while(left < right && list.get(left).compareTo(pivot) < 0) left++;
			while(left < right && list.get(right).compareTo(pivot) >= 0) right--;
			
			if(left < right ){
				Pair temp = list.get(left);
				list.set(left++,list.get(right));
				list.set(right--,temp);
			}
		}
		list.set(end,list.get(left));
		list.set(left,pivot);
		quickSort(list, start, --left);
		quickSort(list, ++right, end);
		
        return list;
    }// end quickSort	



    public List<Pair> collectionsSort(List<Pair> list) {
		Collections.sort(list);
        return list;
    }// end collectionsSort



    public void printKeys(List<Pair> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).key);
			if(i != list.size()-1)
				System.out.print(", ");
        }
		System.out.println();
    }

	public void printPairList(List<Pair> list){
		for(int i = 0; i < list.size(); i++){
			System.out.print(list.get(i).toString());
		}
		System.out.println();
	}
	
	
	public List<Pair> randomList(int size){
		List<Pair> result = new ArrayList<>(size);
		for(int i = 0; i < size; i++){
			Random random = new Random();
			int key = random.nextInt(10001);
			StringBuilder value = new StringBuilder();
			for(int j = 0; j < 5; j++) 
				value.append((char)('!' + random.nextInt(93)));
			result.add(new Pair(key,value.toString()));
		}
		return result;
	}// end randomList	
	
	
	public static void main(String[] args){
		SortRaces sortraces = new SortRaces();
		List<Pair> list = sortraces.randomList(10);
		sortraces.printKeys(list);
		//sortraces.printKeys(sortraces.quickSort(new ArrayList<>(list)));
		
		sortraces.printKeys(list);
	}// end main
}// end class 