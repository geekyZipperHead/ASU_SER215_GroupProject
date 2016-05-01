package ConnectFourProject;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class AboutFrame extends JFrame {
	
	static JPanel gBoardPanel;
	static JFrame OnePlayerFrame;
		
	public AboutFrame() {
		super ("Connect Four");
				
		setLayout(new FlowLayout());
		final JButton instructions = new JButton("Instructions");
		final JButton main = new JButton("Main Menu");
		final JButton quit = new JButton("Quit");
		JLabel boardLabel = new JLabel("Game Board");
		ImageIcon boardImage = new ImageIcon(getClass().getResource("/images/about.png"));
		boardLabel = new JLabel(boardImage);		
		
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(100,100));
		setTitle("Connect Four");
		
		// Add action listeners
				main.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						PlayConnectFour.makeMeVisible(PlayConnectFour.gMainFrame);
						
					}

					});	
		
		// Add action listeners
				quit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
										
							int action = JOptionPane.showConfirmDialog(AboutFrame.this,
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
		
		// Add components
		add(main);
		add(instructions);
		add(quit);
		add(boardLabel);
		
	}


}
