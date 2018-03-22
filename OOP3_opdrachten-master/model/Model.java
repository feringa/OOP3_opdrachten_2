package model;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

import model.myReader;
import model.zoekClass;


public class Model 
{
	
	public myReader r;
	public zoekClass woordZoeker;
	int maxWordLength;
	char [][] boardArray;
	ArrayList<String> dictionaryOfWords;
	boolean [][] visitedBoardArray;
	
	
    /* 2d array definition */
    int maxRow = 4;
    int maxCol = 4;
	
	public Model()
	{
		 
		r = new myReader();
		    	    
	}
	
	
         /* Allocate 2d char array*/
	
	public char[][] GenerateBoard()
	{
        boardArray = new char [maxRow][maxCol];
                
        /* Fill 2d array at random with lower case chars */
        for (int row =0; row<maxRow;row++)
        {
            for (int col =0; col<maxCol;col++)
            {
                Random rand = new Random();
                char c = (char)(rand.nextInt(26) + 'a');
                boardArray[row][col]= c;
            }
        }
        return boardArray;
	}
     
	/* find any string in boardArray existing also in dictionaryOfWords */    
    public void Start() 
    {
    	
    	ArrayList<String> dictionaryOfWords = new ArrayList<String>();
	    dictionaryOfWords = r.ReadText("dict.txt");
    	visitedBoardArray = new boolean [maxRow][maxCol];
    	woordZoeker = new zoekClass(dictionaryOfWords, boardArray, maxRow, maxCol);
    	maxWordLength = getLongestWordSize(dictionaryOfWords);
    	
        for (int row = 0; row<maxRow;row++)
        {
            for (int col =0; col<maxCol;col++)
            {
                /* Find words from position  */
                String str = new String("");
                Point[] path = new Point[maxWordLength];
                woordZoeker.findWords(row, col, visitedBoardArray, str, path);
            }
         }
        
        /* print found words */
        ArrayList<Point[]> resultPaths = woordZoeker.GetResultList();
        System.out.println("The results are:");
        for (Point[] result: resultPaths) {
            for (int i=0; i< result.length;i++){
                System.out.print(boardArray[result[i].x][result[i].y]);
            }
            System.out.println("");
        }
        System.out.println(resultPaths.size() + " words found");
    }
 
       
	  
       
        public int getLongestWordSize(ArrayList<String> words)
        {
            int largestString = words.get(0).length();
            for(int i = 0; i < words.size(); i++) 
            {
                if(words.get(i).length() > largestString) 
                {
                    largestString = words.get(i).length();
                }
            }
            return largestString;
        }
}


