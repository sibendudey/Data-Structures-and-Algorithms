package stacks;

import java.util.Stack;

public class Evaluation {


	static Stack<Character> ops = new Stack<Character>();
	static Stack<Integer> numbers = new Stack<Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "19+12/4-((4-7)*3/1)";
		char[] tokens = expression.toCharArray();
		
		for ( int i = 0 ; i < tokens.length ; i++){
			
			if ( tokens[i] >= '0'  && tokens[i] <='9')	{
				StringBuffer number = new StringBuffer();
				while ( i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')	{
					number.append(tokens[i++]);	
				}
				System.out.println("Number added:" + number);
				i--;
				numbers.push(Integer.decode(number.toString()));
			}
			
			else if (tokens[i] == '(')
				ops.push(tokens[i]);
			
			else if (tokens[i] == ')')	{
				while ( ops.peek() != '(' )	{
					numbers.push(performOp(ops.pop() , numbers.pop() , numbers.pop()));
					System.out.println("Number added:" + numbers.peek());
				}
				ops.pop();
			}
			
			else if ( tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') 	{
				while (!ops.isEmpty() && hasPrecedence( tokens[i] , ops.peek()))	{
					numbers.push(performOp(ops.pop() , numbers.pop() , numbers.pop()));
					System.out.println("Number added:" + numbers.peek());
				}
				
				ops.push(tokens[i]);
				System.out.println("Operator added" + ops.peek());
			}
				
		}
		
		while (!ops.isEmpty()){
			numbers.push(performOp(ops.pop() , numbers.pop() , numbers.pop()));
		}
		
		System.out.println("Result of expression:" + numbers.pop());
	}

	private static boolean hasPrecedence(char c, Character peek) {
		// TODO Auto-generated method stub
		if ( peek == '(' || peek == ')')
			return false;
		
		else if ( (c == '*' || c== '/' ) && (peek == '+' || peek == '-') )
			return false;
		return true;
	}

	private static int performOp(char pop, Integer num1, Integer num2) {
		// TODO Auto-generated method stub
		if ( pop == '+')	{
			Integer value = num1 + num2;
			return value;
		}
		
		else if ( pop == '-')	{
			Integer value = num2 - num1;
			return value;
		}
		
		else if ( pop == '*')	{
			Integer value = num1 * num2;
			return value;
		}
		
		else {
			System.out.println(num2 + " " + num1);
			Integer value = num2 / num1;
			return value;
		}
		
		
		
	}

}
