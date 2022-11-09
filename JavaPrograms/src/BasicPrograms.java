

public class BasicPrograms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseString();
		DuplicateCharacters();

	}
	public static void ReverseString()
	{
		String name="mubeena";
		String rev="";
		char[] ch=name.toCharArray();
		for(int i=ch.length-1;i>=0;i--)
		{
			rev+=ch[i];
			
		}
		System.out.println(rev);
	}
	public static void DuplicateCharacters()
	{
		 String str = "jabeenaa";
		char[] ch=str.toCharArray();
		for(int i=0;i<str.length();i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(ch[i]==ch[j])
				{
					System.out.println(ch[j]);
				}
				break;
			}
				
		}
	}
	

}
