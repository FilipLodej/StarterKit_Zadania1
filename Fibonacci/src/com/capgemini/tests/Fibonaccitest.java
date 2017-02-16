package com.capgemini.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capgemini.fibonacci.Fibonacci;
import com.capgemini.fibonacci.FibonacciRekurencja;

public class Fibonaccitest {

	@Test
	public void fibonacciInteracyjnie() {
		// when
		int n = 10;
		// then
		assertEquals(55, Fibonacci.fibonacci(n));
	}

	@Test
	public void fibonacciRekurencyjnie() {
		// when
		int n = 10;
		// then
		assertEquals(55, FibonacciRekurencja.fibonacciRekurencja(n));
	}

}
