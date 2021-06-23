package math;

import java.util.*;

public class PrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution("123"));
	}
	
	static int[] data = {};
	static Set<Integer> set = new HashSet<Integer>();

	private static int solution(String numbers) {
		// TODO Auto-generated method stub
		
		int n = numbers.length();
		data = new int[n];
		
		for(int i = 0; i < n; i++) {
			data[i] = numbers.charAt(i) - '0';
		}
		
		//순열 - n개 중 r개 부터 n개 까지 선택
		for(int r = 1; r <= n; r++) {
			LinkedList<Integer> arr = new LinkedList<Integer>();
			int[] check = new int[n];
			permutation(n, r, arr, check);
		}
		
		//중복순열 - n개 중 r개 부터 n개 까지 선택 (중복허용)
		for(int r = 1; r <= n; r++) {
			LinkedList<Integer> arr = new LinkedList<Integer>();
			repermutation(n, r, arr);
		}
		
		//조합 - n개 중 r개를 순서 없이 선택
		for(int r = 1; r <= n; r++) {
			int[] arr = new int[r];;
			combination(n, r, arr, 0, 0);
		}
		
		return set.size();
	}
	
	
	//순열
	private static void permutation(int n, int r, LinkedList<Integer> arr, int[] check) {
		// TODO Auto-generated method stub
		if(arr.size() == r) {
			String temp = "";
			for(int i = 0; i < arr.size(); i++) {
				temp += data[arr.get(i)]; 
			}
			int p = Integer.parseInt(temp);
			if(isPrime(p)) {
				System.out.println(p);
				set.add(p);
			}
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(check[i] == 0) {
				arr.add(i);
				check[i] = 1;
				permutation(n, r, arr, check);
				check[i] = 0;
				arr.removeLast();
			}
		}
	}
	
	//중복순열
	private static void repermutation(int n, int r, LinkedList<Integer> arr) {
		// TODO Auto-generated method stub
		if(arr.size() == r) {
			String temp = "";
			for(int i = 0; i < arr.size(); i++) {
				temp += data[arr.get(i)]; 
			}
			System.out.println(temp);
			return;
		}
		
		for(int i = 0; i < n; i++) {
			arr.add(i);
			repermutation(n, r, arr);
			arr.removeLast();
		}
	}
	
	//조합
	private static void combination(int n, int r, int[] arr, int index, int target) {
		// TODO Auto-generated method stub
		if(r == 0) {
			String temp = "";
			for(int i = 0; i < arr.length; i++) {
				temp += data[arr[i]]; 
			}
			System.out.println(temp);
			return;
		}
		
		if(target == n) return;
		
		arr[index] = target;
		
		combination(n, r - 1, arr, index + 1, target + 1);
		combination(n, r, arr, index, target + 1);
	}
	


	private static boolean isPrime(int n) {
		// TODO Auto-generated method stub
		if(n < 2) return false;
		for(int i = 2; i < n/2; i++) {
			if(n % i == 0) return true;
		}
		return true;
	}

}
