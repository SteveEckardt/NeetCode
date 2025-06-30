// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
		return mergeSort(pairs, 0, pairs.size()-1) ;
    }
    public List<Pair> mergeSort(List<Pair> pairs, int start, int end) {
		if(end-start <= 0) return pairs;
		
		int middle = (start+end)/2;
		mergeSort(pairs, start, middle);
		mergeSort(pairs, middle+1, end);
		
		mergeSort( pairs, start, middle, end);
		
		return pairs;
    }	
    public void mergeSort(List<Pair> pairs, int start, int middle, int end){
		final List<Pair> LEFT = new ArrayList<>(pairs.subList(start,middle+1));
		final List<Pair> RIGHT = new ArrayList<>(pairs.subList(middle+1,end+1));
		
		int LIndex = 0;
		int RIndex = 0;
		int pIndex = start;
		
		while(LIndex < LEFT.size() && RIndex < RIGHT.size()){
			if(RIGHT.get(RIndex).key < LEFT.get(LIndex).key)
				pairs.set(pIndex++,RIGHT.get(RIndex++));
			else
				pairs.set(pIndex++,LEFT.get(LIndex++));
		}
		while(LIndex < LEFT.size())
			pairs.set(pIndex++,LEFT.get(LIndex++));
		while(RIndex < RIGHT.size())
			pairs.set(pIndex++,RIGHT.get(RIndex++));
	}
}
