package com.capgemini.fibonacci;

import java.util.Scanner;

public class Main {

	public static final int N = setN();

	public static void main(String[] args) {

		Fibonacci.fibonacci(N);
		System.out.println(N + " - element ciągu wynosi iteracyjnie = " + Fibonacci.fibonacci(N));
		System.out.println(N + " - element ciągu wynosi rekurencyjnie = " + FibonacciRekurencja.fibonacciRekurencja(N));
	}

	public static int setN() {
		int n;
		System.out.println("Wprowadź interesujący element ciągu: ");
		Scanner keyboard = new Scanner(System.in);
		n = keyboard.nextInt();
		return n;
	}
}
