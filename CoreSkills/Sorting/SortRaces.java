import java.util.*;

class SortRaces{
	
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

	public void main(String[] args){
		
	}// end main
}// end class 