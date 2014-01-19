import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

public class BlackJackGui extends JPanel{
	protected JFrame frame = new JFrame();
	protected JPanel dealerCards = new JPanel();
	protected JPanel leftPlayerCards = new JPanel();
	protected JPanel rightPlayerCards = new JPanel();
	protected JPanel userCards = new JPanel();
	protected JButton hitButton = new JButton();
    protected JButton dealButton = new JButton();
  	protected JButton stayButton = new JButton();
  	protected BufferedImage deckSpriteSheet, cardBack;
  	protected BufferedImage[][] deck;


	public BlackJackGui() {
		//load deck of images
		try {
			deckSpriteSheet = ImageIO.read(new File("deck.png")); 
			cardBack = ImageIO.read(new File("back.png"));
			deck = new BufferedImage[4][13];
			for (int i = 0; i < 4; i++)  {  
	            for (int j = 0; j < 13; j++)  {  
	                deck[i][j] = deckSpriteSheet.getSubimage(j * 155, i * 225, 155, 225);  
	            }  
	        }  
	    }
	    catch (Exception e) {
	    }

		//builds screen
		Container c = frame.getContentPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setBackground(new Color(52,99,13));
		c.setLayout(new GridBagLayout());
		frame.setSize(1100, 800);
		frame.setVisible(true);
		JLabel picLabel = new JLabel(new ImageIcon(cardBack));
		frame.add(picLabel);
	}

	public void actionPerformed(ActionEvent e) {
    }
}