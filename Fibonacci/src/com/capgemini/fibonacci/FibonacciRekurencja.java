package com.capgemini.fibonacci;

public class FibonacciRekurencja {

	public static long fibonacciRekurencja(int n) {
		long fibRek = 0;
		if (n == 0) {
			return fibRek;
		} else if (n == 1 || n == 2) {
			return fibRek = 1;
		} else {
			for (int i = 2; i < n; i++) {
				fibRek = fibonacciRekurencja(n - 1) + fibonacciRekurencja(n - 2);
			}
		}
		return fibRek;
	}
}
