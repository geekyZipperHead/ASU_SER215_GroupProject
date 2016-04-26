
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TwoPlayerFrame extends JFrame {
		
	public TwoPlayerFrame() {
		super ("Connect Four");
				
		final JButton play = new JButton("Play");
		final JButton quit = new JButton("Quit");
			  
		JLabel chooseColor = new JLabel("Choose your disc color.");

		String[] color_default = {"Red Discs", "Yellow Discs"};
		final JComboBox<String> colors = new JComboBox<String>(color_default);
		
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(100,400));
		setTitle("Connect Four");
		setLayout(new FlowLayout());
		
		JLabel text1 = new JLabel("Enter First Player's name");
		final JTextField firstPlayer = new JTextField(15);
		
		JLabel text2 = new JLabel("Enter Second Player's name");
		final JTextField secondPlayer = new JTextField(15);
		
		// Add action listeners
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				String player1 = firstPlayer.getText();	
				String player2 = secondPlayer.getText();	

				String color1 = "";
				String color2 = "";

				
				String colorChoice = colors.getSelectedItem().toString();
					
					if (colorChoice.equals("Red Discs")) {
						color1 = "red";
						color2 = "yellow";
					} else {
						color1 = "yellow";
						color2= "red";

					}
					
					Player p1 = new Player(player1, color1);
					Player p2 = new Player(player2, color2);
					
					System.out.println("Player1: " + p1.getName());
					System.out.println("Disc color: " + p1.getColor());
					System.out.println("Player1 Score: " + p1.getScore());
					System.out.println("Player2: " + p2.getName());
					System.out.println("Disc color: " + p2.getColor());
					System.out.println("Player2 Score: " + p2.getScore());

					
			}

			});		
		
		// Add components
		add(text1);
		add(firstPlayer);
		add(chooseColor);
		add(colors);
		add(text2);
		add(secondPlayer);
		add(play);
		add(quit);
		
		setVisible(true);
	}

}
