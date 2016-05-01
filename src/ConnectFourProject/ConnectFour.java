package ConnectFourProject;

public class ConnectFour {

	public static void main(String[] args) {

		// runGame(frame, panel);
		runGame();
	}

	public static void runGame() {
		int gameCurStatus = 0;
		int humanWins = 0, cpuWins = 0;

		ConnectFourGUI newGame = new ConnectFourGUI(0);

		while (gameCurStatus != -1) {
			//System.out.println("Checking Game Status...");
			switch (gameCurStatus) {
			case 0:
				if (newGame.getHasWon()) {
					gameCurStatus = 1;
				} else if (newGame.getHasDraw()) {
					gameCurStatus = 2;
				} else if (newGame.getNewGame()) {
					newGame = new ConnectFourGUI(humanWins + cpuWins);
					gameCurStatus = 0;
				}
				break;
			case 1:
				if (newGame.getWinner() == 1) {
					humanWins++;
				} else if (newGame.getWinner() == 2) {
					cpuWins++;
				}
				newGame.displayWin(humanWins, cpuWins);
				if (newGame.getExit()) {
					gameCurStatus = -1;
				} else if (newGame.getNewGame()) {
					newGame = new ConnectFourGUI(humanWins + cpuWins);
					gameCurStatus = 0;
				}
				break;
			case 2:
				newGame.displayDraw();
				if (newGame.getExit()) {
					gameCurStatus = -1;
				} else if (newGame.getNewGame()) {
					newGame = new ConnectFourGUI(humanWins + cpuWins);
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
}
