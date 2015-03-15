package Others;

public class BitManipulation
{
	public static int findPowOfTwo_Nearest(int x)
	{
		if(x==0) return 1;
		int a= Integer.parseInt("00000001", 2);
		while(a<x)
		{
			a=a<<2;
		}
		int b = a>>2;
		if(Math.abs(x-a)>Math.abs(x-b))
			return b;
		else
			return a;
	}
	public static void main(String[] args)
	{
		System.out.println(findPowOfTwo_Nearest(388));
	}
}