import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.imageio.*;

public class BlackJackGui extends JPanel implements ActionListener{
	protected JFrame frame = new JFrame();
	protected Container cPane = frame.getContentPane();
	protected JPanel center = new JPanel();
	protected JPanel dealerCards = new JPanel(new GridBagLayout());
	protected JPanel leftPlayerCards = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	protected JPanel rightPlayerCards = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	protected JPanel userCards = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	protected JPanel userThings  = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
	protected JPanel userPanel  = new JPanel(new GridBagLayout());
	protected JButton hitButton;
    protected JButton dealButton;
  	protected JButton stayButton;
  	protected BufferedImage deckSpriteSheet;
  	protected BufferedImage[][] deck;
  	protected JLabel[] backs = new JLabel[10]; //because swing components can't be reused...

	public void actionPerformed(ActionEvent e){ 
		if (e.getSource() == dealButton){
			center.remove(dealButton);
			hitButton.addActionListener(this);
			stayButton.addActionListener(this);
			userCards.removeAll();
			userCards.add(getRandomCard());
			userCards.add(getRandomCard());
			rightPlayerCards.add(getRandomCard());
			leftPlayerCards.add(getRandomCard());
			dealerCards.add(getRandomCard());
			cPane.revalidate();
			cPane.repaint();
		}
		if (e.getSource() == hitButton){
			userCards.add(getRandomCard());
			dealerCards.add(getRandomCard());
			rightPlayerCards.add(getRandomCard());
			leftPlayerCards.add(getRandomCard());
			cPane.revalidate();
			cPane.repaint();
		}
	}

	public BlackJackGui() {
		createScreen(frame);
	}

	public void createScreen(JFrame frame) {
		loadImages();

		//builds screen
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1; c.weighty = 1;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cPane.setBackground(new Color(52,99,13));
		cPane.setLayout(new GridBagLayout());
		frame.setExtendedState(Frame.MAXIMIZED_BOTH); 
		frame.setVisible(true);
		frame.setResizable(false);

		hitButton = new JButton("HIT");
  		stayButton = new JButton("STAY");
  		dealButton = new JButton("DEAL");
    	dealButton.addActionListener(this);

		dealerCards.setOpaque(false);
		leftPlayerCards.setOpaque(false);
		rightPlayerCards.setOpaque(false);
		userCards.setOpaque(false);
		userThings.setOpaque(false);
		userPanel.setOpaque(false);
		center.setOpaque(false);

		dealerCards.add(backs[0]);
		leftPlayerCards.add(backs[1]);
		rightPlayerCards.add(backs[2]);
		center.add(dealButton);

		userThings.add(hitButton,c);
		userThings.add(stayButton,c);
		userCards.add(backs[3]);
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		userPanel.add(userThings, c);
		c.anchor = GridBagConstraints.CENTER;
		c.gridy = 1;
		userPanel.add(userCards, c);



        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;c.gridwidth = 4;
        c.gridx = 0;c.gridy = 0;
		frame.add(dealerCards, c);
        c.gridx = 0; c.gridwidth = 1;
        c.gridy = 1;
        frame.add(leftPlayerCards, c); 
        c.gridx = 1; c.gridwidth = 2;      
        frame.add(center, c);      
        c.gridx = 3; c.gridwidth = 1;
        frame.add(rightPlayerCards, c);
        c.anchor = GridBagConstraints.CENTER;
        c.weightx = 1;c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 2;
        frame.add(userPanel, c);
	}
	
	public JLabel getRandomCard() {
		Random r = new Random();
		int row = r.nextInt(4);
		int col = r.nextInt(13);
		return new JLabel(new ImageIcon(deck[row][col]));
	}

	public JLabel getCardBack() {
		JLabel l = new JLabel();
		try {
			l = new JLabel(new ImageIcon(ImageIO.read(new File("back.png"))));
		}
		catch (Exception e) {
	    }
		return l;
	}
	public void loadImages() {
		try {
			deckSpriteSheet = ImageIO.read(new File("deck.png")); 
			deck = new BufferedImage[4][13];
			for (int i = 0; i < 4; i++)  {  
	            for (int j = 0; j < 13; j++)  {  
	                deck[i][j] = deckSpriteSheet.getSubimage(j * 155, i * 225, 155, 225);  
	            }  
	        }  
	    }
	    catch (Exception e) {
	    }
	    for (int i = 0; i < backs.length; i++) {
	    	backs[i] = getCardBack();
	    }
	}
}