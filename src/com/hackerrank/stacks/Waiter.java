package com.hackerrank.stacks;

import java.math.BigInteger;
import java.util.*;

class StackWrapper {
	Stack<Integer> stackA = new Stack<>();
	List<Stack<Integer>> stackListB = new ArrayList<>();

	int Q;

	StackWrapper(int Q) {
		this.Q = Q;
		createStackList();
	}

	public void createStackList() {
		for (int i = 0; i < Q; i++) {
			Stack<Integer> stackB = new Stack<>();
			stackListB.add(stackB);
		}
	}

	public Stack<Integer> getStackA() {
		return stackA;
	}
	
	public void setStackA( Stack<Integer> stack)	{
		this.stackA = stack;
	}

	public List<Stack<Integer>> getStackListB() {
		return stackListB;
	}

	public void performStackOperation(PrimeNumberWrapper primeNumberWrapper) {

		for (int i = 1; i <= Q; i++) {
			if ( stackA.size() == 0)
				return;
			
			Stack<Integer> nextStackA = new Stack<>();
			for ( int j = stackA.size() ; j > 0 ; j-- )	{
				int top = stackA.pop();
				if ( top % primeNumberWrapper.getPrimeNumberForIthIteration(i) == 0)	{
					getStackListB().get(i-1).push(top);
				}
				else	{
					nextStackA.push(top);
				}
			}
			setStackA(nextStackA);
		}
	}
	
	public void printPlateNumbers()	{
		
		for ( int i = 1 ; i <= Q ; i++)	{
			for ( int j = getStackListB().get(i-1).size(); j > 0 ; j--)	{
				int top = getStackListB().get(i-1).pop();
				System.out.println(top);
			}
		}
		
		for ( int j = getStackA().size(); j > 0 ; j--)	{
			int top = getStackA().pop();
			System.out.println(top);
		}
	}

}

class PrimeNumberWrapper {

	HashMap<Integer, Integer> primeNumberMapper = null;

	PrimeNumberWrapper(int Q) {
		primeNumberMapper = new HashMap<>();
		createPrimeNumberHashMap(Q);
	}

	private void createPrimeNumberHashMap(int Q) {

		primeNumberMapper.put(0, 1);
		for (int i = 1; i <= Q; i++) {
			primeNumberMapper.put(i, getNextPrime(primeNumberMapper.get(i - 1)));
		}
	}

	
	private Integer getNextPrime(int i) {

		BigInteger bg = new BigInteger(Integer.toString(i));
		Integer nextPrime = bg.nextProbablePrime().intValue();
		return nextPrime;
	}

	public HashMap<Integer, Integer> getPrimeNumberMapper()	{
		return primeNumberMapper;
	}
	
	public int getPrimeNumberForIthIteration(int I) {
		return primeNumberMapper.get(I);
	}

}

public class Waiter {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int Q = in.nextInt();
		StackWrapper stackWrapper = new StackWrapper(Q);
		PrimeNumberWrapper primeNumberWrapper = new PrimeNumberWrapper(Q);

		for (int i = 0; i < N; i++) {
			stackWrapper.getStackA().push(in.nextInt());
		}

		stackWrapper.performStackOperation(primeNumberWrapper);
		stackWrapper.printPlateNumbers();
		in.close();
	}

}
