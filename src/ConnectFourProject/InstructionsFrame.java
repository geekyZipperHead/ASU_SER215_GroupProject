package ConnectFourProject;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InstructionsFrame extends JFrame {
		
	public InstructionsFrame() {
		super ("Connect Four");
				
		setLayout(new FlowLayout());
		final JButton main = new JButton("Main Menu");
		final JButton quit = new JButton("Quit");
		final JButton about = new JButton("About");
		JLabel boardLabel = new JLabel("Game Board");
		ImageIcon boardImage = new ImageIcon(getClass().getResource("/images/instructions.png"));
		boardLabel = new JLabel(boardImage);
		
		//ImageIcon icon = new ImageIcon("/images/gameBoard.png");
		//boardLabel.setIcon(icon);
				
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(100,100));
		setTitle("Connect Four");
		
		
		// Add action listeners
		// go back to the main screen
		main.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PlayConnectFour.makeMeVisible(PlayConnectFour.gMainFrame);
			}

			});	
		
		// Add action listeners
		// quit the game
				quit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
										
							int action = JOptionPane.showConfirmDialog(InstructionsFrame.this,
									"Are you sure you want to quit Connect Four?",
									"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
						
						// exit the game if they no longer want to play...
						if (action != JOptionPane.OK_CANCEL_OPTION) {
							System.exit(0);
						}
							
					}

					});	
		
				
				// Add action listeners
				// go to the about game screen
				about.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						PlayConnectFour.makeMeVisible(PlayConnectFour.gAboutFrame);
						

					}

				});	
		
		// Add components
		add(main);
		add(quit);
		add(about);
		add(boardLabel);
		
	}


}
