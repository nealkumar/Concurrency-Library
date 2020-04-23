package org.jbrew.cbrew_tests.espresso;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.jbrew.cbrew.espresso.SumOperation;
import org.jbrew.core.annotations.Testing;
import org.junit.Ignore;
import org.junit.Test;

@Testing
public class SumTest {
	
	@Test
	public void sumRecBasicTest() {
		int[] arr = {100, 50, 50};
		SumOperation op = new SumOperation();
		int sum = op.performOperation(arr);
		assertEquals(200, sum);
	}
	
	@Test
	public void sumRecMedTest() {
		int[] arr = new int[1000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSum(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Test
	public void sumStreamsMed2Test() {
		int[] arr = new int[10_000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSum(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Test
	public void sumStreamsMed3Test() {
		int[] arr = new int[15_000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSum(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Test
	public void sumStreamsLargeTest() {
		int[] arr = new int[100_000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSumStreams(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Test
	public void sumStreamsLarge2Test() {
		int[] arr = new int[1_000_000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSumStreams(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Test
	public void sumStreamsLarge3Test() {
		int[] arr = new int[10_000_000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSumStreams(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Ignore /*Ignored because it takes >40 seconds to complete...*/
	@Test
	public void sumStreamsLarge4Test() {
		int[] arr = new int[100_000_000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSumStreams(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Ignore /*Ignored because it takes >10 minutes to complete...*/
	@Test
	public void sumStreamsLarge5Test() {
		int[] arr = new int[1_000_000_000];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSumStreams(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	@Ignore /*Ignored because it takes >10 minutes to complete...*/
	@Test
	public void sumStreamsLarge6Test() {
		int[] arr = new int[1_000_000_001];
		for(int index=0; index<arr.length; index++) {
			arr[index] = new Random().nextInt();
		}
		int trueSum = findSumStreams(arr);
		SumOperation op = new SumOperation();
		int testSum = op.performOperation(arr);
		System.out.println("Expecting: " + trueSum + ", Received: " + testSum);
		assertEquals(trueSum, testSum);
	}
	
	private int findSum(int[] arr) {
		return helper(arr, 0, 0, arr.length);
	}
	
	private int findSumStreams(int[] arr) {
		List<Integer> ints = new ArrayList<Integer>(arr.length);
		for(int i : arr) {
			ints.add(i);
		}
		return ints.parallelStream()
				.reduce(0, Integer::sum);
	}
	
	private int helper(int[] arr, int index, int sum, int bound) {
		if(index == bound) return sum;
		int curr = sum + arr[index];
		return helper(arr, ++index, curr, bound);
	}

}
