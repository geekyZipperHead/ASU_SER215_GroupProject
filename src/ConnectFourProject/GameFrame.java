package ConnectFourProject;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GameFrame extends JFrame {
	
	static JPanel gGamePanel;
	static JFrame OnePlayerFrame;
	
	public GameFrame() {
		super ("Connect Four");
				
		setLayout(new FlowLayout());
		final JButton instructions = new JButton("InstructionsFrame");
		final JButton restart = new JButton("Restart");
		final JButton quit = new JButton("Quit");
		final JButton about = new JButton("AboutFrame");
		JLabel boardLabel = new JLabel("Game Board");
	    gGamePanel = new JPanel();
	    						
		setSize(800,600);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(100,100));
		setTitle("Connect Four");
		
		// Add action listeners
		restart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
				PlayConnectFour.makeMeVisible(PlayConnectFour.gPlayerFrame);
			}

			});	
		
		// Add action listeners
				quit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
										
							int action = JOptionPane.showConfirmDialog(GameFrame.this,
									"Are you sure you want to quit Connect Four?",
									"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);
						
						// exit the game if they no longer want to play...
						if (action != JOptionPane.OK_CANCEL_OPTION) {
							System.exit(0);
						}
							
					}

					});	
		
		// Add action listeners
				instructions.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						PlayConnectFour.makeMeVisible(PlayConnectFour.gInstructionsFrame);

					}

				});	
		
				// Add action listeners
				about.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						PlayConnectFour.makeMeVisible(PlayConnectFour.gAboutFrame);

					}

				});	
		// Add components
		add(instructions);
		add(restart);
		add(quit);
		add(about);
		gGamePanel.add(boardLabel);
		add(gGamePanel);
		
	}


}
