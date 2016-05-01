package ConnectFourProject;


import javax.swing.JFrame;

public class PlayConnectFour {
	
	static JFrame gMainFrame;
	static JFrame gGameFrame;
	static JFrame gPlayerFrame;
	static JFrame gAboutFrame;
	static JFrame gInstructionsFrame;
	static ConnectFourFrame gBoardFrame;

	
	public static void main(String[] args) {

		gMainFrame = new MainFrame();
		gGameFrame = new GameFrame();
		gPlayerFrame = new PlayerFrame();
		gAboutFrame = new AboutFrame();
		gInstructionsFrame = new InstructionsFrame();
		gBoardFrame = new ConnectFourFrame(0);
		
		PlayConnectFour.makeMeVisible(PlayConnectFour.gMainFrame);
		runGame();

//		SwingUtilities.invokeLater(new Runnable() {
//			
//			public void run() {
//
//				 gMainFrame = new MainFrame();
//			}
//		});

	}
	
	public static void runGame() {
		int gameCurStatus = 0;
		int humanWins = 0, cpuWins = 0;

		while (gameCurStatus != -1) {
			//System.out.println("Checking Game Status...");
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
				if (gBoardFrame.getWinner() == 1) {
					humanWins++;
				} else if (gBoardFrame.getWinner() == 2) {
					cpuWins++;
				}
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

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// do nothing
			}
		}
	}


	public static void hideAll() {
		gMainFrame.setVisible(false);
		gGameFrame.setVisible(false);
		gPlayerFrame.setVisible(false);
		gAboutFrame.setVisible(false);
		gInstructionsFrame.setVisible(false);
		gBoardFrame.setVisible(false);
	}
	
	public static void makeMeVisible(JFrame frame) {
		hideAll();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
