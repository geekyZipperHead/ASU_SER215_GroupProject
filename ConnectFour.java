package groupProject_TeamB11;

public class ConnectFour {
    private static boolean isWin = false;
    private static int[][] gameGrid = new int[6][7];
    private final static int computerPlayer = 0, humanPlayer=1, emptySpace=-1;
    public static void main(String[] args) {
    
        //initialize the array, set each element = -1
        for (int iRow = 0; iRow < 6; iRow ++){
            for (int iCol = 0; iCol < 7; iCol++){
                gameGrid[iRow][iCol] = emptySpace;
            }                
        }
        
        /*
         test cases to check for win or not
         
        gameGrid[0][0] = 0;
        gameGrid[0][1] = 0;
        gameGrid[0][2] = 0;
        gameGrid[0][3] = 0;
       
        gameGrid[0][0] = 0;
        gameGrid[1][1] = 0;
        gameGrid[2][2] = 0;
        gameGrid[3][3] = 0;
        
        gameGrid[0][6] = 0;
        gameGrid[1][5] = 0;
        gameGrid[2][4] = 0;
        gameGrid[3][3] = 0;
        
        gameGrid[2][2] = 0;
        gameGrid[3][3] = 0;
        gameGrid[4][4] = 0;
        gameGrid[5][5] = 0;
         */
        

        if(calculateWin()==true){
            System.out.println("You win!");
        }
        else
        {
            System.out.println("Next turn");
        }
    }
    
    private static boolean calculateWin(){       

        // check for a horizontal win on the game board
        for (int iRow=0; iRow<6; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
                if (gameGrid[iRow][iCol] != -1 &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+3]) {
                	isWin = true;
                }
            }
        }
        // check for a vertical win on the game board
        for (int iRow=0; iRow<3; iRow++) {
            for (int iCol=0;iCol<7; iCol++) {
                if (gameGrid[iRow][iCol] != -1 &&
                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol] &&
                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol] &&
                gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol]) {
                	isWin = true;
                }
            }
        }
        // check for a diagonal win (descending diagonal)
        for (int iRow=0; iRow<3; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
                if (gameGrid[iRow][iCol] != -1 &&
                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] &&
                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] &&
                gameGrid[iRow][iCol] == gameGrid[iRow+3][iCol+3]) {
                	isWin = true;
                }
            }
        }
        // check for a diagonal win (ascending diagonal)
        for (int iRow=3; iRow<6; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
            if (gameGrid[iRow][iCol] != -1 &&
                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] &&
                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] &&
                gameGrid[iRow][iCol] == gameGrid[iRow-3][iCol+3]) {
            	isWin = true;
                }
            }
        }    
        return isWin;
    }

    private static int[] computerAI(){       

    	int[] iComputerMove = new int[2];
    	
        // check for a horizontal 3 in a row
        for (int iRow=0; iRow<6; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
                if (gameGrid[iRow][iCol] == humanPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] &&
                gameGrid[iRow][iCol+3] == emptySpace) {	                
                	iComputerMove[0] = iRow;
                	iComputerMove[1] = iCol+3;
                	return iComputerMove;
                }
            }
        }
        
        // check for a vertical 3 in a row
        for (int iRow=0; iRow<3; iRow++) {
            for (int iCol=0;iCol<7; iCol++) {
                if (gameGrid[iRow][iCol] ==humanPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol] &&
                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol] &&
                gameGrid[iRow+3][iCol]==emptySpace) {
                	iComputerMove[0] = iRow+3;
                	iComputerMove[1] = iCol;
                	return iComputerMove;
                }
            }
        }
        // check for a diagonal  3 in a row (descending diagonal)
        for (int iRow=0; iRow<3; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
                if (gameGrid[iRow][iCol] ==humanPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol+1] &&
                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol+2] &&
                gameGrid[iRow+3][iCol+3]==emptySpace && gameGrid[iRow+2][iCol+3]!=emptySpace) {
                	iComputerMove[0] = iRow+3;
                	iComputerMove[1] = iCol+3;
                	return iComputerMove;
                }
            }
        }
        // check for a diagonal  3 in a row (ascending diagonal)
        for (int iRow=3; iRow<6; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
            if (gameGrid[iRow][iCol] ==humanPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow-1][iCol+1] &&
                gameGrid[iRow][iCol] == gameGrid[iRow-2][iCol+2] &&
                gameGrid[iRow-3][iCol+3]==emptySpace && gameGrid[iRow-2][iCol+3]!=emptySpace) {
            	iComputerMove[0] = iRow-3;
            	iComputerMove[1] = iCol+3;
            	return iComputerMove;
                }
            }
        }
        
        //If no blocking moves found, begin offensive checks
        
        // check for a horizontal 3 in a row
        for (int iRow=0; iRow<6; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
                if (gameGrid[iRow][iCol] == computerPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+2] &&
                gameGrid[iRow][iCol+3] == emptySpace) {	                
                	iComputerMove[0] = iRow;
                	iComputerMove[1] = iCol+3;
                    return iComputerMove;
                }
            }
        }
        
        // check for a vertical 3 in a row
        for (int iRow=0; iRow<3; iRow++) {
            for (int iCol=0;iCol<7; iCol++) {
                if (gameGrid[iRow][iCol] ==computerPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol] &&
                gameGrid[iRow][iCol] == gameGrid[iRow+2][iCol] &&
                gameGrid[iRow+3][iCol]==emptySpace) {
                	iComputerMove[0] = iRow+3;
                	iComputerMove[1] = iCol;
                	return iComputerMove;
                }
            }
        }
        
        //check for horizontal 2 in a row
        for (int iRow=0; iRow<6; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
                if (gameGrid[iRow][iCol] == computerPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow][iCol+1] &&
                gameGrid[iRow][iCol+2] == emptySpace) {	                
                	iComputerMove[0] = iRow;
                	iComputerMove[1] = iCol+2;
                    return iComputerMove;
                }
            }
        }

        // check for a vertical 2 in a row
        for (int iRow=0; iRow<3; iRow++) {
            for (int iCol=0;iCol<7; iCol++) {
                if (gameGrid[iRow][iCol] ==computerPlayer &&
                gameGrid[iRow][iCol] == gameGrid[iRow+1][iCol] &&
                gameGrid[iRow+2][iCol]==emptySpace) {
                	iComputerMove[0] = iRow+2;
                	iComputerMove[1] = iCol;
                	return iComputerMove;
                }
            }
        }
        
        
        //check for horizontal 1 in a row
        for (int iRow=0; iRow<6; iRow++) {
            for (int iCol=0; iCol<4; iCol++) {
                if (gameGrid[iRow][iCol] == computerPlayer &&
                gameGrid[iRow][iCol+1] == emptySpace) {	                
                	iComputerMove[0] = iRow;
                	iComputerMove[1] = iCol+1;
                    return iComputerMove;
                }
            }
        }

        // check for a vertical 1 in a row
        for (int iRow=0; iRow<3; iRow++) {
            for (int iCol=0;iCol<7; iCol++) {
                if (gameGrid[iRow][iCol] ==computerPlayer &&
                gameGrid[iRow+1][iCol]==emptySpace) {
                	iComputerMove[0] = iRow+1;
                	iComputerMove[1] = iCol;
                	return iComputerMove;
                }
            }
        }
        
        //check for first empty slot to place a piece in bottom row
        for (int iCol=0; iCol<7; iCol++) {
            if (gameGrid[5][iCol] == emptySpace) {	                
            	iComputerMove[0] = 5;
            	iComputerMove[1] = iCol;
                return iComputerMove;
            }
        }

        return iComputerMove;
    }
}