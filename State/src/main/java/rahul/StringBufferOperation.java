package rahul;

public class StringBufferOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb1 = new StringBuffer();
		sb1.append("rahul");
		StringBuffer sb2 = new StringBuffer();
		sb2.append("kumar");
		
		StringBuffer sb3 = new StringBuffer();
		//find common from sb1 and sb2
		for(int i=0; i<sb1.length(); i++)
		{
			for(int j=0; j<sb2.length(); j++)
			{
				if(sb1.charAt(i) == sb2.charAt(j))
				{
					sb3.append(sb1.charAt(i));
				}
			}
		}
		System.out.println(sb1);
		System.out.println(sb2);
		System.out.println(sb3);
		
		//remove sb3 from sb1
		for(int i=0; i<sb1.length(); i++)
		{
			for(int j=0; j<sb3.length(); j++)
			{
				if(sb1.charAt(i) == sb3.charAt(j))
				{
					sb1.deleteCharAt(i);
				}
			}
		}
		System.out.println(sb1);
	}

}
