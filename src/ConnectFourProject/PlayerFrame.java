package ConnectFourProject;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PlayerFrame extends JFrame {

	public PlayerFrame() {
		super ("Connect Four");

		final JButton beginGame = new JButton("Begin Game");
		final JButton quit = new JButton("Quit");
	    getRootPane().setDefaultButton(beginGame);

		JLabel chooseColor = new JLabel("Choose your disc color.");

		String[] color_default = {"Red Discs", "Black Discs"};
		final JComboBox<String> colors = new JComboBox<String>(color_default);

		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setMinimumSize(new Dimension(100,100));
		setTitle("Connect Four One Player Setup");
		setLayout(new FlowLayout());

		JLabel text1 = new JLabel("Enter First Player's name");
		final JTextField firstPlayer = new JTextField(15);

		// Add action listeners
		beginGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String player1 = firstPlayer.getText();	
				firstPlayer.setEditable(false);

				String color = "";

				String colorChoice = colors.getSelectedItem().toString();

				if (colorChoice.equals("Red Discs")) {
					color = "red";
				} else {
					color = "black";

				}

				Player p1 = new Player(player1, color);

//				System.out.println("Player1: " + p1.getName());
//				System.out.println("Disc color: " + p1.getColor());
//				System.out.println("Player1 Score: " + p1.getScore());
//				
//		        JFrame frame = new JFrame("Connect Four - Team B11");
//		        JPanel panel = (JPanel) frame.getContentPane();
//		        
//		        //assigning the JFrame properties and making the window not sizable
//		        frame.setContentPane(panel);
//		        frame.setSize(650, 500);
//		        frame.setVisible(true);
//		        frame.setResizable(false);
//		        frame.setLocationRelativeTo(null);
//		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				PlayConnectFour.gBoardFrame.setPlayer1(p1);
		        PlayConnectFour.makeMeVisible(PlayConnectFour.gBoardFrame);
			}
			});	


		// Add action listeners
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int action = JOptionPane.showConfirmDialog(PlayerFrame.this,
						"Are you sure you want to quit Connect Four?",
						"Confirm Exit", JOptionPane.OK_CANCEL_OPTION);

				// exit the game if they no longer want to play...
				if (action != JOptionPane.OK_CANCEL_OPTION) {
					System.exit(0);
				}

			}

		});	
		
		

		// Add components
		add(text1);
		add(firstPlayer);
		add(chooseColor);
		add(colors);
		add(beginGame);
		add(quit);

	}

} 

