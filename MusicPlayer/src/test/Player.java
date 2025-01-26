package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Player {
	
//	ArrayList<String> myList1 = new ArrayList<>(Arrays.asList("Headlights", "Alan Album", "Alan", "2:30"));
//	ArrayList<String> myList2 = new ArrayList<>(Arrays.asList(""));
//	ArrayList<ArrayList<String>> myNestedList = new ArrayList<>();
//	myNestedList.add(myList1);
//	myNestedList.add(myList2);
	
	ArrayList<String> myList1 = new ArrayList<>(Arrays.asList("Headlights", "Alan Album","Alan", "2:30"));
	ArrayList<String> myList2 = new ArrayList<>(Arrays.asList("Chandra", "chandra Album", "s Chn", "3:52"));
	ArrayList<String> myList3 = new ArrayList<>(Arrays.asList("Alone", "Alan Album", "Alan", "2:52"));
	static ArrayList<ArrayList<String>> songs = new ArrayList<>();
	
	Player()
	{
		 songs.add(myList1);
		 songs.add(myList2);
		 songs.add(myList3);
	}
	
	
	public static void play()
	{
		for(ArrayList<String> song : songs) {
			System.out.println(song);
		}
		
	}

}
