package javaBasics;

public class TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  int b=7; int c=1; 
		  try {     
			  int k=b/c;
		  int arr[]=new int[5];// 
		  
		  System.out.println(arr[2]);
		  
		  } 
		 
		  catch(ArithmeticException et) 
		  { System.out.println("I catched the Arthimetic/exception"); } 
		  catch(IndexOutOfBoundsException ets)
		  { System.out.println("I catched the IndexBound/exception"); }
		  catch(Exception e)
		  { 
			  System.out.println("I catched the error/exception"); 
		  }
		 
			  finally { System.out.println("delete cookies");//THis block is executed irrespective of exception thrown or not } // TODO Auto-generated method stub //one try can be followed by mutiplle catch blocks //catch should be an immediate block after try

	}

	

	}

}
