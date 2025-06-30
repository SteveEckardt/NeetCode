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
		
		for(int i = 0;i < length; i++){
			int candidateKey = pairs.get(i).key;
			int candidateIndex = i;
			for(int j = i+1; j < length; j++){
				if(pairs.get(j).key < candidateKey){
					candidateKey = pairs.get(j).key;
					candidateIndex = j;
				}
			}
			if(i != candidateIndex){
				Pair candidate = pairs.get(candidateIndex);
				Pair original = pairs.get(i);
				pairs.set(i,candidate);
				pairs.set(candidateIndex,original);
			}	
		}
		return result;
    }
}
