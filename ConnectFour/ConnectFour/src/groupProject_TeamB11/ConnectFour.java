package groupProject_TeamB11;
  
public class ConnectFour { 

    public static void main(String[] args) { 
    
        int gameCurStatus = 0;

        //This section is logic to connect the main app to the gui so that the app knows when a 
        //player has quit, won a game, or ended in a draw.  The GUI class will pass the status back to the app to perform
        //the appropriate action
        ConnectFourGUI newGame = new ConnectFourGUI();
            while (gameCurStatus != -1) {
                switch (gameCurStatus) {
                    case 0:
                        if (newGame.getHasWon()) {
                        	gameCurStatus = 1;
                        } else if (newGame.getHasDraw()) {
                        	gameCurStatus = 2;
                        } else if (newGame.getNewGame()) {
                        	newGame = new ConnectFourGUI();
                        	gameCurStatus = 0;
                        }
                        break;
                    case 1:
                    	newGame.displayWin();
                        if (newGame.getExit()) {
                        	gameCurStatus = -1;
                        } else  if (newGame.getNewGame()) {
                        	newGame = new ConnectFourGUI();
                        	gameCurStatus = 0;
                        }
                        break;
                    case 2:
                    	newGame.displayDraw();
                        if (newGame.getExit()) {
                        	gameCurStatus = -1;
                        } else if (newGame.getNewGame()) {
                        	newGame = new ConnectFourGUI();
                        	gameCurStatus = 0;
                        }
                        break;
                }
            }
        
    } 
} 
