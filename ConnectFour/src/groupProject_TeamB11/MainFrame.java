
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
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
		
	public MainFrame() {
		super ("Connect Four");
				
		final JButton instructions = new JButton("Instructions");
		final JButton play = new JButton("Play");
		final JButton quit = new JButton("Quit");
		final JButton about = new JButton("About");
		JLabel label = new JLabel();
		label.setIcon(new ImageIcon("~/documents/workspace/PlayConnectFour/mainScreen.png"));
		
		String[] players_default = {"One Player", "Two Player"};
		final JComboBox<String> players = new JComboBox<String>(players_default);
		
		setSize(200,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(100,100));
		setTitle("Connect Four");
		setLayout(new FlowLayout());
		
		// Add action listeners
		play.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								
					String game = players.getSelectedItem().toString();
					
					if (game.equals("One Player")) {
						new OnePlayerFrame();						
					} else {
						new TwoPlayerFrame();
					}
			}

			});		
		
		// Add components
		add(instructions);
		add(players);
		add(play);
		add(quit);
		add(about);
		
		setVisible(true);
	}

}
