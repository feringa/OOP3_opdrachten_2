package Model;

public class Model 
{
	private int[] randomArray = new int[10];
	
	public BubbleModel bubble = new BubbleModel(randomArray);
	public InsertModel insert = new InsertModel(randomArray);
	public QuickModel quick = new QuickModel(randomArray);
	
	public int[] GenerateArray(int length)
    {
        int temp[] = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = (int)(Math.random()*10);//note, this generates numbers from [0,9]

            for (int j = 0; j < i; j++) {
                if (temp[i] == temp[j]) {
                    i--; //if a[i] is a duplicate of a[j], then run the outer loop on i again
                    break;
                }
            }
        }
        randomArray = temp;
        return randomArray;
    }
	 
	 public int[] GetRandomArray()
	 {
		 return randomArray;
	 }
}
