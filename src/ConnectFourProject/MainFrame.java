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
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	
	static JPanel gMainPanel;
	static JPanel gGamePanel;
	static JFrame OnePlayerFrame;
	
	public MainFrame() {
		super ("Connect Four");
				
		setLayout(new FlowLayout());
		final JButton instructions = new JButton("Instructions");
		final JButton play = new JButton("Play");
		final JButton quit = new JButton("Quit");
		final JButton about = new JButton("About");
		JLabel boardLabel = new JLabel("Game Board");
	    gMainPanel = new JPanel();
		

		ImageIcon boardImage = new ImageIcon(getClass().getResource("/images/gameBoard.png"));
		boardLabel = new JLabel(boardImage);
				
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(100,100));
		setTitle("Connect Four");
		
		
		// Add action listeners
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
													
				PlayConnectFour.hideAll();
				PlayConnectFour.gPlayerFrame.setVisible(true); 
						
			}

			});	
		
		// Add action listeners
				quit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
										
							int action = JOptionPane.showConfirmDialog(MainFrame.this,
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
						PlayConnectFour.hideAll();
						PlayConnectFour.gInstructionsFrame.setVisible(true);						

					}

				});	
		
				// Add action listeners
				about.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						PlayConnectFour.hideAll();
						PlayConnectFour.gAboutFrame.setVisible(true);						

					}

				});	
		// Add components
		add(instructions);
		add(play);
		add(quit);
		add(about);
		gMainPanel.add(boardLabel);
		add(gMainPanel);
		
	}


}
