package javaBasics;

import java.util.ArrayList;

public class JavaBasics2 {
	public static void main(String[] args) {
	
		int[] arr= {1,2,3,4,5,6,7,8,9};
		for (int i=0;i<arr.length;i++)
		{
			if(arr[i]%2==0)
			{
				System.out.println(arr[i]);
				continue;
			}
			else
			{
				System.out.println(arr[i]+" is not a multiple of 2");
			}
			
			
		}
		
		System.out.println("-------------");
		ArrayList<String> arraylist=new ArrayList<String>();
		arraylist.add("mubina");
		arraylist.add(1, "banu");
		arraylist.remove(0);
		
		arraylist.clear();
	
		arraylist.add("sanobar");
		arraylist.get(0);
		for(String a:arraylist)
		{
			System.out.println(a);
		}
		
	}
}
