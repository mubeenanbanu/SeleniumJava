package test;

public class Class1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveSpaces();
	}
	
	public static void RemoveSpaces()
	{
		String str="mubeena is a engineer";
		String[] st=str.split(" ");
		String newstring="";
		for(int i=0;i<st.length;i++)
		{
			newstring+=st[i];
		}
		System.out.println(newstring);
		
	}


}
