package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.*;

public class Logo extends JPanel {
	
	JButton returnButton;
	CardLayout cl;
    JPanel cards;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    String language;
    Font font;
    int textSpeed;
    MainGame mg;
    Player player;
    Rival rival;
    Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
    Float titleSize;
    int buttonWidth;
    int buttonHeight;
    ImageIcon logoIcon;
    JLabel logoLabel;
	
	public Logo (final CardLayout layout, final JPanel cards, String language, Font font, int textSpeed,
			Player player, Rival rival, Boolean stopTimer, Float titleSize, int buttonWidth, int buttonHeight,
			Boolean professorOakVisited, Boolean labOutsideButtonEnable) {
		 this.cl = layout;
	     this.cards = cards;
	     this.language = language;
	     this.font = font;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.titleSize = titleSize;
	     this.buttonWidth = buttonWidth;
	     this.buttonHeight = buttonHeight;
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
	     
	     setBackground(Color.black);
	     
	     JButton returnButton = new JButton("Return");
	     returnButton.setPreferredSize(new Dimension(50,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 if(language == "Japanese") {
			 returnButton.setText("とじる");
		 }
		 
		 
		 logoIcon = new ImageIcon(this.getClass().getClassLoader().getResource("mainLogoStarters3.png"));
		 logoLabel = new JLabel(logoIcon);
		 
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 gb.gridx = 0;
		 gb.gridy = 0;
		 add(returnButton, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 1;
		 add(logoLabel, gb);
		 
		 
		 
		 
		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, 
	            			titleSize, buttonWidth, buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable);
	            	cards.add(mg, "mainscreen");
	                layout.show(cards, "mainscreen");

	            }
	        });
	}
	

}
