package module6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SearchBinaryMain {

	public static void main(String[] args){
		
		int[] array = {1, 10, 200, 300, 500};
		Integer[] array2 = {1, 10, 200, 300, 500};
		
		// using methods refference and Java 8 to initialize el array
		// List<Integer> collect = IntStream.range(1, 6).mapToObj(Integer::new).collect(Collectors.toList());
		// IntStream.range(1, 6).mapToObj(Integer::new).collect(Collectors.toList()).forEach(System.out::println);
		Integer[] array3 = IntStream.range(1, 6).mapToObj(Integer::new).collect(Collectors.toList()).stream().toArray(Integer[]::new);
		
		
//		System.out.println("Binary Search secuential: " + binarySearchSequencial(array, 10));
//		System.out.println("Binary Search recursive: " + binarySearchRecursive(array2, 10));
		System.out.println("Binary Search recursive: " + binarySearchRecursive(array3, 2));
		
	}
	
	private static int binarySearchSequencial(int[] array, int valorBuscado){
		
		int low = 0;
		int high = array.length - 1;
		
		while (low <= high){
			
			int mid = low + (high-low)/2;
			
			if(valorBuscado == array[mid]){
				return mid;
			}else if(valorBuscado < array[mid]){
				high = mid-1;
			}else{
				low=mid+1;
			}
		}
		
		return -1;
	}
	
	private static int binarySearchRecursive(Integer[] array, Integer valorBuscado){
		
		Integer low = 0;
		Integer high = array.length-1;
		
		return  binarySearchRecursive(array, valorBuscado, low, high);
	}
	
	private static int binarySearchRecursive(Integer[] array, Integer valorBuscado, Integer low, Integer high){
		
		if(low > high)
			return -1;
		
		int mid = low + (high-low)/2;
		
		if(valorBuscado.intValue() == array[mid].intValue()){
			return mid;
		}else if(valorBuscado.intValue() < array[mid].intValue()){
			return binarySearchRecursive(array, valorBuscado, low, mid-1);
		}else{
			return binarySearchRecursive(array, valorBuscado, low+1, high);
		}
	}
	
}
