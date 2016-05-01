package ConnectFourProject;

import javax.swing.JFrame;

public class PlayConnectFour {

	static JFrame gMainFrame;
	static JFrame gPlayerFrame;
	static JFrame gAboutFrame;
	static JFrame gInstructionsFrame;
	static ConnectFourFrame gBoardFrame;

	// start of the game
	public static void main(String[] args) {

		//creates required frames be be used throughout the game
		gMainFrame = new MainFrame();
		gAboutFrame = new AboutFrame();
		gInstructionsFrame = new InstructionsFrame();
		gBoardFrame = new ConnectFourFrame(0);

		// set screen to visible  this is the screen with options
		PlayConnectFour.makeMeVisible(PlayConnectFour.gMainFrame);
		runGame();
	}

	// calls the game
	public static void runGame() {
		int gameCurStatus = 0;
		int humanWins = 0, cpuWins = 0;

		// start the game and keep track of the wins and losses
		while (gameCurStatus != -1) {
			switch (gameCurStatus) {
			case 0:
				if (gBoardFrame.getHasWon()) {
					gameCurStatus = 1;
				} else if (gBoardFrame.getHasDraw()) {
					gameCurStatus = 2;
				} else if (gBoardFrame.getNewGame()) {
					gBoardFrame.dispose();
					gBoardFrame = new ConnectFourFrame(humanWins + cpuWins);
					makeMeVisible(gBoardFrame);
					gameCurStatus = 0;
				}
				break;
			case 1:
				// determine who won the game
				// user wins the game
				if (gBoardFrame.getWinner() == 1) {
					humanWins++;
				// computer wins the game
				} else if (gBoardFrame.getWinner() == 2) {
					cpuWins++;
				}
				// display the game score and winner
				gBoardFrame.displayWin(humanWins, cpuWins);
				if (gBoardFrame.getExit()) {
					gameCurStatus = -1;
				} else if (gBoardFrame.getNewGame()) {
					gBoardFrame.dispose();
					gBoardFrame = new ConnectFourFrame(humanWins + cpuWins);
					makeMeVisible(gBoardFrame);

					gameCurStatus = 0;
				}
				break;
			case 2:
				// no one wins the game
				gBoardFrame.displayDraw();
				if (gBoardFrame.getExit()) {
					gameCurStatus = -1;
				} else if (gBoardFrame.getNewGame()) {
					gBoardFrame.dispose();
					gBoardFrame = new ConnectFourFrame(humanWins + cpuWins);
					makeMeVisible(gBoardFrame);
					gameCurStatus = 0;
				}
				break;
			}

		}
	}

	// hide all frames and make them visible as required
	public static void hideAll() {
		gMainFrame.setVisible(false);
		gAboutFrame.setVisible(false);
		gInstructionsFrame.setVisible(false);
		gBoardFrame.setVisible(false);
	}

	// make only specific frame visible
	public static void makeMeVisible(JFrame frame) {
		hideAll();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
