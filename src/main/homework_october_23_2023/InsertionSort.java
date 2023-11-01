package main.homework_october_23_2023;

public class InsertionSort {
    public static void main(String[] args) {
       int[] numbersArray = {1, 5, 3, 8, 2, 9, 16, 10};
        insertionSort(numbersArray);
        for (int i = 0; i<numbersArray.length; i++){
            System.out.println(numbersArray[i]);
        }
    }
    // Insertion sort example
    public static int[] insertionSort(int[] arr){
        for (int j = 1; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i > 0 && arr[i] > key) {
                arr[i+1] = arr[i];
                i -= 1;
            }
            arr[i+1] = key;
        }
        return arr;
    }
}





