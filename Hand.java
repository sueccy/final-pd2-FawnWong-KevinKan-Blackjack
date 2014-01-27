import java.io.*;
import java.util.*;

public class Hand{
    protected ArrayList<Card> cards;
    protected int ptTotal = 0;

    public Hand() {
    	cards = new ArrayList<Card>();
    }
    
    public void updatePtTotal(){
    	ptTotal = 0;
		for (int i = 0; i < cards.size(); i++){
			ptTotal = ptTotal + cards.get(i).ptValue;  
		}
		if (ptTotal > 21) {
			for (int i = 0; i < cards.size() && ptTotal > 21; i++) {
				if (cards.get(i).ptValue == 11) {
					ptTotal = ptTotal - 10;
					cards.get(i).ptValue = 1;
				}
			}
		}
    }

}
