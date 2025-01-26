package test;
import java.util.*;

public class Epam 
{
	public static void main(String[] args) 
	{
		//write your code here
		Scanner s = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<Integer>();
		int count1=0;
		System.out.println("Enter n:");
		int n = s.nextInt();
		while(n>0)
		{
			//System.out.println("Enter "+n+"th value:");
			int num = s.nextInt();
			while(num>0)
			{
				String str = Integer.toBinaryString(num);
				for(int a=0; a<str.length(); a++)
				{
					if(str.charAt(a)=='1')
					{
						count1++;
					}
					if(count1==1)
					{
						al.add(num);
					}
				}
				num--;
			}
			n--;
		}
		System.out.println("data");
		for(int i=0; i<al.size(); i++)
		{
			System.out.println(al.get(i));
		}
	}
}
