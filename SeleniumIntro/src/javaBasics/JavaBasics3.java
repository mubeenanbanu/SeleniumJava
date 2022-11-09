package javaBasics;

public class JavaBasics3 {
	public static void main(String[] args) {
	
			String s="mubeena banu";
			String s1="mubeena banu";
			
			String s2=new String ("mubeena is learning java basics");
			for(int i=0;i<s2.length();i++)
			{
				System.out.println(s2.charAt(i));
			}
			String s3=new String ("mubeena1");
			
			System.out.println(s3);
			String[] strarray=s2.split("learning");
			System.out.println(strarray[1].trim());
			
			for(String a:strarray)
			{
				System.out.println(a);
			}
			
			
			JavaBasics3 j=new JavaBasics3();
			j.Method1();
			
	}
	public static  void Method1()
	{
		System.out.println("mubeena method 1");
	}

}
