package com.hackerearth.buyhatke;

import java.util.Scanner;

public class BuyHatke1 {
	public static void main(String [] args)	{
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int M = in.nextInt();
		
		int K = in.nextInt();
		
		Classroom classroom = new Classroom(K,M);
		
		
		int noOfStudentNoPreferredSeat = 0;
		for ( int i = 0 ; i < N ; i++)	{
			int preferredRow = in.nextInt();
			boolean preferredSeat = false;
			for ( int j = 0 ; j < M ; j++)	{
				if ( classroom.row[(preferredRow - 1 + j ) % (M)].isFull == false)	{
					classroom.row[(preferredRow - 1 + j) % (M) ].decrementSeatsLeft();
					if ( j == 0 )
						preferredSeat = true;
					
					break;
				}
			}	
			if ( preferredSeat == false)
				noOfStudentNoPreferredSeat++;
		}
		
		System.out.println(noOfStudentNoPreferredSeat);
		
		in.close();
	}
}


class Classroom	{
	
	
	static int K;
	Row[] row;
	
	Classroom(int K, int M)	{
		Classroom.K = K;
		row = new Row[M];
		initializeRow();
	}

	private void initializeRow() {
		for ( int i = 0 ; i < row.length ; i++)	{
			row[i] = new Row(K);
		}
		
	}
}

class Row	{
	
	int seatsLeft;
	boolean isFull;
	
	Row( int capacity)	{
		seatsLeft = capacity;
	}
	
	void decrementSeatsLeft()	{
		seatsLeft--;
		if ( seatsLeft == 0)
			isFull = true;
	}
	
	boolean isFull()	{
		return isFull;
	}
	
}
