package com.capgemini.fibonacci;

public class Fibonacci {

	public static long fibonacci(int n) {
		long fibonacci = 0;
		int a = 1;
		int b = 1;
		int c = 1;
		if (n == 0) {
			fibonacci = 0;
		} else if (n == 1 || n == 2) {
			fibonacci = 1;
		} else {
			for (int i = 2; i < n; i++) {
				c = a + b;
				a = b;
				b = c;
				fibonacci = c;
			}
		}
		return fibonacci;
	}
}
