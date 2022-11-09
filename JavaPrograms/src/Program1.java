import java.util.HashMap;

public class Program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseNumber();
		LargestOfThreeNumbers();
		Frequencywords();
	}
	public static void ReverseNumber()
	{
		int n=987;
		int rem=0,sum=0;
		while(n>0)
			
		{
			rem=n%10;
			sum=sum*10+rem;
			n=n/10;
		}
		System.out.println(sum);
	}
	public static void LargestOfThreeNumbers()
	{
		int a=66,b=8,c=4;
		if(a>b && a>c)
		{
			System.out.println("a is largest");
			
		}
		else if(b>c)
		{
			System.out.println("b is largest");
			
		}
		else
		{
			System.out.println("c is largest");
		}
	}
	public static void Frequencywords()
	{
		String str="aavghvgah";
		char[] ch=str.toCharArray();
		HashMap<Character,Integer> hp=new HashMap<>();
		for(int i=0;i<ch.length;i++)
		{
			
			if(hp.containsKey(ch[i]))
			{
				int count=hp.get(ch[i]);
				hp.put(ch[i], count+1);
			}
			else
			{
				hp.put(ch[i], 1);
			}
			
		}
		System.out.println(hp);
		
		
	}
			
	

}
