package AmazonQuestion;

import java.util.*;
public class AmazonQ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str= "aabbccddeeffgghhiijjopqrstuvwxyzabcdklmn"; // 66 times
//		String str = "abacadefghibj"; //14 times
		String str = "abcghdiefjoba"; // 15 times
		Set<String> s1 = new HashSet<String>();
		Set<String> s2 = new HashSet<String>();
		Set<String> s3 = new HashSet<String>();
		int pressBtns = 0;
		
		for(int i=0; i<str.length(); i++)
		{
			if(s1.size()<9)
			{
				s1.add(String.valueOf(str.charAt(i)));
			}
			else
			{
				if(s2.size()<9 && !s1.contains(String.valueOf(str.charAt(i))))
				{
					s2.add(String.valueOf(str.charAt(i)));
				}
				else
				{
					if(!s1.contains(String.valueOf(str.charAt(i))) && !s2.contains(String.valueOf(str.charAt(i))))
					{
						s3.add(String.valueOf(str.charAt(i)));
					}
				}
			}
		}
		
		System.out.println(s1 +" "+ s2 +" "+ s3);
		for(int j=0; j<str.length(); j++)
		{
			if(s1.contains(String.valueOf(str.charAt(j))))
			{
				pressBtns ++;
			}
			else {
				if(s2.contains(String.valueOf(str.charAt(j))))
				{
					pressBtns += 2;
				}
				else
				{
					pressBtns += 3;
				}
			}
		}
		
		System.out.println(pressBtns);
	}

}
