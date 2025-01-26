package rahul;

import java.util.*;
public class Test {

	public static void main(String[] args) 
	{
		
		
		Scanner s = new Scanner(System.in);
		StringBuffer rept = new StringBuffer();
		StringBuffer sb1 = new StringBuffer();
//		StringBuffer sb2 = new StringBuffer();
//		System.out.println("enter your first string");
//		String s1 = s.nextLine();
		String s1 = "rahul";
		StringBuilder stb1 = new StringBuilder(s1);
		int len1 = s1.length();
//		System.out.println("enter your second string");
//		String s2 = s.nextLine();
		String s2 = "kumar";
		StringBuffer stb2 = new StringBuffer(s2); 
		int len2 = s2.length();
		for(int i=0;len1>i;i++)
		{
			char ch1 = s1.charAt(i);
			String str1 = String.valueOf(ch1);
			for(int j=0;len2>j;j++)
			{
				char ch2 = s2.charAt(j);
				String str2 = String.valueOf(ch2);
				if(str1.equals(str2))
				{
					rept.append(str1);
				}
			}
		}
		System.out.println(rept);
		
		int len3 = rept.length();
		for(int i=0;len3>i;i++)
		{
			char ch9 = rept.charAt(i);
			String str9 = String.valueOf(ch9);
//			int len9 = stb1.length();
			for(int j=0;stb1.length()>j;j++)
			{
				char ch8 = stb1.charAt(j);
				String str8 = String.valueOf(ch8);
				if(str9.equals(str8))
				{
					stb1.deleteCharAt(j);
				}
			}
		}
		
		System.out.println(stb1+"*");
		s.close();
	}

}