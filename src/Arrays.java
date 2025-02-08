public class Arrays {

    static void numberIntoArray(int number) {
        //first function
        int[] array = new int[10];
        int remainder;
        int current = number;
        int i = 0;
        remainder = number % 10;

        while (current != 0) {
            array[i] = remainder;
            current = current / 10;
            remainder = current % 10;
            i++;
        }
        printArray(array);
    }

    static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("The " + (i + 1) + " element of the array is " + array[i]);
        }
    }

    static void reverseArray() {
        int[] array = {1, 2};
        int temp;
        int size = array.length;
        for (int i = 0; i < size / 2; i++) {
            temp = array[i];
            array[i] = array[size - i - 1];
            array[size - i - 1] = temp;
        }
        printArray(array);
    }

    static int indexOfElement(int number) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                // System.out.println("The index of the element is " + i);
                return i;
            }
        }
        return -1;
    }

    static void secondLargestElement() {
        int[] array = {1, 2, 3, 7, 5};
        int largest = 0;
        int secLargest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > largest && array[i] > secLargest) {
                secLargest = largest;
                largest = array[i];
            } else if (array[i] < largest && array[i] > secLargest) {
                secLargest = array[i];
            }

        }
        System.out.println("The second largest element of the array is " + secLargest);
    }

    static void deleteElement(int number) {
        int[] array = {1, 2, 3, 4, 5};
        int index = indexOfElement(number);
        if (index != -1) {
            for (; index < (array.length - 1); index++) {
                array[index] = array[index + 1];
            }
            array[index] = 0;
            printArray(array);
        } else {
            System.out.println("Given element does not exist in the array");
        }
    }

    static void mergeArrays() {
        int i = 0;
        int j = 0;
        int resultCounter = 0;
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {2, 4, 6, 8};
        int[] array3 = new int[array1.length + array2.length];
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                array3[resultCounter] = array1[i];
                i++;
            } else {
                array3[resultCounter] = array2[j];
                j++;
            }
            resultCounter++;
        }
        if (i == array1.length) {
            for (; j < array2.length; j++) {
                array3[resultCounter] = array2[j];
                resultCounter++;
            }
        } else if (j == array2.length) {
            for (; i < array1.length; i++) {
                array3[resultCounter] = array1[i];
            }

        }
        printArray(array3);
    }

    static boolean isArraySorted(int[] array) {
        //int counter;
        if (array[0] < array[1]) {
            for (int i = 0; i < (array.length-1); i++) {
                if (array[i + 1] < array[i]) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < (array.length-1); i++) {
                if (array[i + 1] > array[i]) {
                    return false;
                }
            }
            return false;
        }
    }

}
