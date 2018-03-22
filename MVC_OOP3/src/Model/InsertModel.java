package Model;

import java.util.Arrays;

public class InsertModel 
{
    public int stepCount = 0;
    private int[] randomArray;
    public boolean autoSort = false;
    
    public InsertModel(int[] arr)
    {
    	randomArray = arr;
    }
    
    public int[] Sort()
    {
        int[] tempArr = Arrays.copyOf(randomArray, randomArray.length);
        int j, newValue;
        if (stepCount < tempArr.length) {
            newValue = tempArr[stepCount];
            j = stepCount;
            System.out.println(stepCount);
            if (j > 0 && tempArr[j - 1] > newValue) {
                tempArr[j] = tempArr[j - 1];
                System.out.println(j);
                j--;
            }
            tempArr[j] = newValue;
            randomArray = Arrays.copyOf(tempArr, tempArr.length);
            stepCount++;
        }
        else {
            stepCount = 0;

        }
        
        if(Sorted())
    		autoSort = false;
        
        return randomArray;
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
    
    public void SetArray(int[] arr)
    {
    	randomArray = arr;
    }
    
    public boolean Autosort()
    {
    	if(autoSort)
    		return true;
    	return false;
    }
}
