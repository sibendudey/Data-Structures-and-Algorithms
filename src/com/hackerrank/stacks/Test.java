package com.hackerrank.stacks;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

	public static void finalPrice(int[] arr) {
		ArrayList<Integer> indices = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			int discount = 0;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] <= arr[i]) {
					discount = arr[j];
					break;
				}
			}
			if (discount == 0)
				indices.add(i);

			sum = sum + (arr[i] - discount);
		}

		System.out.println(sum);

		for (int i = 0; i < indices.size(); i++) {
			System.out.print(indices.get(i) + " ");
		}
	}

	public static void main(String args[]) throws Exception {
		// Using Scanner for Getting Input from User
		Scanner in = new Scanner(System.in);

		String s = in.nextLine(); 
		while (true) {
			

			if (s.contains("//")) {
				System.out.println(s.substring(s.indexOf("//"), s.length()));
			}

			if (s.contains("/*")) {
				System.out.println(s.substring(s.indexOf("/*"), s.length()));

				while (!(s = in.nextLine()).contains("*/")) {
					System.out.println(s);
				}
				System.out.println(s.substring(0 , s.indexOf("*/") + 1));
				
				s = s.substring(s.indexOf("*/") + 2 , s.length());
			}
		}

	}
}
