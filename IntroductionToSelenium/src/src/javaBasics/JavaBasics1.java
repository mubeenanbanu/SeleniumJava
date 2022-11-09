package javaBasics;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class JavaBasics1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myNum=10;
		boolean b=true;
		double d=100;
		float f=90.00f;
		String s="mubeena";
		char c='M';
		System.out.println(c +" is the value stored in the mynum variable");
		int [] arr=new int[3];
		
		arr[0]=0;
		arr[1]=2;
		arr[2]=4;
		
		int[] arr1= {3,4,9,8,10,7,6};	
		System.out.println(arr1[3]);
		System.out.println("--------");
		
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println(arr1[i]);
		}
		
		String[] names= {"mahin","mubina","hyder"};
		for(int i=0;i<names.length;i++)
		{
			System.out.println(names[i]);
		}
		for(String s1 : names)
		{
			System.out.println(s1);
		}
		String name="mubeena";
		String rev="";
		char[] ch=name.toCharArray();
		for(int i=ch.length-1;i>=0;i--)
		{
			rev+=ch[i];
			
		}

	}

}
