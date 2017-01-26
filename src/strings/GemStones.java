package strings;

import java.io.IOException;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class GemStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Scanner in = new Scanner(System.in);
		int noOfWord = in.nextInt();
		in.nextLine();
		String words[] = new String[noOfWord];
		for ( int i = 0 ; i < noOfWord ; i++)	{
			words[i] = in.nextLine();
		}
		printGemStone(words);
		in.close();
		
		DocumentBuilder builder = new DocumentBuilder() {
			
			@Override
			public void setErrorHandler(ErrorHandler eh) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setEntityResolver(EntityResolver er) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public Document parse(InputSource is) throws SAXException, IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Document newDocument() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public boolean isValidating() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isNamespaceAware() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public DOMImplementation getDOMImplementation() {
				// TODO Auto-generated method stub
				return null;
			}
		};
	}

	private static void printGemStone(String[] words) {
		// TODO Auto-generated method stub
		int count[] = new int[26];
		for ( int i = 0 ; i < words.length ; i++){
			boolean track[] = new boolean[26];
			for ( char a : words[i].toCharArray())	{
				//int temp = count[a - 'a'];
				if ( track [a - 'a'] == false)	{
					++count[a - 'a'];
					track[a - 'a'] = true;
				}
			}
		}
		
		int result = 0;
		for ( int i = 0 ; i < 26 ; i++)	{
			if (count[i] == words.length)
				result++;
		}
		
		System.out.println(result);
	}

}
