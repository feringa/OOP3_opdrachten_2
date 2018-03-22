package Model;

import java.util.Arrays;

public class QuickModel 
{
    public int stepCount = 0;
    private int[] randomArray;
    public boolean autoSort = false;
    public boolean firstRecursion = true;
    private int prevHigh, prevLow;
    
    public QuickModel(int[] arr)
    {
    	randomArray = arr;
    }
    //this function is called from Controller. 
    //so if this function is called its the first iteration
    public int[] Sort()
    {
    	return quicksort(0, randomArray.length -1);
    }
    
    private int[] quicksort(int low, int high) {
    	int i = low,j = high;

        // Get the pivot element from the middle of the list
        int pivot = randomArray[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            while (randomArray[i] < pivot) {
                i++;
            }
            while (randomArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        
        // Recursion
        if (low < j)
    		quicksort(low, j);
        if (i < high)
            quicksort(i, high);
        
        return(randomArray);       
    }

    public boolean Sorted()
    {
    	boolean temp = false;
    	int i;
    	for (i = 0; i < randomArray.length - 1;i = i+1) 
    	{ 
    	    if (randomArray[i] < randomArray[i + 1]) {
    	    	temp = true;
    	    }
    	    else {
    	    	temp = false;
    	    	return temp;
    	    }
    	}
    	return temp;
    }
    
    public boolean Autosort()
    {
    	if(autoSort)
    		return true;
    	return false;
    }

    private void exchange(int i, int j) {
        int temp = randomArray[i];
        randomArray[i] = randomArray[j];
        randomArray[j] = temp;
    }
    
    public void SetArray(int[] arr)
    {
    	randomArray = arr;
    }
    
    public int[] GetArray() {return randomArray;};
}
