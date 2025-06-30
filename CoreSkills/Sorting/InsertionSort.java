// Definition for a pair
// class Pair {
//     int key;
//     String value;
//
//     Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
public class Solution {
    public List<List<Pair>> insertionSort(List<Pair> pairs) {
		List<List<Pair>> result = new ArrayList<>();
		int length = pairs.size();
		if(length == 0) return result;
		result.add(new ArrayList<>(pairs));
		
		for(int i = 1; i < length; i++){
			int j = i-1;
			int key = pairs.get(i).key;
			
			while(j >= 0 && pairs.get(j).key > pairs.get(j+1).key){
				Pair temp = pairs.get(j);
				pairs.set(j,pairs.get(j+1));
				pairs.set(j+1,temp);
				j--;
			}
		result.add(new ArrayList<>(pairs));
		}
		return result;
    }
}
