package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> myList1 = new ArrayList<>(Arrays.asList("apple", "banana", "orange"));
		ArrayList<String> myList2 = new ArrayList<>(Arrays.asList("grape", "kiwi", "mango"));
		ArrayList<ArrayList<String>> myNestedList = new ArrayList<>();
		myNestedList.add(myList1);
		myNestedList.add(myList2);
		System.out.println("=> " + myNestedList);
		ArrayList<ArrayList<String>> myList = new ArrayList<>();
		//myList.add(myArray1);
		
		for(int i=0 ; i< myList.size(); i++)
		{
			System.out.println(myList.get(i));
		}


	}

}
