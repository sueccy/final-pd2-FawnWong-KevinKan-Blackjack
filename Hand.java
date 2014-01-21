import java.io.*;
import java.util.*;

public class Hand{
    private ArrayList<Card> cards = new ArrayList<Card>;
    private int ptTotal;
    
    public int checkPtTotal(){
	for (int i = 0; i < cards.size(); i++){
	    ptTotal = ptTotal + cards.get(i).ptValue;
	}
	if (ptTotal > 21) {
	    for (int i = 0; i < cards.size(); i++) {
		if (cards.get(i).ptValue == 11) {
		    ptTotal = ptTotal - 10;
		}
	    }
	}
	return ptTotal;	
    }
    

}