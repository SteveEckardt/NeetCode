/**
 * Problem: Sorting Benchmarks  
 * Author: Steve Eckardt  
 * Revision Date: July 8, 2025  
 *
 * Compares the execution time of different sorting algorithms on a list of random key-value pairs.
 *
 * Time Complexity:
 * - bubbleSort      => O(n²)
 * - selectionSort   => O(n²)
 * - mergeSort       => O(n log n)
 * - quickSort       => O(n log n) average, O(n²) worst case
 * - collectionsSort => O(n log n)
 *
 * Space Complexity:
 * - bubbleSort, selectionSort, quickSort => O(1) in-place
 * - mergeSort, collectionsSort => O(n)
 */

import java.util.*;
import java.io.*;

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
		//System.out.println("start: "+start+", end: "+end);
		Pair povit = list.get(end);
		int left = start;
		int right = end-1;
		
		while(left < right){
			while(left < right && povit.compareTo(list.get(left)) > 0) left++;
			while(left < right && povit.compareTo(list.get(right)) <= 0) right--;
			if(left < right){
				Pair temp = list.get(left);
				list.set(left++,list.get(right));
				list.set(right--,temp);
			}
		}
		if(povit.compareTo(list.get(left)) < 0){
			list.set(end,list.get(left));
			list.set(left--,povit);
		}
		
		//this.printKeys(list);
		//System.out.println("left: "+left+", right: "+right);
		list = quickSort(list, start, left);
		list = quickSort(list, right+1, end);
		
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




	public String[][] benchmarks(){
		String[][] benchmarks = new String[6][11];
		benchmarks[0][0] = "sortName";
		benchmarks[1][0] = "bubbleSort";
		benchmarks[2][0] = "selectionSort";
		benchmarks[3][0] = "mergeSort";
		benchmarks[4][0] = "quickSort";
		benchmarks[5][0] = "collectionsSort";	

		for(int i = 1; i < 11; i++){
			int n = i*2000;
			benchmarks[0][i] = Integer.toString(i*2)+'k';
			List<Pair> list = randomList(n);
			
			long start = System.nanoTime();
			bubbleSort(new ArrayList<>(list));
			long end = System.nanoTime();
			benchmarks[1][i] = timeToMilliseconds(end-start);
			
			start = System.nanoTime();
			selectionSort(new ArrayList<>(list));
			end = System.nanoTime();
			benchmarks[2][i] = timeToMilliseconds(end-start);

			start = System.nanoTime();
			mergeSort(new ArrayList<>(list));
			end = System.nanoTime();
			benchmarks[3][i] = timeToMilliseconds(end-start);

			start = System.nanoTime();
			quickSort(new ArrayList<>(list));
			end = System.nanoTime();
			benchmarks[4][i] = timeToMilliseconds(end-start);
			
			start = System.nanoTime();
			collectionsSort(new ArrayList<>(list));
			end = System.nanoTime();
			benchmarks[5][i] = timeToMilliseconds(end-start);			
		}
		return benchmarks;
	}// end benchmarks
	
	private String timeToMilliseconds(long time){
		double milliseconds = time / 1_000_000.0;
		return String.format("%.3f", milliseconds);
	}
	
	
	
	
	public void writeBenchmarksToCSV(String[][] benchmarks, String filename){
		if (!filename.toLowerCase().endsWith(".csv")) {
			filename += ".csv";
		}

		try(PrintWriter writer = new PrintWriter(new FileWriter(filename))){
			for(String row[] : benchmarks){
				for(int i = 0; i < row.length; i++){
					writer.print(row[i]);
					if(i < row.length-1) writer.print(",");
				}
				writer.println();
			}
		}catch(IOException e){
			System.err.println("Error: "+e.getMessage());
		}
	}// end writeBenchmarksToCSV
	
	
	
	
	public static void main(String[] args){
		SortRaces sortraces = new SortRaces();
		sortraces.writeBenchmarksToCSV(sortraces.benchmarks(),"benchmarks");
	}// end main
}// end class 