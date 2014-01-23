import java.io.*;
import java.util.*;

public class Driver {
	public static void main (String[] args) {
		Card[][] deck;
		Game g = new Game();

		System.out.println(g.leftPlayer.bust);
		g.leftPlayer.play(g.deck, g);
		g.addListeners();
		
    }

}
