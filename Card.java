import java.io.*;
import java.util.*;

public class Card{
    protected int ptValue;
    protected int suit; 
    /* clubs = 0; diamonds = 1; hearts = 2; spades = 3; */
	
    public void setValue(int i) {
	if (i == 0){
	    ptValue = 11;
	}
	if (i > 0 && i < 11){
	    ptValue = i;
	}
	if (i > 11){
	    ptValue = 10;
	}
    }
    
}
