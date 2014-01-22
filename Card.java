import java.io.*;
import java.util.*;

public class Card{
    protected int ptValue;
    protected int suit; 

    protected int col;
    protected Boolean isDealt;
    /* clubs = 0; diamonds = 1; hearts = 2; spades = 3; */

    public Card(int row, int col, Boolean b) {
    	suit = row;

    	//ace
    	if (col == 0) 
    		ptValue = 11;
    	// 2-9
    	if (col >= 1 && col <= 8) 
    		ptValue = col + 1;
    	//10, jack, queen, king
    	if (col >= 9) 
    		ptValue = 10;    	
    	this.col = col;
    	isDealt = b;
    }

}
