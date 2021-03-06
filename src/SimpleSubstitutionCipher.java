import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SimpleSubstitutionCipher 
{
	public static String characterFrequency(String s)
	{	 
		s = s.toUpperCase();// Change the input string to upper case to maintain consistency
		char ch;
		String compress = "";
		HashMap<Character, Integer> h = new HashMap<Character, Integer>(); //Maps the characters to the character count

		for(int i=0;i<s.length();i++)
		{
			ch = s.charAt(i);
			if(h.containsKey(ch))
			{
				h.put(ch,h.get(ch)+1);
			}
			else
			{
				h.put(ch, 1);
			}
		}

		for(Map.Entry<Character, Integer> entry : h.entrySet())
		{
			char key = entry.getKey();
			int val = entry.getValue();
			compress = compress + key + ' ' + val + '\n';
		}
		return compress;
	}
	
	public static String key(String s, int key)
	{
		s = s.toUpperCase();// Change the input string to upper case to maintain consistency
		char ch;
		String r = "";
		for(int i=0;i<s.length();i++)
		{
			ch = s.charAt(i);
			int a = 55 + Character.getNumericValue(ch); //converting the characters of the cipher text to ASCII
			a -= key;
			if(a < 64)
			{
				a = 90 - 64 % a;
			}
			r += Character.toString((char) a);
		}
		return r;
	}
		
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the cipher text: "); //The encrypted text to be entered by the user
		String s = in.nextLine();
		String result1 = "";
		String result2 ="";
		result1 = characterFrequency(s);
		System.out.println("The frequency of the characters is: ");
		System.out.println(result1);
		System.out.print("Enter a putative key to decrypt the cipher text: "); // A key that is guessed by the user
		int a = in.nextInt();
		result2 = key(s,a);
		System.out.println("The decrypted text could be: ");
		System.out.println(result2);	
	}
}