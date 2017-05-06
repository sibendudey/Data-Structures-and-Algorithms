package com.hackerearth.buyhatke;

import java.util.ArrayList;
import java.util.Scanner;

public class BuyHatke2 {
	public static void main( String args[])	{
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		int X = in.nextInt();
				
		Berland berland = new Berland(N);
		
		for ( int i = 0 ; i < M ; i ++)	{
			int specialCityIndex = in.nextInt();
			berland.cities[specialCityIndex - 1].isSpecial = true;
		}
		
		for ( int i = 0 ; i < X ; i++)	{
			int u = in.nextInt();
			int v = in.nextInt();
			
			berland.cities[u-1].connectedCity.add(v-1);
		}
		
		for ( int i = 0 ; i < berland.cities.length ; i++)	{
			berland.cities[i].findConnectionPower();
		}
		
		
		
		in.close();
	}
}


class Berland	{
	City[] cities;
	
	Berland( int N)		{
		cities = new City[N];
		initializeCities();
	}

	private void initializeCities() {
		for ( int i = 0 ; i < cities.length ; i++)
			cities[i] = new City();
		
	}
}


class City	{
	boolean isSpecial;
	int connectionPower = 0;
	ArrayList<Integer> connectedCity = new ArrayList<>();
	
	void incrementConnPower()	{
		connectionPower++;
	}
	
	int connectedPower()	{
		if ( connectionPower != 0)	
			return connectionPower;
		
		for ( int i = 0 ; i < connectedCity.size() ; i++)	{
			connectionPower += 
		}
	}
	
}
