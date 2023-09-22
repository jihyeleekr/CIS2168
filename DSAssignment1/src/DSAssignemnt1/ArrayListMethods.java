package DSAssignemnt1;
import java.util.*;

public class ArrayListMethods {
	public static void main(String[] args) {
		//Integer List 
		List<Integer> myList = new ArrayList<Integer>();
		myList.add(1);
		myList.add(25);
		myList.add(2);
		myList.add(5);
		myList.add(25);
		
		// List for problem 4
		List<Integer> listInt = new ArrayList<Integer>();
		listInt.add(5);
		listInt.add(25);
		listInt.add(2);
		listInt.add(1);
		myList.add(25);
		
		//String List
		List<String> myLists = new ArrayList<String>();
		myLists.add("I");
		myLists.add("like");
		myLists.add("to");
		myLists.add("eat");
		myLists.add("eat");
		myLists.add("eat");
		myLists.add("apples");
		myLists.add("and");
		myLists.add("bananas");
		
		//Run methods in order
		System.out.println(unique(myList));
		System.out.println(multiples(myList, 5));
		System.out.println(allStringsOfSize(myLists, 3));
		System.out.println(isPermutation(myList,listInt ));
		System.out.println(tokenize("Hello, World!"));
		System.out.println(removeAll(myList, 25));
		
	}
	//Check whether all elements in the list are unique
	//Return true is all the items are unique. Return false otherwise.
	public static boolean unique(List<Integer> myList) {
		//Access to individual elements in the list
		for(int i = 0; i < myList.size()-1;i++) {
			int num = myList.get(i);
			// Get the next element
			for(int j = i +1; j < myList.size(); j++) {
				int num_2 = myList.get(j);
				//Compare two elements and determine whether they are the same or not
				if(num == num_2) {
					return false;
				}
			}
		}
		return true;
	}
	//Find the multiples of n inside of the given list.
	//Return the numbers in a list form
	public static List<Integer> multiples(List<Integer> myList, int n){
		List<Integer> newList = new ArrayList<Integer>();
		for(int i = 0; i < myList.size(); i++) {
			int num = myList.get(i);
			if (num % n == 0) {
				newList.add(num);
			}
		}
		return newList;
	}
	// All Strings of Size
	// Make a new list with the elements that have the same length as int n
	public static List<String> allStringsOfSize(List<String> myList, int n){
		List<String> newList = new ArrayList<String>();
		for(int i = 0; i < myList.size(); i++) {
			String word = myList.get(i);
			if (word.length() == n) {
				newList.add(word);
			}
		}
		return newList;
	}
	//Permutation
	//Check whether the two lists are the same
	public static boolean isPermutation(List<Integer> myList_1, List<Integer> myList_2) {
		for(int i = 0; i< myList_1.size(); i++) {
			int num  = myList_1.get(i);
			if(myList_2.contains(num) != true) {
				return false;
			}
		}
		return true;
		
	}
	//Tokenize
	// Split the string by space and add it to a new list
	public static List<String> tokenize(String s){
		List<String> newList = new ArrayList<String>();
		String[] splitS = s.split("\\s+");
		for(int i = 0; i < splitS.length; i++) {
			String word = splitS[i];
			newList.add(word);
		}
		return newList;
	}
	// Remove All
	// Remove int n from the list
	public static List<Integer> removeAll(List<Integer> myList, int n){
		for(int i = myList.size() - 1; i >= 0; i--) {
			if(myList.get(i) == n) {
				myList.remove(i);
			}
		}
		return myList;
	}
}
