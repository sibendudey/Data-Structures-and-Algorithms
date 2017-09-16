package com.hackerearth.accolite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Monk {

	static ArrayList<Integer> monk;
	static ArrayList<Integer> monk2;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int N = in.nextInt();
		int M = in.nextInt();

		monk = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			monk.add(in.nextInt());
		}

		monk2 = new ArrayList<Integer>();

		for (int i = 0; i < M; i++) {
			monk2.add(i);
		}

		Collections.sort(monk);
		Collections.sort(monk2);

		/*
		int[] monkFX = new int[N];
		int[] monkFY = new int[N];

		for (int i = 0; i < N; i++) {
			if ( i > 0 && monk[i] == monk[i - 1]) {
				monkFX[i] = monkFX[i - 1];
				monkFY[i] = monkFY[i - 1];
			} else {
				monkFX[i] = calculateLessforIthElment(monk[i], monk2);
				monkFY[i] = calculateGreaterForIthElement(monk[i], monk2);
			}
		}

		int[] monk2FX = new int[M];
		int[] monk2FY = new int[M];

		for (int i = 0; i < M; i++) {
			if (i > 0 && monk2[i] == monk2[i - 1]) {
				monk2FX[i] = monk2FX[i - 1];
				monk2FY[i] = monk2FY[i - 1];
			} else {
				monk2FX[i] = calculateLessforIthElment(monk2[i], monk);
				monk2FY[i] = calculateGreaterForIthElement(monk2[i], monk);
			}
		}
		*/
		
		
		
		long monkScore = calculateMonkScore(monk, monk2);
		
		long monkScore2 = calculateMonkScore(monk2 , monk);
		

		if (monkScore > monkScore2) {
			System.out.println("Monk " + (monkScore - monkScore2 ));
		} else if ( monkScore2 > monkScore){
			System.out.println("!Monk " + (monkScore2 - monkScore));
		}
		else	{
			System.out.println("Tie");
		}
		
		in.close();

	}
	
	private static int calculateMonkScore( ArrayList<Integer> monk , ArrayList<Integer> opponentMonk)	{
		int monkScore = 0;
		
		
		for (int i = 0; i < monk.size(); i++) {
			int lesserDanPos = opponentMonk.indexOf(monk.get(i));
			if ( lesserDanPos == -1)	{
				lesserDanPos = Collections.binarySearch(opponentMonk, monk.get(i));
				if ( lesserDanPos < 0)	{
				lesserDanPos = -lesserDanPos;
				lesserDanPos =- 1;
				}
			}
			
			int greaterDanPos = opponentMonk.lastIndexOf(monk.get(i));
			
			if ( greaterDanPos == -1)	{
				greaterDanPos = Collections.binarySearch(opponentMonk, monk.get(i));
				if ( greaterDanPos < 0)	{
					greaterDanPos = -greaterDanPos;
					greaterDanPos =- 1;
					}
			}
			
			monkScore += ( lesserDanPos * ( opponentMonk.size() - greaterDanPos));
			
		}
		
		
		return monkScore;
		
	}

	private static int calculateGreaterForIthElement(int val, int[] monk) {
		int pos = Arrays.binarySearch(monk, val);

		while (pos >= 0 && pos < monk.length - 1) {
			if (monk[pos] == monk[pos + 1]) {
				pos = pos + 1;
			} else
				break;
		}

		if (pos < 0) {
			pos = -pos;
			pos = pos - 1;
		}

		return monk.length - pos;

	}

	private static int calculateLessforIthElment(int val, int[] monk) {

		int pos = Arrays.binarySearch(monk, val);

		while (pos > 0 && pos < monk.length) {
			if (monk[pos] == monk[pos - 1]) {
				pos = pos - 1;
			} else
				break;
		}

		if (pos < 0) {
			pos = -pos;
			pos = pos - 1;

		}
		return pos;
	}

}
