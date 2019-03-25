import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		// nextGreaterElement();
		// sortArray();
		// permutation();
		// allUniqueChars();
		// numOfEachChar();
		// notRepeated();
		// missingFrom100();
		// reverseString();
		   fibonacci();
	}

	public static void nextGreaterElement() {
		int[] arr = new int[] { 4, 5, 2, 25 };
		int[] arr2 = new int[] { 13, 7, 6, 12 };
		int[] arr3 = new int[] { 11, 13, 21, 3 };
		int[] arr4 = new int[] { 4, 5, 2, 25, 13, 7, 6, 12, 11, 13, 21, 3 };

		nextGreaterElement(arr);
		nextGreaterElement(arr2);
		nextGreaterElement(arr3);
		nextGreaterElement(arr4);

	}

	private static void nextGreaterElement(int[] arr) {

		System.out.println("\nElement: \t Next Greater Element");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + " \t---> \t" + findNextGreater(arr, i));

		}
	}

	private static int findNextGreater(int[] arr, int index) {

		for (int d = index; d < arr.length; d++) {
			if (arr[d] > arr[index])
				return arr[d];
		}
		return -1;

	}

	public static void sortArray() {
		int[] arr = new int[] { 3, 4, 5, 6, 8, 7, 9, 10, 11, 12 };
		int[] arr2 = new int[] { 12, 11, 10, 9, 8, 7, 4, 3, 1 };

		int[] outputArr = sortArray(arr2);

		for (int num : outputArr) {
			System.out.print(num + ", ");
		}

		System.out.println("\n");
	}

	private static int[] sortArray(int[] arr) {
		int[] returnArr = arr;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;

				i = -1;

				Map map = new HashMap();
			}
		}

		return returnArr;
	}

	public static void permutation() {
		String string1 = "cats";
		String string2 = "stac";

		if (determinePermutation(string1, string2))
			System.out.println(string1 + " and " + string2 + " are Permutations");
		else
			System.out.println(string1 + " and " + string2 + " are NOT Permutations");
	}

	private static boolean determinePermutation(String first, String second) {

		if (first.length() != second.length())
			return false;

		char[] a = first.toCharArray();
		char[] b = second.toCharArray();

		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}

		return true;

	}

	public static void allUniqueChars() {

		String string = "touie";

		if (allUniqueChars(string))
			System.out.println("True, all characters in " + string + " are unique");
		else
			System.out.println("The characters in " + string + " are not unique");
	}

	private static boolean allUniqueChars(String string) {

		char[] charArr = string.toCharArray();

		for (int i = 0; i < string.length(); i++) {

			for (int d = i; d < string.length(); d++) {
				if ((charArr[i] == charArr[d]) && (i != d)) {
					return false;
				}
			}
		}

		return true;

	}

	public static void numOfEachChar() {
		String string = "Cody Is Cool";

		int[] num = numOfEachChar(string);

		for (int i = 0; i < num.length; i++) {

			if (num[i] > 0) {
				char c = (char) i;
				System.out.println("Number of " + c + ": " + num[i]);
			}
		}

	}

	private static int[] numOfEachChar(String input) {

		int[] returnVals;

		char[] charArr = input.toCharArray();

		int sizeOfArray = charArr.length;

			returnVals = new int[127];

		for (int i = 0; i < returnVals.length; i++) {
			returnVals[i] = 0;
		}

		for (int i = 0; i < charArr.length; i++) {
			returnVals[charArr[i]]++;
		}

		return returnVals;
	}
	
	public static int notRepeated() {
		
		int[] arr = new int[] {1, 1, 2, 2, 2, 2, 3, 3, 4, 4, 5};

		Arrays.sort(arr);
		
		int counter = 0;
		
		int currVal = arr[0];

		for (int i = 0; i < arr.length; i++) {
			
			if (i == arr.length - 1) {
				if (arr[arr.length-2] != arr[arr.length-1])	return arr[arr.length - 1];
				else {
					return 0;
				}
			}
		
			if (currVal == arr[i]) counter++;
			
			else {
				
				if (counter == 1) return currVal;
										
				currVal = arr[i];
				counter = 1;
			}
		}
		
		return 0;
	}

	
	public static int missingFrom100() {
		int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 23,
				24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35,
				36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
				48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59,
				60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71,
				72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83,
				84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95,
				96, 97, 98, 99, 100};
		
		Arrays.sort(arr);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != i+1) {
				System.out.println(i+1 + " is missing");
				return i;
			}
		}
		System.out.println("All numbers are present");
		return 0;
			
		
		
	}
	
	public static String reverseString() {
	
		String string = "Cats are cool";
		
		char[] charArr = string.toCharArray();
		char[] reverseArr = new char[charArr.length];
		
		
		for (int i = 0; i < charArr.length; i++) {
			
			reverseArr[charArr.length - 1 - i] = charArr[i];
		}
		
		String reverse = new String(reverseArr);
		
		System.out.println(reverse);
		
		return reverse;
		
	}


	public static void fibonacci() {
		// The next number is found by adding the two numbers before it
		BigInteger twoBack = BigInteger.valueOf(0);
		BigInteger oneBack = BigInteger.valueOf(1);
		
		System.out.println(twoBack + ", ");
		
		for (int i = 0; i < 100; i++) {
			BigInteger result = oneBack.add(twoBack);
			
			System.out.println(result +", ");
			
			twoBack = oneBack;
			oneBack = result;
		}
	}
}
