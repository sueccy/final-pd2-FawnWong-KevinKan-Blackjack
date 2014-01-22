import java.io.*;
import java.util.*;

public class NPC extends Player {
	public void play() {
		while (!bust) {
			if (countCards()) {
				super.hit();
			}
		}
	}
	
	public Boolean countCards() {
		
	}

}
