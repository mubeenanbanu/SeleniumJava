package javaBasics;

public class Loops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=10;
		while(i>5)
		{
			System.out.println(i);
			i--;
		}
		System.out.println("-------");
		int j=10;
		do
		{
			System.out.println(j);
			j--;
		}while(j>5);
		
		System.out.println("----------------");
		
		char k='*';
		for(int i1=0;i1<4;i1++)
		{
			//System.out.println("outer loop stared");
			for(int j1=0;j1<4-i1;j1++)
			{
				System.out.print(k +" ");
				//k++;
				
			}
			System.out.println();
			//System.out.println("outer loop finished");
		}
		
		System.out.println("------------------");
		
		int k1=1;
		for(int i1=0;i1<=4;i1++)
		{
			//System.out.println("outer loop stared");
			for(int j1=0;j1<i1;j1++)
			{
				System.out.print(k1 +" ");
				k1++;
				
			}
			System.out.println();
			//System.out.println("outer loop finished");
		}
		
		System.out.println("----------");
		
		
		for(int i1=1;i1<=4;i1++)
		{
			
			for(int j1=1;j1<=i1;j1++)
			{
				System.out.print( j1+" ");
				
				
			}
			System.out.println();
			
		}
		System.out.println("--------");
		
		int m=3;
		for(int i1=1;i1<=4;i1++)
		{
			
			for(int j1=1;j1<i1;j1++)
			{
				System.out.print( m+" ");
				m+=3;
				
				
			}
			System.out.println();
			
		}

	}

}
