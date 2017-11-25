import java.util.Scanner;

public class Quick_Sort {
    private int[] numbers;
    private int number;

    public void sort(int[] values) {
        // check if array values are empty or null
        if (values == null || values.length == 0){
            return;
        }
        // naming this array as "values"
        this.numbers = values; 
        // integer "number" now represents the size of above array
        number = values.length; 
        // calling quicksort method and inputting the 0th and last index number
        // these will be inputted into quicksort method a low and high respectively
        quicksort(0, number - 1); 
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // The pivot element is found in the middle of the list
        // it is somewhat arbitrary
        int pivot = numbers[low + (high-low)/2];

        // Divide the list into two
        while (i <= j) {
            // If our current value from the left of the list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If our current value from the right list is larger than the pivot element
            // then we get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // if an element has been found in the left list that is
            // larger than the pivot or if an element has been found 
            // in the right list that is smaller than the pivot
            // the two are exchanged
            // as we are ady to move on to the next step
            // we can incrament i and j by 1
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // recursive method, after i and j have been incremented
        // the new array elements are inserted into the quicksort method
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    // this method shows how elements are swapped if they are 
    // on the wrong side of the pivot 
    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
        
    }
    
    public static void main(String[] args) {

        //setting up the scanner
        Scanner s = new Scanner(System.in);
        
        //prompting input
    	System.out.println("How many elements do you need sorted?");
        
        //storing input
        int n = s.nextInt();
    	
    	int arr[] = new int[n];
               
        System.out.println("Enter the elements of your array, please.");
        
        //populating array
        for (int i = 0; i < n; i++) {
        	arr[i] = s.nextInt();
        }
        
        //instanciating object of Quick_Sort class
        Quick_Sort sorter = new Quick_Sort();
        //calling a method on object with array argument
    	sorter.sort(arr);
        
        System.out.println("Your elements after recursive Quick Sort");

        for (int i = 0; i < n; i++)
            System.out.println(arr[i]);
        
        s.close();  
       
    }//end main method

}//end class






