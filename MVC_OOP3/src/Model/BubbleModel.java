package Model;

import java.util.Arrays;

public class BubbleModel 
{
    public int stepCount = 0;
    private int[] randomArray;
    public boolean autoSort = false;
    
    public BubbleModel(int[] arr)
    {
    	randomArray = arr;
    }
    
    public int[] Sort()
    {
        int[] tempArr = Arrays.copyOf(randomArray, randomArray.length);
        int tempLow = 0;
        int tempHigh = 0;
        System.out.println("stepcount : " + stepCount);
        if (stepCount < tempArr.length - 1) {
            if (tempArr[stepCount] > tempArr[stepCount + 1]) {
                tempLow = tempArr[stepCount];
                tempHigh = tempArr[stepCount + 1];
                tempArr[stepCount] = tempHigh;
                tempArr[stepCount + 1] = tempLow;
                randomArray = Arrays.copyOf(tempArr, tempArr.length);
                System.out.println("Switched : " + tempLow + " With : " + tempHigh);
                stepCount = 0;
            } else
            {
                stepCount++;
            }
        }
        if (stepCount >= randomArray.length - 1)
            stepCount = 0;
        
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
