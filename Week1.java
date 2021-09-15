package com.sjcc;

public class Week1 {

	/**
	 * @param args the command line arguments
	 */
	public static int currentSize = 0;// init current size of array
	public static String[] numbers = new String[6];// init array

	/**
	 * @author : Dang-Quang Nguyen, Trang Lam
	 * @param element
	 * @return true: false:
	 */
	public static boolean append(String element) {
		if (currentSize == numbers.length)
			return false; // Array is at maximum capacity
		numbers[currentSize++] = element;// append element into string array
		return true;
	}

	/**
	 * @author : Dang-Quang Nguyen, Trang Lam
	 * @param element
	 * @return true: false:
	 */
	public static void displayNumbers() {
		System.out.println("\n*** Numbers ***");// display title
		System.out.printf("Capacity:\t%d\nElements used:\t%d\n", numbers.length, currentSize);// display current size ,
																								// and length of array
		// loop
		for (int n = 0; n < currentSize; n++)
			System.out.printf("%s\n", numbers[n]);
	}

	public static int linearSearch(String element) {
		// loop for each elements of array
		for (int n = 0; n < currentSize; n++)
			// check each element of array and element - which need to search
			if (numbers[n] == element)
				return n; // return index of array
		// no found
		return -1;
	}

	public static boolean update(String oldValue, String newValue) {
		int searchIndex = linearSearch(oldValue);

		if (searchIndex == -1)
			return false; // Element to update is not found

		numbers[searchIndex] = newValue;
		return true;
	}

	public static boolean deleteShift(String element) {
		int searchIndex = linearSearch(element);

		if (searchIndex == -1)
			return false; // Element to update is not found

		// Shift elements
		for (int n = searchIndex; n < currentSize - 1; n++)
			numbers[n] = numbers[n + 1];

		numbers[--currentSize] = null;
		return true;
	}

	public static boolean deleteMove(String element) {
		int searchIndex = linearSearch(element);

		if (searchIndex == -1)
			return false; // Element to update is not found

		numbers[searchIndex] = numbers[--currentSize];
		numbers[currentSize] = null; // Set last element of array to represent empty

		return true;
	}

	public static boolean insertFront(String element) {
		if (currentSize == numbers.length)
			return false; // Array is at maximum capacity

		for (int n = currentSize; n > 0; n--)
			numbers[n] = numbers[n - 1];

		numbers[0] = element;
		currentSize++;
		return true;
	}

	public static boolean insertFrontNoShift(String element) {
		if (currentSize == numbers.length)
			return false; // Array is at maximum capacity

		numbers[currentSize++] = numbers[0];
		numbers[0] = element;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		displayNumbers();// display element of array
		append("6"); // append element into string array
		append("2");
		append("null");// append null element into string array
		append("3");
		append("1");
		append("7");
		displayNumbers();
		// Search 
		System.out.println("-------SEARCH-----------");
		System.out.println("4 is at index: " + linearSearch("4"));
		// update
		System.out.println("-------UPDATE-----------");
		System.out.println(update("4", "5"));
		displayNumbers();
		
		//delete
		System.out.println("-------DELETE SHIFT-----------");
        System.out.println(deleteShift("6"));
        System.out.println(deleteShift("7"));
        displayNumbers();
        
        //insert
        System.out.println("-------INSERT-----------");
        append("20");
        insertFrontNoShift("50");
        displayNumbers();
        
        //delete
        System.out.println("-------DELETE MOVE-----------");
        System.out.println();
        System.out.println(deleteMove("5"));
        displayNumbers();
        
        //Insert front
        System.out.println("-------INSERT FRONT-----------");
        insertFront("1");
        displayNumbers();
	}

}
